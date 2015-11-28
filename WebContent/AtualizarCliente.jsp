<%@page import="modelo.Cliente"%>
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
        Cliente cliente = (Cliente)request.getAttribute("cliente");
        %>
        
        <h1>Atualizar!</h1>
        <form action="clienteControle" method="post">
        	
        	ID:<input type="hidden" name="txtId" value="<%=cliente.getId()%>"/>
            Nome:<input type="text" name="txtNome" value="<%= cliente.getNome()%>"/><br>
            RG:<input type="text" name="txtRg" value="<%= cliente.getRg()%>"/><br>
            CPF:     <input type="text" name="txtCpf" value="<%= cliente.getCpf()%>"/><br>
            Telefone:   <input type="text" name="txtTelefone" value="<%= cliente.getTelefone()%>"/><br>
            Endereço: <input type="text" name="txtEndereco" value="<%= cliente.getEndereco() %>"/><br>
            Email: <input type="text" name="txtEmail" value="<%= cliente.getEmail()%>"/><br>
            
        			
           <input type="submit" name="acao" value="Atualizar">
         </form>
         <a href="index.jsp"><input type="submit" value="Voltar"/></a>
         <td>
					
    </body>
</html>