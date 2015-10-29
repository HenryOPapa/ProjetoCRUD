package dao;

/**
 * Author: Henry Papa
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Usuario;
import banco.ConectaBanco;

public class LoginDao extends ConectaBanco {
	
	//conexão com o banco de dados
			private Connection connection;
			private ResultSet rs;

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
		return 0; //Não achou o login! Login invalido!
		 } catch (Exception e) { 
		 e.printStackTrace(); 
		return 0; 
		 } 
		 }

} 
