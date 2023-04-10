<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Cadastro</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<form action="/venda/incluir" method="post">
			<h1 class="form-group">Cadastre uma venda</h1>
			<div class="form-group">
				<label for="data">Data:</label> <input type="date" name="data" class="form-control" id="data">
			</div>
			<div class="form-group">
				<label>Para entregar: </label>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						name="entrega" value="true" class="form-check-input" checked>Sim
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label"> <input type="radio"
						name="entrega" value="false" class="form-check-input">Não
					</label>
				</div>
			</div>
			<div class="form-group">
				<label for="endereco">Endereço:</label> <input type="text"
					name="endereco" value="3211-1233" class="form-control"
					id="endereco">
			</div>
			<div class="form-group">
				<select name="cliente">
					<c:forEach var="c" items="${cliente.obterLista()}">
						<option value="${c.getNome()}">${c.getNome()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label>Rações:</label>
				<div class="form-check">
					<c:forEach var="r" items="${racao.obterLista()}">
						<label class="form-check-label"> <input type="checkbox"
							name="racoes" value="${r.getNome()}" class="form-check-input"
							checked>${r.getNome()}
						</label>
					</c:forEach>
				</div>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>