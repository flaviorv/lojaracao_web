<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.repository.GatoRepository, 
br.edu.infnet.lojaracao.model.domain.Gato, br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Loja de Ração - Lista</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.3/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style type="text/css">
.table {
	text-align: center;
}

.bottomButton {
	display: flex;
	justify-content: center;
	align-items: center;
}

h1, .bottomButton {
	margin-top: 5%;
}
</style>
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<div class="form-group">

			<h1>Lista de rações de gato</h1>
			<h2>
				Total:
				<c:if test="${funcionarioLogado.isAdmin()}">
					<c:out value="${gato.obterLista().size()}"></c:out>
				</c:if>
				<c:if test="${funcionarioLogado.isAdmin() eq false}">
					<c:out value="${gato.obterLista(funcionarioLogado).size()}"></c:out>
				</c:if>
			</h2>
			<h3>${statusRacao}</h3>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Nome</th>
						<th class="table-info">Código</th>
						<th class="table-info">Preço</th>
						<th class="table-info">Filhotes</th>
						<th class="table-info">Castrado</th>
						<th class="table-info">Sabor</th>
						<th class="table-info"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${funcionarioLogado.isAdmin()}">
						<c:forEach var="gato" items="${gato.obterLista()}">
							<tr>
								<td>${gato.getNome()}</td>
								<td>${gato.getCodigo()}</td>
								<td>R$${gato.getPreco()}</td>
								<c:if test="${gato.isFilhotes()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${gato.isFilhotes() eq false}">
									<td>Não</td>
								</c:if>
								<c:if test="${gato.isCastrado()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${gato.isCastrado() eq false}">
									<td>Não</td>
								</c:if>
								<td>${gato.getSabor()}</td>
								<td>
									<form action="/lista/gato">
										<button type="submit" value="${gato.getId()}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${funcionarioLogado.isAdmin() eq false}">
						<c:forEach var="gato"
							items="${gato.obterLista(funcionarioLogado)}">
							<tr>
								<td>${gato.getNome()}</td>
								<td>${gato.getCodigo()}</td>
								<td>R$${gato.getPreco()}</td>
								<c:if test="${gato.isFilhotes()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${gato.isFilhotes() eq false}">
									<td>Não</td>
								</c:if>
								<c:if test="${gato.isCastrado()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${gato.isCastrado() eq false}">
									<td>Não</td>
								</c:if>
								<td>${gato.getSabor()}</td>
								<td>
									<form action="/lista/gato">
										<button type="submit" value="${gato.getId()}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="form-group, bottomButton">

			<a href="/cadastro/gato"><button class="btn btn-primary">Nova
					Ração</button></a>
		</div>
	</div>
</body>
</html>