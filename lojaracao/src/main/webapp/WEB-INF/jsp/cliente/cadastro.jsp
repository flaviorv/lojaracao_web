<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Cadastro</title>
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
		<div>
			<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp" />
		</div>
		<form action="/cliente/incluir" method="post">

			<input type="hidden" name="cep" value="${cep}"> <input type="hidden" name="logradouro"
				value="${logradouro}"> <input  type="hidden" name="complemento"
				value="${complemento}"> <input type="hidden"
				name="bairro" value="${bairro}"> <input type="hidden" name="localidade"
				value="${localidade}"> <input type="hidden" name="uf" value="${uf}">
			<h1 class="form-group">Cadastre um novo cliente</h1>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="Adriano" class="form-control" id="nome" required>
			</div>
			<div class="form-group">
				<label for="cpf">Cpf:</label> <input type="text" name="cpf"
					value="123.123.123.123-12" class="form-control" id="cpf" required>
			</div>
			<div class="form-group">
				<label for="telefone">Telefone:</label> <input type="text"
					name="telefone" value="3211-1233" class="form-control"
					id="telefone" required>
			</div>

			<c:if test="${not empty logradouro}">
				<div class="form-group, bottomButton">
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</div>
			</c:if>
			<c:if test="${empty logradouro}">
				<div class="form-group, bottomButton">
					<button type="submit" class="btn btn-primary"
						style="pointer-events: none; background-color: gray;">Cadastrar</button>
				</div>
			</c:if>
		</form>
	</div>
</body>
</html>