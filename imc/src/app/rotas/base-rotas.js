const BaseController = require('../controller/base-controller');
const baseController = new BaseController();

module.exports = function(app){
   
    const rotasBase = BaseController.rotas();
    app.get(rotasBase.home, baseController.home());
    app.get(rotasBase.login, baseController.login());
    app.post(rotasBase.login, baseController.efetuaLogin());

};


