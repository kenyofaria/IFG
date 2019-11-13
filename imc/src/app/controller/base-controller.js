const PacienteController = require('./paciente-controller');

class BaseController{

    static rotas(){
        return {
            home: '/',
            login: '/login'
        };
    }

    home(){
        return function(req, resp){
            resp.marko(require('../view/base/home/home.marko'));
        }
    }

    login(){
        return function(req, resp){
            resp.marko(require('../view/base/login/login.marko'));
        }
    }

    efetuaLogin(){
        return function(req, resp, next){
            const passport = req.passport;
            passport.authenticate('local', (erro, usuario, info) => {
                if(info){
                    return resp.marko(require('../view/base/login/login.marko'));
                }
                if(erro){
                    return next(erro);
                }
                req.login(usuario, (erro) => {
                    if(erro){
                        return next(erro);
                    }
                    return resp.redirect(PacienteController.rotas().lista);
                });
            })(req, resp, next);
        };
    }

}
module.exports = BaseController;