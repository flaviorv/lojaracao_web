<%@ page language="java" import="br.edu.infnet.lojaracao.model.auxiliary.Constantes" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração - Cadastro</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">	
		<form action="/ave/incluir" method="post">
			<h1 class="form-group">Cadastre uma nova ração de ave</h1>			
			
			
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" value="Ração de Ave 1" class="form-control">
			</div>
			<div class="form-group">
				<label for="codigo">Código:</label>
				<input type="number"  min="0" max="999999" name="codigo" value="2431" class="form-control">
			</div>
			<div class="form-group">
				<label for="preco">Preço:</label>
				<input type="number" step="0.01" min="0.01" max="999999" name="preco" value="12.12" class="form-control">
			</div>
			
			<div class="form-group">
				<label >Tipo de ave:</label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="<%= Constantes.TIPO1 %>" class="form-check-input" checked >
						<%= Constantes.TIPO1 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="<%= Constantes.TIPO2 %>" class="form-check-input">
						<%= Constantes.TIPO2 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="<%= Constantes.TIPO3 %>" class="form-check-input" >
						<%= Constantes.TIPO3 %>
					</label>
				</div>
			</div>
			
			<div class="form-group">
				<label >Aroma: </label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="aroma" value="<%= Constantes.AROMA1 %>" class="form-check-input" checked>
						<%= Constantes.AROMA1 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">	
						<input type="radio" name="aroma" value="<%= Constantes.AROMA2 %>" class="form-check-input">
						<%= Constantes.AROMA2 %>
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="aroma" value="<%= Constantes.AROMA3 %>" class="form-check-input" >
						<%= Constantes.AROMA3 %>
					</label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="peso">Peso:</label>
				<input type="number" step="0.1"  min="0.1" max="999999" name="peso" value="12.1" class="form-control" id="peso">
			</div>

			<div class="form-group">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>