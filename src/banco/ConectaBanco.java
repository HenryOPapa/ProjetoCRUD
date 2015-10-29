package banco;

/**
 * Author: Henry Papa
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConectaBanco {
	public Connection getConnection() throws ClassNotFoundException{
		System.out.println("Conectando ao banco");
		
		try{
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/projeto","postgres","henry");
		}catch (SQLException e){
			throw new RuntimeException(e);
		}
	}

}
