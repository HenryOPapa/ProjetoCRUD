package dao;

/**
 * Author: Henry Papa
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.catalina.connector.Request;

import com.sun.org.apache.xpath.internal.operations.Lt;

import modelo.Usuario;
import banco.ConectaBanco;

public class LoginDao extends ConectaBanco {
	
	//conexão com o banco de dados
			private Connection connection;
			private ResultSet rs;
			private String acesso;

			public LoginDao() throws ClassNotFoundException{
				this.connection = new ConectaBanco().getConnection();
			}
	
	
	private static final String SELECT = "SELECT * from usuario where (login=?) and (senha=crypt(?, senha))";
	public int verificaLogin(Usuario usuario) {
		
		try { 
			 PreparedStatement stmt = connection.prepareStatement(SELECT); 
			 stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			this.rs = stmt.executeQuery();
			if (rs.next()) { 
			return 1; //Achou o login!
			 } 
			else
			return 1; //Não achou o login! Login invalido!
			 } catch (Exception e) { 
			 e.printStackTrace(); 
			return 1; 
			 } 
			 }

	
	


public String recuperaAcesso(Usuario usuario) throws SQLException{
	PreparedStatement stmt = connection.prepareStatement(SELECT);
	stmt.setString(1,usuario.getLogin());
	stmt.setString(2,usuario.getSenha());
	ResultSet result = stmt.executeQuery();
	
	while(result.next()){
	acesso = result.getString("acesso");
	
	 }
	return acesso;
}

}
