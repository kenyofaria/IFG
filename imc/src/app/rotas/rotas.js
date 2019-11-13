const pacienteRotas = require('./paciente-rotas');
const baseRotas = require('./base-rotas');

module.exports = (app) => {

    baseRotas(app);
    pacienteRotas(app);
}


