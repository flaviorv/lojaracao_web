<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Nova Conta</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<style type="text/css">
.bottomButton {
	display: flex;
	justify-content: center;
}

label {
	font-weight: bolder;
}

h1, .bottomButton {
	text-align: center;
	margin-top: 5%;
}
</style>
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<form action="/funcionario/incluir" method="post">
			<h1 class="form-group">Criar conta de funcionário</h1>
			<h2>${status}</h2>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="Flávio" class="form-control" id="nome" required>
			</div>
			<div class="form-group">
				<label for="email">E-mail:</label> <input type="email" name="email"
					value="flavio@al.infnet.edu.com" class="form-control" id="email"
					required>
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label> <input type="password"
					name="senha" value="123" class="form-control" id="senha">
			</div>
			<div class="form-group, bottomButton">
				<button type="submit" class="btn btn-primary">Criar Conta</button>
			</div>
		</form>
	</div>
</body>
</html>