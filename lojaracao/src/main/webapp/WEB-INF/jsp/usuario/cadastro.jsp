<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Loja de Ração</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
</head>
<body>
	<div class="container">	
		<form action="/usuario/incluir" method="post">
			<h1>Cadastre um novo usuário</h1>
			
			<!-- 	.receba o nome e o email do usuario: use caixas de texto -->
			<div class="form-group">
				<label for="nome">Nome:</label>
				<input type="text" name="nome" value="Flavio" class="form-control" id="nome">
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label>
				<input type="password" name="senha" value="123" class="form-control" id="senha">
			</div>
			<div class="form-group">
				<label for="email">E-mail:</label>
				<input type="email" name="email" value="flavio@gmail.com" class="form-control" id="email">
			</div>
			<div class="form-group">
				<label for="idade">Idade:</label>
				<input type="number" name="idade" value="50" class="form-control" id="idade">
			</div>
			<div class="form-group">
				<label for="salario">Salário:</label>
				<input type="number" name="salario" value="500000000" class="form-control" id="salario">
			</div>
			
			<!-- 	.selecione o tipo de usuario: padrao, diretor ou admnistrador (radiobutton) -->
			<div class="form-group">
				<label >Tipo:</label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="p" class="form-check-input">Padrão
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="d" class="form-check-input">Diretor
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="radio" name="tipo" value="a" class="form-check-input" checked>Administrador
					</label>
				</div>
			</div>
			
			<!-- 	.marque ate cinco caracteristicas do usuario (checkbox) -->
			<div class="form-group">
				<label>Características:</label>
				<div class="form-check">
					<label class="form-check-label">
						<input type="checkbox" name="caracteristicas" value="dev" class="form-check-input">Developer
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="checkbox" name="caracteristicas" value="db" class="form-check-input" checked>Database
					</label>
				</div>
				<div class="form-check">
					<label class="form-check-label">
						<input type="checkbox" name="caracteristicas" value="an" class="form-check-input" checked>Analista
					</label>
				</div>
			</div>
			<!-- 	.selecione o setor que o usuario esta alocado: use um select(combobox) -->
			
				
			<label>Setor:</label>
			<div class="form-group">
				<select name="setor">
					<option value="1">Diretoria</option>
					<option value="2">Comercial</option>
					<option value="3" selected>Desenvolvimento</option>
				</select>
			</div>
			<!-- 	.coloque um botao chamado "cadastrar": use um button -->
			<div class="form-group">
				<button type="submit" class="btn btn-primary">Cadastrar</button>
			</div>
		</form>
	</div>
</body>
</html>