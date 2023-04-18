<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Vendas - Lista</title>
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
	<div class="menu">
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<div class="form-group">
			<h1>Lista de Vendas</h1>
			<h2>
				Total:
				<c:if test="${funcionarioLogado.isAdmin()}">
					<c:out value="${venda.obterLista().size()}"></c:out>
				</c:if>
				<c:if test="${funcionarioLogado.isAdmin() eq false}">
					<c:out value="${venda.obterLista(funcionarioLogado).size()}"></c:out>
				</c:if>
			</h2>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Data</th>
						<th class="table-info">Entregar</th>
						<th class="table-info">Endereço</th>
						<th class="table-info">Cliente</th>
						<th class="table-info">Rações</th>
						<th class="table-info">Prazo</th>
						<th class="table-info"></th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${funcionarioLogado.isAdmin()}">
						<c:forEach var="venda" items="${venda.obterLista()}">
							<tr>
								<td>${venda.getData()}</td>
								<c:if test="${venda.isEntrega() eq true}">
									<td>Sim</td>
								</c:if>
								<c:if test="${venda.isEntrega() eq false}">
									<td>Não</td>
								</c:if>
								<td>${venda.getCliente().getEndereco()}</td>
								<td><p>${venda.getCliente().getNome()}</p>
									<p>${venda.getCliente().getTelefone()}</p></td>
								<td>${venda.getRacoes().size()}</td>
								<c:if test="${venda.getPrazo() == 0}">
									<td>À vista</td>
								</c:if>
								<c:if test="${venda.getPrazo() > 0}">
									<td>${venda.getPrazo()}dias</td>
								</c:if>
								<td>
									<form class="excludeButton" action="/lista/venda">
										<button type="submit" value="${venda.id}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
					<c:if test="${funcionarioLogado.isAdmin() eq false}">
						<c:forEach var="venda"
							items="${venda.obterLista(funcionarioLogado)}">
							<tr>
								<td>${venda.getData()}</td>
								<c:if test="${venda.isEntrega() eq true}">
									<td>Sim</td>
								</c:if>
								<c:if test="${venda.isEntrega() eq false}">
									<td>Não</td>
								</c:if>
								<td>${venda.getCliente().getEndereco()}</td>
								<td><p>${venda.getCliente().getNome()}</p>
									<p>${venda.getCliente().getTelefone()}</p></td>
								<td><c:forEach var="v" items="${venda.getRacoes()}">
										<p>${v.getNome()}-R$${v.getPreco()}</p>
									</c:forEach></td>
								<c:if test="${venda.getPrazo() == 0}">
									<td>À vista</td>
								</c:if>
								<c:if test="${venda.getPrazo() < 0}">
									<td>${venda.getPrazo()}dias</td>
								</c:if>
								<td>
									<form action="/lista/venda">
										<button type="submit" value="${venda.id}" name="id">Excluir</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</tbody>
			</table>
		</div>
		<div class="form-group, bottomButton">
			<a href="/cadastro/venda"><button class="btn btn-primary">Nova
					Venda</button></a>
		</div>
	</div>
</body>
</html>