let tabelaPacientes = document.querySelector('#tabela-pacientes');
tabelaPacientes.addEventListener('click', (evento) => {
    let elementoClicado = evento.target;

    if (elementoClicado.dataset.type == 'remocao') {
        let pacienteId = elementoClicado.dataset.ref;
        //fetch(`http://localhost:3000/pacientes/${pacienteId}`, { method: 'DELETE' })
        fetch(`/pacientes/${pacienteId}`, { method: 'DELETE' })
            .then(resposta => {

                let tr = elementoClicado.closest(`#paciente_${pacienteId}`);
                tr.remove();
            })
            .catch(erro => console.log(erro));
    }
});