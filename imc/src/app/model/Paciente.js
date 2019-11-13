const {check, validationResult} = require('express-validator/check');

class Paciente{

    static validacoes(){
        return [
            check('nome').isLength({min:3}).withMessage('Informe o nome'),
            check('altura').isDecimal().withMessage('altura inválida'),
            check('peso').isDecimal().withMessage('peso inválido')
        ];
    }
}
module.exports = Paciente;