const uuid = require('uuid/v4');
const sessao = require('express-session');
const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;

const UsuarioDao = require('../app/dao/usuario-dao');
const db = require('./database');

module.exports = (app) => {

    //implementação da estratégia de autenticação dos usuários
    passport.use(new LocalStrategy(
        {
            usernameField: 'email',
            passwordField: 'senha'
        },
        (email, senha, done) =>{
            const usuarioDao = new UsuarioDao(db);
            usuarioDao.buscaPorEmail(email)
                        .then(
                            usuario => {
                                if(!usuario || usuario.senha != senha){
                                    return done(null, false, {
                                        mensagem: 'login ou senha inválido'
                                    });
                                }
                                return done(null, usuario);
                            }
                        )
                        .catch(erro => done(erro, false));
        }
    ));

    passport.serializeUser((usuario, done) => {
        const usuarioSessao = {
            nome: usuario.nome_completo,  //nome_completo vem do banco de dados
            email: usuario.email
        };
        done(null, usuarioSessao);
    });

    passport.deserializeUser((usuarioSessao, done) => {
        done(null, usuarioSessao);
    });

    app.use(sessao({
        secret:'nossa chave secreta',
        genid: function(req){
            return uuid;
        },
        resave:false,
        saveUninitialized:false
    }));

    app.use(passport.initialize());
    app.use(passport.session());

    app.use(function(req, resp, next){
        req.passport = passport;
        next();
    });
}