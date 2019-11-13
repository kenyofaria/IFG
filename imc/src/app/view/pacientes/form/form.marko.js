// Compiled using marko@4.18.14 - DO NOT EDIT
"use strict";

var marko_template = module.exports = require("marko/src/html").t(__filename),
    marko_componentType = "/daw2$1.0.0/src/app/view/pacientes/form/form.marko",
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

  out.w("<html><head><meta charset=\"utf-8\"><link rel=\"stylesheet\" href=\"/estatico/css/bootstrap.min.css\"><link rel=\"stylesheet\" href=\"/estatico/css/fontawesome.min.css\"><link rel=\"stylesheet\" href=\"/estatico/css/imc.css\"></head><body>");

  component_globals_tag({}, out);

  out.w("<header class=\"cabecalhoPrincipal\"><div class=\"container\"><div class=\"row align-items-center\"><div class=\"col-4\"><h1 class=\"logo\"><img src=\"/estatico/imagens/logo-cabecalhoPrincipal.jpg\" alt=\"IMC\"></h1></div><div class=\"cabecalhoPrincipal-navegacao col-8\"><a href=\"#\" class=\"login\"><i class=\"fas fa-sign-in-alt\"></i>Login</a></div></div></div></header><main class=\"conteudoPrincipal\"><div class=\"container\"><h1>Cadastro de pacientes</h1>");

  if (data.errosValidacao) {
    out.w("<div>");

    var $for$0 = 0;

    marko_forEach(data.errosValidacao, function(erro) {
      var $keyScope$0 = "[" + (($for$0++) + "]");

      out.w("<div class=\"alert alert-danger\">" +
        marko_escapeXml(erro.param) +
        " - " +
        marko_escapeXml(erro.msg) +
        "</div>");
    });

    out.w("</div>");
  }

  out.w("<form action=\"/pacientes/form\" method=\"post\">");

  if (data.paciente.id) {
    out.w("<div><input type=\"hidden\" name=\"_method\" value=\"PUT\"><input type=\"hidden\" name=\"id\"" +
      marko_attr("value", "" + data.paciente.id) +
      "></div>");
  }

  out.w("<div class=\"form-group\"><label for=\"nome\">nome:</label><input" +
    marko_attr("value", "" + data.paciente.nome) +
    " type=\"text\" id=\"nome\" name=\"nome\" placeholder=\"informe o nome\" class=\"form-control\"></div><div class=\"form-group\"><label for=\"peso\">peso:</label><input" +
    marko_attr("value", "" + data.paciente.peso) +
    " type=\"text\" id=\"peso\" name=\"peso\" placeholder=\"0.0\" class=\"form-control\"></div><div class=\"form-group\"><label for=\"altura\">altura:</label><input" +
    marko_attr("value", "" + data.paciente.altura) +
    " type=\"text\" id=\"altura\" name=\"altura\" placeholder=\"0.0\" class=\"form-control\"></div><input type=\"submit\" value=\"Salvar\" class=\"btn btn-primary\"></form></div></main>");

  init_components_tag({}, out);

  await_reorderer_tag({}, out, __component, "35");

  out.w("</body></html>");
}

marko_template._ = marko_renderer(render, {
    ___implicit: true,
    ___type: marko_componentType
  });

marko_template.Component = marko_defineComponent({}, marko_template._);

marko_template.meta = {
    id: "/daw2$1.0.0/src/app/view/pacientes/form/form.marko",
    tags: [
      "marko/src/core-tags/components/component-globals-tag",
      "marko/src/core-tags/components/init-components-tag",
      "marko/src/core-tags/core/await/reorderer-renderer"
    ]
  };
