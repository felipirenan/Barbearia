<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.BarbeiroBean"%>
<%@ page import="model.Daobarbeiro"%>
<%@ page import="model.ServicoBean"%>
<%@ page import="model.DaoServico"%>
<%@ page import="java.util.ArrayList"%>
   <%
   Daobarbeiro daoBarbeiro = new Daobarbeiro();
   DaoServico daoServico = new DaoServico();
	//@ SuppressWarnings ("unchecked")
	ArrayList<BarbeiroBean> barbeiros = (ArrayList<BarbeiroBean>)  daoBarbeiro.listarBarbeiros();//request.getAttribute("barbeiros");	
	ArrayList<ServicoBean> servicos = (ArrayList<ServicoBean>)  daoServico.listarServico();
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/formularioPadrao.css">
  
    <title>Novo Agendamento</title>
</head>
<body>

	 

	<section class="main_container">
		<div class="container_estilo"></div>
    	<form action="horarios" class="container_form">
   			 <h1 class="main_title">Faça um Agendamento</h1>
    
       		 <select name="barbeiro" class="label_text">
       		 <%
        	for(int i = 0; i < barbeiros.size(); i++){ 
        
       		 %>
				<option value="<%=barbeiros.get(i).getId()%>"><%=barbeiros.get(i).getNome()%></option>
         	<%
         	}
         	%>
        	</select>
        	<select name="servico" class="label_text" >
         	<%
        	for(int i = 0; i < servicos.size(); i++){ 
        		
       	 %>
				<option value="<%=servicos.get(i).getId() %>" ><%=servicos.get(i).getDescricao() %></option>
             	<%
         	}
         %>
       	 	</select>
        	<input type="date" name="calendario"  class="label_text" required>
       		<input type="submit" value="Avançar"  class="btn">
    	</form>
     </section>

</body>
</html>