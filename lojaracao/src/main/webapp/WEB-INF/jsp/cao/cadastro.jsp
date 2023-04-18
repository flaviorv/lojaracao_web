<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.auxiliary.Constantes,
br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
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

.ckeckboxesAndRadios {
	display: flex;
	justify-content: space-around;
	align-items: center;
	text-align: center;
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
		<form action="/cao/incluir" method="post">
			<h1 class="form-group">Cadastre uma nova ração de cão</h1>
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="Ração de Cachorro 1" class="form-control">
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label> <input type="number" min="0"
					max="999999" name="codigo" value="1108" class="form-control">
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label> <input type="number" step="0.01"
					min="0.01" max="999999" name="preco" value="21"
					class="form-control">
			</div>
			<div class="ckeckboxesAndRadios">
				<div class="form-group">
					<label>Para Filhotes: </label>
					<div class="form-check">
						<input type="radio" name="filhotes" value="true"
							class="form-check-input">Sim

					</div>
					<div class="form-check">
						<input type="radio" name="filhotes" value="false"
							class="form-check-input" checked>Não

					</div>
				</div>
				<div class="form-group">
					<label>Sem Corante: </label>
					<div class="form-check">
						<input type="radio" name="semCorante" value="true"
							class="form-check-input">Sim

					</div>
					<div class="form-check">
						<input type="radio" name="semCorante" value="false"
							class="form-check-input" checked>Não

					</div>
				</div>
				<div class="form-group">
					<label>Porte:</label>
					<div class="form-check">
						<input type="radio" name="porte" value="<%=Constantes.PORTE1%>"
							class="form-check-input" checked>
						<%=Constantes.PORTE1%>

					</div>
					<div class="form-check">
						<input type="radio" name="porte" value="<%=Constantes.PORTE2%>"
							class="form-check-input">
						<%=Constantes.PORTE2%>

					</div>
					<div class="form-check">
						<input type="radio" name="porte" value="<%=Constantes.PORTE3%>"
							class="form-check-input">
						<%=Constantes.PORTE3%>

					</div>
				</div>
			</div>
			<div class="form-group, bottomButton">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>