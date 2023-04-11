<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.repository.RacaoRepository, 
br.edu.infnet.lojaracao.model.domain.Racao, br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
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
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<div class="form-group">
			<h1>Listagem de todas as rações</h1>
			<h2>
				Total:
				<c:if test="${funcionarioLogado.isAdmin()}">
					<c:out value="${racao.obterLista().size()}"></c:out>
				</c:if>
				<c:if test="${funcionarioLogado.isAdmin() eq false}">
					<c:out value="${racao.obterLista(funcionarioLogado).size()}"></c:out>
				</c:if>
			</h2>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Nome</th>
						<th class="table-info">Código</th>
						<th class="table-info">Preço</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${funcionarioLogado.isAdmin()}">
						<c:forEach var="racao" items="${racao.obterLista()}">

							<tr>
								<td>${racao.getNome()}</td>
								<td>${racao.getCodigo()}</td>
								<td>${racao.getPreco()}</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${funcionarioLogado.isAdmin() eq false}">
						<c:forEach var="racao"
							items="${racao.obterLista(funcionarioLogado)}">
							<tr>
								<td>${racao.getNome()}</td>
								<td>${racao.getCodigo()}</td>
								<td>${racao.getPreco()}</td>
							</tr>
						</c:forEach>
					</c:if>

				</tbody>
			</table>
			<div class="form-group">
				<a href="/"><button class="btn btn-primary">Página
						inicial</button></a>
			</div>
		</div>
	</div>
</body>
</html>