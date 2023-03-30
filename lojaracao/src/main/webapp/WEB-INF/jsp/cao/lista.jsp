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
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		<div class="form-group">
			<h1>Lista de rações de cães</h1>
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th class="table-info">Id</th>
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
					<%
					for (Cao item : CaoRepository.obterLista()) {
					%>
					<tr>
						<%
						String id = String.valueOf(item.getId());
						%>
						<td><%=id%></td>
						<td><%=item.getNome()%></td>
						<td><%=item.getCodigo()%></td>
						<td>R$<%=item.getPreco()%></td>
						<td><%=item.isSemCorante()%></td>
						<td><%=item.isFilhotes()%></td>
						<td><%=item.getPorte()%></td>
						<td>
							<form action="/lista/cao">
								<button type="submit" value="<%=id%>" name="id">Excluir</button>
							</form>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<div class="form-group">
			<%
			if (FuncionarioRepository.isFuncionarioLogado()) {
			%>
			<a href="/cadastro/cao"><button class="btn btn-primary">Nova
					Ração</button></a>
			<%
			} else {
			%>
			<a href="/acesso/funcionario"><button class="btn btn-primary">Nova
					Ração</button></a>
			<%
			}
			%>
			<a href="/"><button class="btn btn-primary">Página
					inicial</button></a>
		</div>
	</div>
</body>
</html>