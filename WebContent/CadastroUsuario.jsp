<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <!--
	 Author: Henry Papa
	-->
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Usu�rio</title>
</head>
<body>
<div align="center">
		<h1>Novo Usuario</h1>
		<hr />
		<form action="usuarioControle" method="post">
			Login: <input type="text" name="txtLogin"/><br/> 
			Senha: <input type="password" name="txtSenha"/><br/> 
			N�vel de acesso<br/>
			<select name="txtAcesso">
				<option value="Administrador">Administrador</option>
				<option value="Funcion�rio">Funcion�rio</option>
			</select>
		<input type="submit" name="acao" value="Cadastrar"/> 
		</form>
	</div>

</body>
</html>