<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!--
	 Author: Henry Papa
	-->
	
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Novo Orçamento</title>
</head>

	<div align="center">
		<h1>Novo Orcamento</h1>
		<hr />
		<form action="funcionarioControle" method="post">
			Relato: <textarea name="txtRelato"></textarea><br/>
			Email Cliente: <input type="text" name="txtEmailCliente"/><br/>
			Equipamento: <input type="text" name="txtEquipamento"/><br/>
			Peças: <input type="text" name="txtPecas"/><br/>
			Serviço: <input type="text" name="txtServico"/><br/>
			Problema: <input type="text" name="txtProblema"/><br/>
			Numero Serie: <input type="text" name="txtNumeroSerie"/><br/>
			<input type="submit" name="acao" value="Cadastrar"/> 
		</form>
		<a href="index.jsp"><input type="submit" value="Voltar"/></a>
	</div>
</html>