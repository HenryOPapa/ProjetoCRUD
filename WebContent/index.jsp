<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!--
	 Author: Henry Papa
	-->



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro</title>
<%String login = (String) session.getAttribute("usuario");
if(login==null) login="";
%>
Hello,
<%=login%>
</head>
<body>
	<p>
	<div>
		<a href="CadastroFuncionario.jsp"><input type="submit"
			value="Funcionário" /></a>
	</div>
	<div>
		<a href="CadastroCliente.jsp"><input type="submit" value="Cliente" /></a>
	</div>
	<div>
		<a href="CadastroUsuario.jsp"><input type="submit"
			value="Usuário" /></a>
	</div>


	<form action="logoffControle" method="post">
		<div>
			<a href="login.jsp"><input type="submit" value="Logoff" /></a>
		</div>
		
	</form>


</body>
</html>