<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.AgendamentoBean"%>
<%@ page import="java.util.ArrayList"%>
    
	<%
	
	@ SuppressWarnings ("unchecked")
	ArrayList<AgendamentoBean> agendamentos = (ArrayList<AgendamentoBean>) request.getAttribute("agendamentos");
	
	
		%> 

<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Agendamento</title>
<link rel="stylesheet" href="styles/table.css">

</head>
<body>

 




	<h1 class="main_title">Agendamento</h1>
	<a href="novoAgendamento" class="novo_agendamento">Novo Agendamento</a>
	
	<table id="tabelaAgendamento" class="table_container">
		<thead class="table_head">
			<tr>
				<th class="table_line_head">Id</th>
                <th class="table_line_head">Barbeiro</th>
				<th class="table_line_head">Servico</th>
				<th class="table_line_head">Dia</th>
				<th class="table_line_head">Horario</th>
				<th class="table_line_head">Status</th>
				<th class="table_line_head">User</th>
			</tr>
		</thead>
		<tbody>
			 <%
				for (int i = 0; i < agendamentos.size(); i++) {
			%> 
			<tr>
				<td class="table_line_body"><%=agendamentos.get(i).getId()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getBarbeiro()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getServico()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getDia()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getHorario()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getStatusAgen()%></td>
				<td class="table_line_body"><%=agendamentos.get(i).getIdUser()%></td>
				
          
                <td  class="table_line_body table_btn_link">    
					<a class="corlink" href="javascript: confirmar(<%=agendamentos.get(i).getId()%>)"
					>Cancelar</a>
				</td>
				
			</tr>
			<%
				}
			%> 
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>