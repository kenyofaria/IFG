// Compiled using marko@4.18.14 - DO NOT EDIT
"use strict";

var marko_template = module.exports = require("marko/src/html").t(__filename),
    marko_componentType = "/daw2$1.0.0/src/app/view/pacientes/lista/lista.marko",
    components_helpers = require("marko/src/runtime/components/helpers"),
    marko_renderer = components_helpers.r,
    marko_defineComponent = components_helpers.c,
    marko_helpers = require("marko/src/runtime/html/helpers"),
    marko_loadTag = marko_helpers.t,
    component_globals_tag = marko_loadTag(require("marko/src/core-tags/components/component-globals-tag")),
    marko_forEach = marko_helpers.f,
    marko_escapeXml = marko_helpers.x,
    marko_attr = marko_helpers.a,
    init_components_tag = marko_loadTag(require("marko/src/core-tags/components/init-components-tag")),
    await_reorderer_tag = marko_loadTag(require("marko/src/core-tags/core/await/reorderer-renderer"));

function render(input, out, __component, component, state) {
  var data = input;

  out.w("<html><head><meta charset=\"utf-8\"><link rel=\"stylesheet\" href=\"/estatico/css/bootstrap.min.css\"><link rel=\"stylesheet\" href=\"/estatico/css/fontawesome.min.css\"><link rel=\"stylesheet\" href=\"/estatico/css/imc.css\"><title>Cálculo do IMC</title></head><body>");

  component_globals_tag({}, out);

  out.w("<header class=\"cabecalhoPrincipal\"><div class=\"container\"><div class=\"row align-items-center\"><div class=\"col-4\"><h1 class=\"logo\"><img src=\"/estatico/imagens/logo-principal.jpg\" alt=\"IMC\"></h1></div><div class=\"cabecalhoPrincipal-navegacao col-8\"><a href=\"#\" class=\"login\"><i class=\"fas fa-sign-in-alt\"></i>Login</a></div></div></div></header><main class=\"conteudoPrincipal\"><div class=\"container\"><h1> pacientes cadastrados </h1><table class=\"table table-striped table-hover\"><thead class=\"thead-dark\"><tr> <th>Nome</th><th>Peso (Kg)</th><th>Altura (m)</th><th>IMC</th><th></th><th></th></tr></thead><tbody id=\"tabela-pacientes\">");

  var $for$0 = 0;

  marko_forEach(data.pacientes, function(paciente) {
    var $keyScope$0 = "[" + (($for$0++) + "]");

    out.w("<tr" +
      marko_attr("id", "paciente_" + paciente.id) +
      "><td> " +
      marko_escapeXml(paciente.nome) +
      " </td><td> " +
      marko_escapeXml(paciente.peso) +
      " </td><td> " +
      marko_escapeXml(paciente.altura) +
      " </td><td> " +
      marko_escapeXml(paciente.imc) +
      " </td><td><a" +
      marko_attr("href", "/pacientes/form/" + paciente.id) +
      ">editar</a></td><td><a href=\"#\"" +
      marko_attr("data-ref", "" + paciente.id) +
      " data-type=\"remocao\">remover</a></td></tr>");
  });

  out.w("</tbody></table> </div></main><footer class=\"rodape\"><div class=\"container\"><div class=\"row align-items-center\"><div class=\"col-4\"><img src=\"/estatico/imagens/logo-rodape.jpg\" class=\"logo-rodape\"></div><div class=\"col-8\"><ul class=\"redesSociais\"><li><a href=\"#\" class=\"compartilhar-facebook\" target=\"_blank\">/imc</a></li><li><a href=\"#\" class=\"compartilhar-twitter\" target=\"_blank\">@imc</a></li></ul></div></div></div></footer><script src=\"/estatico/js/remove-paciente.js\"></script>");

  init_components_tag({}, out);

  await_reorderer_tag({}, out, __component, "51");

  out.w("</body></html>");
}

marko_template._ = marko_renderer(render, {
    ___implicit: true,
    ___type: marko_componentType
  });

marko_template.Component = marko_defineComponent({}, marko_template._);

marko_template.meta = {
    id: "/daw2$1.0.0/src/app/view/pacientes/lista/lista.marko",
    tags: [
      "marko/src/core-tags/components/component-globals-tag",
      "marko/src/core-tags/components/init-components-tag",
      "marko/src/core-tags/core/await/reorderer-renderer"
    ]
  };
