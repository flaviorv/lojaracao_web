<%@ page language="java" import="br.edu.infnet.lojaracao.model.repository.CaoRepository" 
contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Confirmação</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="form-group">
			<h1>Lista de rações de cães</h1>
			<%= CaoRepository.obterLista()%>
		</div>
		<div class="form-group">
			<a href="/" ><button class="btn btn-primary">Ir para página inicial</button></a>
		</div>
	</div>
</body>
</html>