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
</head>
<body>
	<div class="container">
		<h1 class="form-group">Cadastrar Endereco:</h1>
		<h2>${statusEndereco}</h2>
		<form action="/cep/pesquisar" method="get">
			<label>CEP</label> <input type="text" required name="cep"
				value="36684020" placeholder="Ex: 00000000">
			<button type="submit" value="cep">Pesquisar</button>
		</form>
		<b>${cep}</b> <b>${logradouro}</b> <b>${complemento}</b> <b>${bairro}</b>
		<b>${localidade}</b> <b>${uf}</b>
	</div>
</body>
</html>