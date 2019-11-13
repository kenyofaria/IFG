const PacienteController = require('../controller/paciente-controller');
const pacienteController = new PacienteController();
const Paciente = require('../model/Paciente');

module.exports = function(app){
    const rotasPaciente = PacienteController.rotas();
    
    app.get(rotasPaciente.lista, pacienteController.lista());

    app.route(rotasPaciente.cadastro)
    .get(pacienteController.formularioCadastro())
    .post(Paciente.validacoes(), pacienteController.cadastra())
    .put(pacienteController.atualiza());

    app.get(rotasPaciente.edicao, pacienteController.formularioEdicao());
    app.delete(rotasPaciente.exclusao, pacienteController.remove());

    //app.get(rotasPaciente.cadastro, pacienteController.formularioCadastro());

    //rota para adicionar um paciente
    //app.post(rotasPaciente.cadastro, Paciente.validacoes(), pacienteController.cadastra());

    //rota para alterar um paciente
    //app.put(rotasPaciente.cadastro,pacienteController.edita());
};