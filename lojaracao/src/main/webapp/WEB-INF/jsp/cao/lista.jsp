<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.repository.CaoRepository, 
br.edu.infnet.lojaracao.model.domain.Cao, br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
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
			<h1>Lista de rações de cães</h1>
			<h2>
				Total:
				<c:if test="${funcionarioLogado.isAdmin()}">
					<c:out value="${cao.obterLista().size()}"></c:out>
				</c:if>
				<c:if test="${funcionarioLogado.isAdmin() eq false}">
					<c:out value="${cao.obterLista(funcionarioLogado).size()}"></c:out>
				</c:if>
			</h2>
			<h3>${statusRacao}</h3>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Nome</th>
						<th class="table-info">Código</th>
						<th class="table-info">Preço</th>
						<th class="table-info">Sem Corantes</th>
						<th class="table-info">Filhotes</th>
						<th class="table-info">Porte</th>
						<th class="table-info"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${funcionarioLogado.isAdmin()}">
						<c:forEach var="cao" items="${cao.obterLista()}">
							<tr>
								<td>${cao.getNome()}</td>
								<td>${cao.getCodigo()}</td>
								<td>R$${cao.getPreco()}</td>
								<c:if test="${cao.isSemCorante()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${cao.isSemCorante() eq false}">
									<td>Não</td>
								</c:if>
								<c:if test="${cao.isFilhotes()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${cao.isFilhotes() eq false}">
									<td>Não</td>
								</c:if>
								<td>${cao.getPorte()}</td>
								<td>
									<form action="/lista/cao">
										<button type="submit" value="${cao.id}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${funcionarioLogado.isAdmin() eq false}">
						<c:forEach var="cao" items="${cao.obterLista(funcionarioLogado)}">
							<tr>
								<td>${cao.getNome()}</td>
								<td>${cao.getCodigo()}</td>
								<td>R$${cao.getPreco()}</td>
								<c:if test="${cao.isSemCorante()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${cao.isSemCorante() eq false}">
									<td>Não</td>
								</c:if>
								<c:if test="${cao.isFilhotes()}">
									<td>Sim</td>
								</c:if>
								<c:if test="${cao.isFilhotes() eq false}">
									<td>Não</td>
								</c:if>
								<td>${cao.getPorte()}</td>
								<td>
									<form action="/lista/cao">
										<button type="submit" value="${cao.id}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="form-group, bottomButton">
			<a href="/cadastro/cao"><button class="btn btn-primary">Nova
					Ração</button></a>
		</div>
	</div>
</body>
</html>