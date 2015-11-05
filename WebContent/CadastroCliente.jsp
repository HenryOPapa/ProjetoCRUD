<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro Cliente</title>
</head>
<body>
	<div align="center">
		<h1>Novo Cliente</h1>
		<hr />
		<form action="clienteControle" method="post">
			Nome: <input type="text" name="txtNome"/><br/> 
			Rg: <input type="text" name="txtRg"/><br/> 
			Cpf: <input type="text" name="txtCpf"/><br/>
			Telefone: <input type="text" name="txtTelefone"/><br/>
			Endereco: <input type="text" name="txtEndereco"/><br/>
			Email: <input type="text" name="txtEmail"/><br/>
 			<input type="submit" name="acao" value="Cadastrar"/> 
 			<input type="submit" name="acao" value="Listar"/>
		</form>
		<a href="index.jsp"><input type="submit" value="Voltar"/></a>
	</div>
</body>
</html>