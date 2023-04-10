<%@ page language="java" import="br.edu.infnet.lojaracao.model.repository.FuncionarioRepository"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração</title>
<style type="text/css">
.container{background-color: #404040;}
img {
	width: 90%;
	margin-left: 5%;
	margin-right: 5%;
}
</style>
</head>
<body>
	<div>
		<c:import url="/WEB-INF/jsp/menu.jsp" />
	</div>
	<div class="container">
		
		<img alt="" src="/imagens/racaoVarotoIndex.png">
		<h2>${status}</h2>
	</div>
</body>
</html>