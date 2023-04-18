<%@page import="ch.qos.logback.core.net.SyslogOutputStream"%>
<%@page
	import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<style>
ul {
	list-style-type: none;
	margin: 0 !important;
	padding: 15px;
	overflow: hidden;
	background-color: #333;
	color: orange;
	display: flex;
	font-size: 1.3em;
	justify-content: space-between;
}

li a {
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-family: fantasy;
	color: white;
}

li a:hover {
	background-color: #111;
	text-decoration: none;
	font-size: 1.4em;
}

.conteudoJunto {
	justify-content: center;
}
</style>
</head>
<nav>
	<div>

		<ul>
			<li><a href="/">Início</a></li>
			<c:if test="${empty funcionarioLogado}">
				<li><span>RAÇÕES VAROTO - Nutrindo com qualidade!</span></li>
				<li><a href="/acesso/funcionario">Acessar Conta</a><a
					href="/cadastro/funcionario">Criar Conta</a></li>
			</c:if>
			<c:if test="${not empty funcionarioLogado }">
				<li><span>RAÇÕES VAROTO - Nutrindo com qualidade!</span></li>
				<li><span>${funcionarioLogado.getNome()}</span><a
					href="/funcionario/sair">Sair</a></li>

			</c:if>
		</ul>
		<c:if test="${not empty funcionarioLogado}">
			<ul class="conteudoJunto">
				<li>Cadastrar:</li>
				<li><a href="/cadastro/cliente">Cliente</a></li>
				<li><a href="/cadastro/ave">Ração de Ave</a></li>
				<li><a href="/cadastro/cao">Ração de Cão</a></li>
				<li><a href="/cadastro/gato">Ração de Gato</a></li>
				<li><a href="/cadastro/venda">Venda</a></li>
				<c:if test="${funcionarioLogado.isAdmin()}">
					<li><a href="/cadastro/funcionario">Funcionario</a></li>
				</c:if>
			</ul>
			<ul class="conteudoJunto">
				<li>Listar:</li>
				<li><a href="/lista/cliente">Clientes</a></li>
				<li><a href="/lista/racao">Todas as Rações</a></li>
				<li><a href="/lista/ave">Rações de Ave</a></li>
				<li><a href="/lista/cao">Rações de Cachorro</a></li>
				<li><a href="/lista/gato">Rações de Gato</a></li>
				<li><a href="/lista/venda">Vendas</a></li>
				<c:if test="${funcionarioLogado.isAdmin()}">
					<li><a href="/lista/funcionario">Funcionarios</a></li>
				</c:if>
			</ul>
		</c:if>
	</div>
</nav>