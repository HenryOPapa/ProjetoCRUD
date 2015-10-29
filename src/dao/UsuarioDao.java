package dao;

/**
 * Author: Henry Papa
 */


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banco.ConectaBanco;
import modelo.Usuario;

public class UsuarioDao {

String CREATE = "insert into usuario (id,login,senha,acesso) values (DEFAULT,?,crypt(?,gen_salt('bf',8)),?)";
//String CREATE = "insert into usuario (id,login,senha) values (DEFAULT,?,crypt(?,gen_salt('bf',8)))";
//String CREATE = "insert into usuario (login,senha) values(?,?)";

	//conexão com o banco de dados
	private Connection connection;

	public UsuarioDao() throws ClassNotFoundException{
		this.connection = new ConectaBanco().getConnection();
	}

	//inicio do metodo adicionar
	public void adiciona (Usuario usuario){



		try{	
			//criar statement para inserção
			
			PreparedStatement stmt = connection.prepareStatement(CREATE, PreparedStatement.RETURN_GENERATED_KEYS);
			//seta os valores das variaveis no statement
			stmt.setString(1,usuario.getLogin());
			stmt.setString(2,usuario.getSenha());
			stmt.setString(3,usuario.getAcesso());


			//executar o comando no banco de dados
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()){
				usuario.setId(rs.getInt(1));
			}
			stmt.close();
		}catch (SQLException e){
			throw new RuntimeException (e);
		}

	}


}
