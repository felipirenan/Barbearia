/**
 * Confirmar a exclusao de um contato
 * 
 * 
 */

function confirmar(id) {
	let resposta = confirm("Confirma o  cancelamento deste Agendamento?")
	if (resposta === true) {
		window.location.href = "delete?id=" + id
	}
}