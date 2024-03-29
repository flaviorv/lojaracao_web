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

.checkboxesAndRadios {
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
		<form action="/ave/incluir" method="post">
			<h1 class="form-group">Cadastre uma nova ração de ave</h1>


			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text" name="nome"
					value="Ração de Ave 1" class="form-control">
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label> <input type="number" min="0"
					max="999999" name="codigo" value="2431" class="form-control">
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label> <input type="number" step="0.01"
					min="0.01" max="999999" name="preco" value="12.12"
					class="form-control">
			</div>
			<div class="form-group">
				<label for="peso">Peso:</label> <input type="number" step="0.1"
					min="0.1" max="999999" name="peso" value="12.1"
					class="form-control" id="peso">
			</div>
			<div class="checkboxesAndRadios">
				<div class="form-group, radio1">
					<label>Tipo de ave:</label>
					<div class="form-check">
						<input type="radio" name="tipo" value="<%=Constantes.TIPO1%>"
							class="form-check-input" checked>
						<%=Constantes.TIPO1%>

					</div>
					<div class="form-check">
						<input type="radio" name="tipo" value="<%=Constantes.TIPO2%>"
							class="form-check-input">
						<%=Constantes.TIPO2%>

					</div>
					<div class="form-check">
						<input type="radio" name="tipo" value="<%=Constantes.TIPO3%>"
							class="form-check-input">
						<%=Constantes.TIPO3%>

					</div>
				</div>

				<div class="form-group, radio2">
					<label>Aroma: </label>
					<div class="form-check">
						<input type="radio" name="aroma" value="<%=Constantes.AROMA1%>"
							class="form-check-input" checked>
						<%=Constantes.AROMA1%>

					</div>
					<div class="form-check">
						<input type="radio" name="aroma" value="<%=Constantes.AROMA2%>"
							class="form-check-input">
						<%=Constantes.AROMA2%>

					</div>
					<div class="form-check">
						<input type="radio" name="aroma" value="<%=Constantes.AROMA3%>"
							class="form-check-input">
						<%=Constantes.AROMA3%>

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