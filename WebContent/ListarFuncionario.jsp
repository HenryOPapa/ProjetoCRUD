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
			
				<td><input type="text" name="txtId" value="<%=f.getId()%>"/></td>
				<td><input type="text" name="txtNome" value="<%=f.getNome()%>"/></td>
				<td><input type="text" name="txtRg" value="<%=f.getRg()%>"/></td>
				<td><input type="text" name="txtCpf" value="<%=f.getCpf()%>"/></td>
				<td><input type="text" name="txtTelefone" value="<%=f.getTelefone()%>"/></td>
				<td><input type="text" name="txtEndereco" value="<%=f.getEndereco()%>"/></td>
				<td><input type="text" name="txtEmail" value="<%=f.getEmail()%>"/></td>
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
