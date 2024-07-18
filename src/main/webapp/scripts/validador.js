function validar(){
	let nome = frmContato.nome.value
	let telefone= frmContato.telefone.value
	if(nome ===""){
		alert("preencha o campo nome")
		frmContato.nome.focus()
		return false
	}else if(telefone ===""){
		alert("preencha o campo Telefone")
				frmContato.telefone.focus()
				return false
	}else{
		document.forms["frmContato"].submit()
	}
}