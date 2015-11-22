<%@page import="modelo.Funcionario"%>
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
        <%
            Funcionario funcionario = (Funcionario)request.getAttribute("funcionario");
        %>
        
        <h1>Atualizar!</h1>
        <form action="funcionarioControle" method="post">
        	
        	ID:<input type="hidden" name="txtId" value="<%=funcionario.getId()%>"/>
            Nome:<input type="text" name="txtNome" value="<%= funcionario.getNome()%>"/><br>
            RG:<input type="text" name="txtRg" value="<%= funcionario.getRg()%>"/><br>
            CPF:     <input type="text" name="txtCpf" value="<%= funcionario.getCpf()%>"/><br>
            Telefone:   <input type="text" name="txtTelefone" value="<%= funcionario.getTelefone()%>"/><br>
            Endereço: <input type="text" name="txtEndereco" value="<%= funcionario.getEndereco() %>"/><br>
            Email: <input type="text" name="txtEmail" value="<%= funcionario.getEmail()%>"/><br>
            
        			
           <input type="submit" name="acao" value="Atualizar">
         </form>
         <a href="index.jsp"><input type="submit" value="Voltar"/></a>
         <td>
					
    </body>
</html>