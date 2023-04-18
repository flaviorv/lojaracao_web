<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style type="text/css">
label {
	font-weight: bolder;
}

.cep, .cepResult {
	display: flex;
	align-content: center;
	justify-content: center;
	margin: 2%;
}

h1 {
	text-align: center;
	margin-top: 5%;
}
</style>
</head>
<body>
	<div class="container">
		<h1 class="form-group">Cadastrar Endereco:</h1>
		<h2>${statusEndereco}</h2>
		<form class="cep" action="/cep/pesquisar" method="get">
			<label>CEP:</label> <input type="text" required name="cep"
				value="36684020" placeholder="Ex: 00000000">
			<button type="submit" value="cep">Pesquisar</button>
		</form>
		<div class="cepResult">
			<b>${cep}&nbsp;</b> <b>${logradouro}&nbsp;</b> <b>${complemento}&nbsp;</b>
			<b>${bairro}&nbsp;</b> <b>${localidade}&nbsp;</b> <b>${uf}</b>
		</div>

	</div>
</body>
</html>