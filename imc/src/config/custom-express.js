require("marko/node-require").install; // Allow Node.js to require and load `.marko` files
require("marko/express");

const express = require('express');
const expressModule = express();
const bodyParser = require('body-parser');
const methodOverride = require('method-override');

expressModule.use('/estatico', express.static('src/app/public'));

expressModule.use(
    bodyParser.urlencoded({
        extended:true
 })
 );
 expressModule.use(methodOverride(function (req, res) {
    if (req.body && typeof req.body === 'object' && '_method' in req.body) {
      // look in urlencoded POST bodies and delete it
      var method = req.body._method;
      delete req.body._method;
      return method;
    }
}));

const sessaoAutenticacao = require('./sessao-autenticacao');
sessaoAutenticacao(expressModule);

const rotas = require('../app/rotas/rotas');
rotas(expressModule);

expressModule.use(function(req, resp, next){
  //resp.redirect('https://google.com');
  return resp.status(404).marko(
    require('../app/view/base/erros/404.marko')
  );
});

expressModule.use(function(erro, req, resp, next){
  console.log(erro);
  return resp.status(500).marko(
    require('../app/view/base/erros/500.marko')
  );
});

module.exports = expressModule;