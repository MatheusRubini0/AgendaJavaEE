function confirmar(idcon){
	let resposta = confirm("Deseja confirmar a exclusão do contato?")
	
	if (resposta === true){
		window.location.href = "delete?idcon=" + idcon		
	}
}
