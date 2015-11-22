<%@page import="modelo.Cliente"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--
	 Author: Henry Papa
	-->

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Atualizar</title>
</head>
<body>
	<form action="clienteControle" method="post">
		<%
			List<Cliente> clientes = (List) request.getAttribute("listaClientes");
		%>
		<table border="1">
			<tr>
				<th>Codigo</th>
				<th>Nome</th>
				<th>RG</th>
				<th>CPF</th>
				<th>Telefone</th>
				<th>Endereco</th>
				<th>Email</th>

				<%
					for (Cliente c : clientes) {
				%>
			</tr>
			<tr>
				<td><%=c.getId()%></td>
				<td><%=c.getNome()%></td>
				<td><%=c.getRg()%></td>
				<td><%=c.getCpf()%></td>
				<td><%=c.getTelefone()%></td>
				<td><%=c.getEndereco()%></td>
				<td><%=c.getEmail()%></td>
				<td><input type="submit" name="acao" value="Atualizar">
				<input type="submit" name="acao" value="Excluir"></td>

				<%
					}
				%>

			</tr>


		</table>
	</form>

	<a href="index.jsp"><input type="submit" value="Voltar" /></a>

</body>
</html>
