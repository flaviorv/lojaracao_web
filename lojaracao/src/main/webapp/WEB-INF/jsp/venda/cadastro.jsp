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
<style type="text/css">
.bottomButton, label {
	display: flex;
	justify-content: center;
	align-items: center;
	margin-top: 5%;
}

.line-group:not(.line-exception) {
	display: flex;
	justify-content: space-between;
}

.racoes {
	display: flex;
	justify-content: space-around;
	flex-flow: row wrap;
}

.racao {
	padding: 2%;
}

label {
	font-weight: bolder;
}

h1, h3, .bottomButton {
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
		<form action="/venda/incluir" method="post">
			<h1 class="form-group">Cadastre uma venda</h1>
			<h3>${racaoException}</h3>
			<div class="form-group">
				<label for="data">Data:</label> <input type="date" name="data"
					value="2023-04-10" class="form-control" id="data" required>
			</div>
			<div class="line-group">
				<div class="form-group, entrega">
					<label>Para entregar: </label>
					<div class="form-check">
						<input type="radio" name="entrega" value="true"
							class="form-check-input" checked>Sim

					</div>
					<div class="form-check">
						<input type="radio" name="entrega" value="false"
							class="form-check-input">Não
					</div>
				</div>
				<div class="form-group, prazo">
					<label>Prazo: </label>
					<div class="form-check">
						<input type="radio" name="prazo" value="0"
							class="form-check-input" checked>à vista

					</div>
					<div class="form-check">
						<input type="radio" name="prazo" value="30"
							class="form-check-input">30 dias

					</div>
					<div class="form-check">
						<input type="radio" name="prazo" value="60"
							class="form-check-input">60 dias

					</div>
				</div>

				<c:if test="${funcionarioLogado.isAdmin() eq true}">
					<div class="form-group, cliente">
						<c:if test="${not empty cliente.obterLista()}">
							<label>Cliente:</label>
							<div>
								<select name="cliente">
									<c:forEach var="c" items="${cliente.obterLista()}">
										<option value="${c.id}">${c.getNome()}</option>
									</c:forEach>
								</select>
							</div>
						</c:if>
					</div>

					<c:if test="${empty cliente.obterLista()}">
						<div class="line-exception">
							<b>É necessário cadastrar ao menos um cliente antes de
								cadastrar a venda.</b>
							<div class="form-group, bottomButton">

								<a href="/cadastro/cliente"><button type="button"
										style="background-color: lime;">Cadastrar Cliente</button></a>
							</div>
						</div>
					</c:if>
				</c:if>

				<c:if test="${funcionarioLogado.isAdmin() eq false}">
					<div class="form-group, cliente">
						<c:if test="${not empty cliente.obterLista(funcionarioLogado)}">
							<label>Cliente:</label>
							<div>
								<div>
									<select name="cliente">
										<c:forEach var="c"
											items="${cliente.obterLista(funcionarioLogado)}">
											<option value="${c.id}">${c.getNome()}</option>
										</c:forEach>
									</select>
								</div>
							</div>
						</c:if>
					</div>
					<c:if test="${empty cliente.obterLista(funcionarioLogado)}">
						<div class="line-exception">
							<b>É necessário cadastrar ao menos um cliente antes de
								cadastrar a venda.</b>
							<div class="form-group, bottomButton">

								<a href="/cadastro/cliente"><button type="button"
										style="background-color: lime;">Cadastrar Cliente</button></a>
							</div>
						</div>
					</c:if>
				</c:if>
			</div>

			<c:if test="${funcionarioLogado.isAdmin() eq true}">
				<div class="form-group">
					<div class="form-check, racoes">
						<c:if test="${not empty racao.obterLista()}">
							<label>Rações:</label>
							<div class="racoes">
								<c:forEach var="r" items="${racao.obterLista()}">
									<div class="racao">
										<input type="checkbox" name="racoes" value="${r.id}"
											class="form-check-input"> <span>${r.getNome()}</span>
									</div>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<c:if test="${empty racao.obterLista()}">
						<b>É necessário cadastrar ao menos uma ração antes de
							cadastrar a venda.</b>
						<div class="form-group, bottomButton">

							<a href="/cadastro/ave"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Ave</button></a>
							<a href="/cadastro/cao"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Cão</button></a>
							<a href="/cadastro/gato"><button type="button"
									style="background-color: lime;">Cadastrar Ração de
									Gato</button></a>
						</div>
					</c:if>
				</div>
				<c:if
					test="${empty racao.obterLista() or empty cliente.obterLista()}">
					<div class="form-group, bottomButton">
						<button type="button" class="btn btn-primary"
							style="pointer-events: none; background-color: gray;">Cadastrar</button>
					</div>
				</c:if>
				<c:if
					test="${not empty racao.obterLista() and not empty cliente.obterLista()}">
					<div class="form-group, bottomButton">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</c:if>
			</c:if>

			<c:if test="${funcionarioLogado.isAdmin() eq false}">
				<div class="form-group">
					<div class="form-check">
						<c:if test="${not empty racao.obterLista(funcionarioLogado)}">
							<label>Rações:</label>
							<div class="racoes">
								<c:forEach var="r"
									items="${racao.obterLista(funcionarioLogado)}">
									<div class="racao">
										<input type="checkbox" name="racoes" value="${r.id}"
											class="form-check-input"> <span>${r.getNome()}</span>
									</div>
								</c:forEach>
							</div>
						</c:if>
					</div>
					<c:if test="${empty racao.obterLista(funcionarioLogado)}">
						<b>É necessário cadastrar ao menos uma ração antes de
							cadastrar a venda.</b>
						<div class="form-group, bottomButton">
							<a href="/cadastro/ave"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Ave</button></a>
							<a href="/cadastro/cao"><button type="button"
									style="background-color: lime;">Cadastrar Ração de Cão</button></a>
							<a href="/cadastro/gato"><button type="button"
									style="background-color: lime;">Cadastrar Ração de
									Gato</button></a>
						</div>
					</c:if>
				</div>
				<c:if
					test="${empty racao.obterLista(funcionarioLogado) or empty cliente.obterLista(funcionarioLogado)}">
					<div class="form-group, bottomButton">
						<button type="button" class="btn btn-primary"
							style="pointer-events: none; background-color: gray;">Cadastrar</button>
					</div>
				</c:if>
				<c:if
					test="${not empty racao.obterLista(funcionarioLogado) and not empty cliente.obterLista(funcionarioLogado)}">
					<div class="form-group, bottomButton">
						<button type="submit" class="btn btn-primary">Cadastrar</button>
					</div>
				</c:if>
			</c:if>
		</form>
	</div>
</body>
</html>