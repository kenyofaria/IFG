class PacienteDao{

    constructor(db){
        this._db = db;
    }

    lista(){
        return new Promise((resolve, reject) => {
            this._db.all('select * from pacientes', (erro, resultados) => {
                if(erro){
                    console.log('-------------- Deu pau ------------------');
                    return reject('Deu pau');
                }else {
                    console.log(resultados);
                    return resolve(resultados);
                }
            });            
        });
    
    }

    buscaPorId(id) {
        return new Promise((resolve, reject) => {
            this._db.get(
                `
                    SELECT *
                    FROM pacientes
                    WHERE id = ?
                `,
                [id],
                (erro, paciente) => {
                    if (erro) {
                        return reject('Não foi possível encontrar o paciente!');
                    }
                    return resolve(paciente);
                }
            );
        });
    }

    adiciona(paciente){
        return new Promise(
            (resolve, reject)=>{
                this._db.run(
                    `insert into pacientes 
                    (nome, altura, peso)
                    values (?,?,?)`,
                    [paciente.nome, paciente.altura, paciente.peso],
                    (erro) =>{
                        if(erro){
                            console.log(erro);
                            return reject('Erro ao adicionar o paciente');
                        }
                        return resolve();
                    }
                );
            }
        );
    }

    altera(paciente){
        return new Promise(
            (resolve, reject)=>{
                this._db.run(
                    `update pacientes 
                    set nome = ?, altura = ?, peso = ?
                    where id = ?`,
                    [paciente.nome, paciente.altura, paciente.peso, paciente.id],
                    (erro) =>{
                        if(erro){
                            console.log(erro);
                            return reject('Erro ao adicionar o paciente');
                        }
                        return resolve();
                    }
                );
            }
        );
    }

    remove(id){
        return new Promise(
            (resolve, reject)=>{
                this._db.get(
                    `
                        delete
                        from pacientes
                        where id = ?
                    `,
                    [id],
                    (erro) => {
                        if(erro){
                            return reject('Erro ao excluir um paciente');
                        }
                        return resolve();
                    }
                );
            }
        );
    }
}
module.exports = PacienteDao;