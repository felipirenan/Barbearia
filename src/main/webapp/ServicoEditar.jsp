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
			<form name="frmEditServico" action="update" class="container_form">
				<h1 class="main_title">Editar Servico</h1>
				
				 <label for="id" class="label_text">ID:</label>
					<input 
					type="text" 
					name="id"  
					readonly
					value="<%out.print(request.getAttribute("id"));%>"
					class="user_box"
					>
					
				<label for="descricao" class="label_text">Descrição:</label>
				<input
				 	type="text"
				 	name="descricao" 
				 	value="<%out.print(request.getAttribute("descricao"));%>"
				 	class="user_box"
				>
				
				<label for="valor" class="label_text">Valor:</label>
				<input 
					type="number" 
					name="valor" 
					value="<%out.print(request.getAttribute("valor"));%>"
					class="user_box"
				>
	
				<input type="submit" value="Salvar"  class="btn" >
	</form>
	</section>
	
</body>
</html>