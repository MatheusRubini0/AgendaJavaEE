<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edição dos contatos</title>
<link rel="icon" href="imagens/agenda.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar contato</h1>
	<form name="frmContato" action="updates">
		<table>
			<tr>
				<td><input type="text" name="Idcon" readonly
					id = "caixa3" value = "<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome"
					class="Caixa1" value = "<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="telefone" placeholder="Telefone"
					class="Caixa2" value = "<%out.print(request.getAttribute("telefone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="E-mail"
					class="Caixa1" value = "<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" value="Adicionar" class="Botao1"
			onclick="validar()">
	</form>
	<script src="scripts/validador.js"></script>
</body>
</html>