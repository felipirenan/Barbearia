<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.AgendamentoBean"%>
<%@ page import="java.util.ArrayList"%>
<%
@ SuppressWarnings ("unchecked")
ArrayList<AgendamentoBean> horarios = (ArrayList<AgendamentoBean>) request.getAttribute("horarios");

%> 

<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">

	<link rel="stylesheet" href="styles/horarios.css">

	<title>Selecione um Horario</title>
</head>

<body>


	<section class="main_container_form">
		
			<form action="gravarAgendamento" class="main_container">
				<h1 class="main_title">Faça um Agendamento</h1>
				<label class="text_input">Escolha uma data</label>
				<input class="box_options" type="date" name="calendario" value="<%=request.getParameter("calendario")
					%>" readonly >

				<label class="text_input">Escolha um(a) profissional</label>
				<select name="barbeiro" class="box_options">
					<option value="<%=request.getParameter("barbeiro") %>"><%=request.getParameter("barbeiro")%></option>
				</select>
				

				<label class="text_input">Escolha um serviço</label>
				<select name="servico" class="box_options">
					<option value="<%=request.getParameter("servico") %>" ><%=request.getParameter("servico") %>
					</option>
				</select>

				<div class="container buttons">
					



					 <%
		 
	
	boolean auxiliar = false;	
	int hora = 7;
	String horarioPad;
	for(int x=0; x <=10; x++){
		auxiliar = false;
		
		hora++;
		if(hora > 9){
			
		 horarioPad = hora+ ":00:00";
		}else{
			horarioPad = "0"+hora+ ":00:00";
		}
		
		for (int i = 0; i < horarios.size(); i++){
			
		
			
			if(horarioPad.equals(horarios.get(i).getHorario())){
				
				auxiliar = true;
			
		
		%>
		 
		<input type="submit" value="<%=horarios.get(i).getHorario()%>"  disabled>




					<%
       	
   		break;
			
			}
       	}
		
			if(!auxiliar){
		
		 %> 
		 <input type="submit" value="<%=horarioPad%>" name="horario" >
					 <% 
			 
					 }
			
	}
	
       %> 
				</div>



			</form>
	</section>
   
</body>

</html>