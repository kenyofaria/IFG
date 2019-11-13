const db = require('../../config/database');
const PacienteDao = require('../dao/paciente-dao');
const { validationResult } = require('express-validator/check');

class PacienteController{

    static rotas(){
        return {
            lista: '/pacientes/lista',
            cadastro: '/pacientes/form',
            edicao: '/pacientes/form/:id',
            exclusao: '/pacientes/:id'
        }
    }

    lista(){
        return function(req, resp){
            const pacienteDao = new PacienteDao(db);
            pacienteDao.lista()
                        .then(listaDePacientes => resp.marko(
                            require('../view/pacientes/lista/lista.marko'),
                            {
                                pacientes: listaDePacientes
                            }
                        ))
                        .catch(erro => {
                            console.log(erro);
                        });
        }
    }

    formularioCadastro(){
        return function(req, resp){
            resp.marko(
                require('../view/pacientes/form/form.marko'),
                {paciente: 
                    {
                        nome:'', 
                        peso:'', 
                        altura:''
                    }
                }    
            );
        }
    }

    formularioEdicao(){
        return function(req, resp){
            const id = req.params.id;
            const pacienteDao = new PacienteDao(db);

            pacienteDao.buscaPorId(id)
                        .then(
                            paciente => resp.marko(
                                require('../view/pacientes/form/form.marko'),
                                {paciente: paciente}
                            )
                        )
                        .catch(erro => console.log(erro));
        }
    }

    cadastra(){
        return function(req, resp){
            const erros = validationResult(req);
            if(!erros.isEmpty()){
                return resp.marko(require('../view/pacientes/form/form.marko'),
                                    { 
                                        paciente: req.body,
                                        errosValidacao: erros.array()
                                    }   
                                 )
            }else{
                const pacienteDAO = new PacienteDao(db);
                pacienteDAO.adiciona(req.body)
                            .then(
                                resp.redirect(PacienteController.rotas().lista)
                            )
                            .catch(
                                erro => console.log(erro)
                            );
                }
        }
    }

    atualiza(){
        return function(req, resp){
            const pacienteDAO = new PacienteDao(db);
            pacienteDAO.altera(req.body)
                        .then(
                            resp.redirect(PacienteController.rotas().lista)
                        )
                        .catch(
                            erro => console.log(erro)
                        );
        }
    }

    remove(){
        return function(req, resp){
            const id = req.params.id;
            const pacienteDAO = new PacienteDao(db);
            pacienteDAO.remove(id)
                .then(()=>resp.status(200).end())
                .catch((erro) => console.log(erro));
        }
    }
}
module.exports = PacienteController;