<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="stylesheet" href="styles/servico.css">
<title>Servicos- Editar</title>

</head>
<body>
	
	 <section class="main_container">
			<div class="container_estilo"></div>
			<form name="frmEditServico" action="updateBarbeiro" class="container_form">
				<h1 class="main_title">Editar Barbeiro</h1>
				
				 <label for="id" class="label_text">ID:</label>
					<input 
					type="text" 
					name="id"  
					readonly
					value="<%out.print(request.getAttribute("id"));%>"
					class="user_box"
					>
					
				<label for="Nome" class="label_text">Descrição:</label>
				<input
				 	type="text"
				 	name="nome" 
				 	value="<%out.print(request.getAttribute("nome"));%>"
				 	class="user_box"
				>
				
				<label for="tel" class="label_text">Telefone:</label>
				<input 
					type="text" 
					name="tel" 
					value="<%out.print(request.getAttribute("tel"));%>"
					class="user_box"
				>
	
				<input type="submit" value="Salvar"  class="btn" >
	</form>
	</section>
	
</body>
</html>