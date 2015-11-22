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
				<td><input type="text" name="txtId" value="<%=c.getId()%>"/></td>
				<td><input type="text" name="txtNome" value="<%=c.getNome()%>"/></td>
				<td><input type="text" name="txtRg" value="<%=c.getRg()%>"/></td>
				<td><input type="text" name="txtCpf" value="<%=c.getCpf()%>"/></td>
				<td><input type="text" name="txtTelefone" value="<%=c.getTelefone()%>"/></td>
				<td><input type="text" name="txtEndereco" value="<%=c.getEndereco()%>"/></td>
				<td><input type="text" name="txtEmail" value="<%=c.getEmail()%>"/></td>
				<td><input type="submit" name="acao" value="Editar">
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
