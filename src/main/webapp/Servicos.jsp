<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="model.ServicoBean"%>
<%@ page import="java.util.ArrayList"%>
<%
	@ SuppressWarnings ("unchecked")
	ArrayList<ServicoBean> servicos = (ArrayList<ServicoBean>) request.getAttribute("servicos");
	
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
<title>Servicos</title>
<link rel="stylesheet" href="styles/table.css">
</head>
<body>
	<h1 class="main_title">Servicos</h1>
	<a href="ServicoNovo.html" class="novo_agendamento">Novo Servico</a>
	
	<table id="tabelaServicos" class="table_container">
		<thead class="table_head">
			<tr> 
				<th  class="table_line_head">Id</th>
				<th  class="table_line_head">Descricao</th>
				<th  class="table_line_head">Valor</th>
			</tr>
		</thead>
		<tbody>
			<%
				for (int i = 0; i < servicos.size(); i++) {
			%>
			<tr>
				<td class="table_line_body"><%=servicos.get(i).getId()%></td>
				<td class="table_line_body"><%=servicos.get(i).getDescricao()%></td>
				<td class="table_line_body"><%=servicos.get(i).getValor()%></td>
				
				<td class="table_line_body table_btn_link">
					<a class="link_btn" href="selectServico?id=<%=servicos.get(i).getId()%>"
					>Editar</a>
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