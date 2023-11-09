<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.BarbeiroBean"%>
<%@ page import="java.util.ArrayList"%>

<%
	
	@ SuppressWarnings ("unchecked")
	ArrayList<BarbeiroBean> barbeiros = (ArrayList<BarbeiroBean>) request.getAttribute("barbeiros");
	
	if(session.getAttribute("user") == null){
		response.sendRedirect("login.jsp");
		System.out.println("Acesso negado - sem session");
	}else{
		System.out.println("Acesso permitido - criou session");
		
	}
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
<meta charset="utf-8">
<title>Barbeiros</title>
<link rel="stylesheet" href="styles/table.css">
</head>
<body>
	<h1 class="main_title">Barbeiros</h1>
	<a href="BarbeiroNovo.html"  class="novo_agendamento" >Novo Barbeiro</a>
	
	<table id="tabelaBarbeiros" class="table_container">
		<thead class="table_head">
			<tr>
				<th class="table_line_head">Id</th>
				<th class="table_line_head">Nome</th>
				<th class="table_line_head">Telefone</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < barbeiros.size(); i++) {
			%>
			<tr>
				<td class="table_line_body"><%=barbeiros.get(i).getId()%></td>
				<td class="table_line_body"><%=barbeiros.get(i).getNome()%></td>
				<td class="table_line_body"><%=barbeiros.get(i).getTelefone()%></td>
				
				 <td class="table_line_body table_btn_link">
					<a class="link_btn" href="selectBarbeiro?id=<%=barbeiros.get(i).getId()%>"
					>Editar</a>

                </td>
              
				
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
</body>
</html>