<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<label for="data">Data:</label> <input type="date" name="data"
					class="form-control" id="data">
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
			<c:if test="${funcionarioLogado.isAdmin() eq true}">
				<div class="form-group">
					<c:if test="${not empty cliente.obterLista()}">
						<label>Cliente:</label>
						<select name="cliente">
							<c:forEach var="c" items="${cliente.obterLista()}">
								<option value="${c.id}">${c.getNome()}</option>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${empty cliente.obterLista()}">
						<b>É necessário cadastrar ao menos um cliente antes de
							cadastrar a venda.</b>
						<a href="/cadastro/cliente"><button type="button"
								style="background-color: lime;">Cadastrar Cliente</button></a>
					</c:if>
				</div>
				<div class="form-group">
					<div class="form-check">
						<c:if test="${not empty racao.obterLista()}">
							<label>Rações:</label>
							<c:forEach var="r" items="${racao.obterLista()}">
								<label class="form-check-label"> <input type="checkbox"
									name="racoes" value="${r.id}" class="form-check-input">${r.getNome()}
								</label>
							</c:forEach>
						</c:if>
						<c:if test="${empty racao.obterLista()}">
							<b>É necessário cadastrar ao menos uma ração antes de
								cadastrar a venda.</b>
							<a href="/cadastro/ave"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Ave</button></a>
							<a href="/cadastro/cao"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Cão</button></a>
							<a href="/cadastro/gato"><button type="button"
									style="background-color: lime;">Cadastrar Ração de
									Gato</button></a>
						</c:if>
					</div>
				</div>
				<c:if
					test="${empty racao.obterLista() or empty cliente.obterLista()}">
					<div class="form-group">
						<button type="button" class="btn btn-primary"
							style="pointer-events: none; background-color: gray;">Cadastrar</button>
					</div>
				</c:if>
				<c:if
					test="${not empty racao.obterLista() and not empty cliente.obterLista()}">
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</c:if>
			</c:if>
			<c:if test="${funcionarioLogado.isAdmin() eq false}">
				<div class="form-group">
					<c:if test="${not empty cliente.obterLista(funcionarioLogado)}">
						<label>Cliente:</label>
						<select name="cliente">
							<c:forEach var="c"
								items="${cliente.obterLista(funcionarioLogado)}">
								<option value="${c.id}">${c.getNome()}</option>
							</c:forEach>
						</select>
					</c:if>
					<c:if test="${empty cliente.obterLista(funcionarioLogado)}">
						<b>É necessário cadastrar ao menos um cliente antes de
							cadastrar a venda.</b>
						<a href="/cadastro/cliente"><button type="button"
								style="background-color: lime;">Cadastrar Cliente</button></a>
					</c:if>
				</div>
				<div class="form-group">
					<div class="form-check">
						<c:if test="${not empty racao.obterLista(funcionarioLogado)}">
							<label>Rações:</label>
							<c:forEach var="r" items="${racao.obterLista(funcionarioLogado)}">
								<label class="form-check-label"> <input type="checkbox"
									name="racoes" value="${r.id}" class="form-check-input">${r.getNome()}
								</label>
							</c:forEach>
						</c:if>
						<c:if test="${empty racao.obterLista(funcionarioLogado)}">
							<b>É necessário cadastrar ao menos uma ração antes de
								cadastrar a venda.</b>
							<a href="/cadastro/ave"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Ave</button></a>
							<a href="/cadastro/cao"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Cão</button></a>
							<a href="/cadastro/gato"><button type="button"
									style="background-color: lime;">Cadastrar Ração de
									Gato</button></a>
						</c:if>
					</div>
				</div>
				<c:if
					test="${empty racao.obterLista(funcionarioLogado) or empty cliente.obterLista(funcionarioLogado)}">
					<div class="form-group">
						<button type="button" class="btn btn-primary"
							style="pointer-events: none; background-color: gray;">Cadastrar</button>
					</div>
				</c:if>
				<c:if
					test="${not empty racao.obterLista(funcionarioLogado) and not empty cliente.obterLista(funcionarioLogado)}">
					<div class="form-group">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</c:if>
			</c:if>
		</form>
	</div>
</body>
</html>