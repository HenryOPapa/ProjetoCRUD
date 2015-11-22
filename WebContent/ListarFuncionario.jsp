<%@page import="modelo.Funcionario"%>
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
	<form action="funcionarioControle" method="post">
		<%
			List<Funcionario> funcionarios = (List) request.getAttribute("listaFuncionarios");
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
					for (Funcionario f : funcionarios) {
				%>
			</tr>
			
				<%=f.getId()%>
				<td><%=f.getNome()%></td>
				<td><%=f.getRg()%></td>
				<td><%=f.getCpf()%></td>
				<td><%=f.getTelefone()%></td>
				<td><%=f.getEndereco()%></td>
				<td><%=f.getEmail()%></td>
				<td><input type="submit" name="acao" value="Atualizar">
				<input type="submit" name="acao" value="Excluir"></td>

				<%
					}
				%>

			


		</table>
	</form>

	<a href="index.jsp"><input type="submit" value="Voltar" /></a>

</body>
</html>
