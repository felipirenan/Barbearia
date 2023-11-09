<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ page  import="model.LoginBean"%>
    
   <%
   	
   boolean acesso;
   
   		
   
   		if(request.getAttribute("acesso") == null){
	   		acesso = false;
	   }else{
		   acesso = (boolean) request.getAttribute("acesso");
	   }
	   
   		System.out.println(acesso);
   		
   		if(acesso == true){
   			response.sendRedirect("index.html");
   		}else{
   			
   		}
   		
   
   
   %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/form.css">
    <title>area de cadastro</title>
</head>
<body > 
    <div class="container_estilo"></div>
    <div class="container">
        <form action="gravaLogin"  id="formLogin" class="container_form">
          <h1 class="main_title">Faça Login</h1>
         
           <label class="label_text" for="nome">Insira seu Usuario: </label> 
           <input type="text"  name="nome" required class="user_box" placeholder="Usuario">
           <label class="label_text" for="senha">Insira sua senha: </label> 
           <input type="password" name="senha" required class="user_box" placeholder="Senha">
           <div class="position_btn">
               
               <input type="submit" class="btn_login" value="cadastrar">
               <input type="submit" class="btn_login" value="acessar"  onclick="MudaAction()">
           </div>
    	
    
      </form>
      

      
  		
      
    </div>
    
</body>
		<script src="scripts/MudaAction.js" ></script>
</html>