<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@ page language="java"
	import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository, 
br.edu.infnet.lojaracao.model.domain.Funcionario" 
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
			<h1>Lista de funcionarios</h1>
			<h2>
				Total:
				<c:out value="${funcionario.obterLista().size()}"></c:out>
			</h2>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Nome</th>
						<th class="table-info">Email</th>
						<th class="table-info">Admin</th>
						<th class="table-info"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${funcionarioLogado.isAdmin()}">
						<c:forEach var="funcionario" items="${funcionario.obterLista()}">
							<tr>
								<td>${funcionario.getNome()}</td>
								<td>${funcionario.getEmail()}</td>
								<td>${funcionario.isAdmin()}</td>
								<td>
									<form action="/lista/funcionario">
										<button type="submit" value="${funcionario.id}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="form-group">
			<a href="/cadastro/funcionario"><button class="btn btn-primary">Novo
					Funcionario</button></a>
		</div>
	</div>
</body>
</html>