package dao;

/**
 * Author: Henry Papa
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import banco.ConectaBanco;
import modelo.Cliente;

public class ClienteDao {
	
	String CREATE = "INSERT INTO cliente (nome,rg,cpf,telefone,endereco,email) VALUES (?,?,?,?,?,?)";
	String SHOWLIST = "SELECT * FROM cliente";
	String UPDATE = "UPDATE cliente SET nome=?, rg=?, cpf=?, telefone=?,endereco=?, email=?";
	String DELETE = "DELETE FROM cliente WHERE id=?";
	String CONSULTA_POR_ID="SELECT * FROM cliente WHERE id=?";
	
	//conexão com o banco de dados
		private Connection connection;

		public ClienteDao() throws ClassNotFoundException{
			this.connection = new ConectaBanco().getConnection();
		}


		//-------------ADICIONAR---------------------------------------------------------------------------------//

		
		//inicio do metodo adicionar
		public void adiciona (Cliente cliente){
			


			try{
				//criar statement para inserção
				PreparedStatement stmt = connection.prepareStatement(CREATE);

				//seta os valores das variaveis no statement
				stmt.setString(1,cliente.getNome());
				stmt.setString(2,cliente.getRg());
				stmt.setString(3,cliente.getCpf());
				stmt.setLong(4, cliente.getTelefone());
				stmt.setString(5,cliente.getEndereco());
				stmt.setString(6, cliente.getEmail());

				//executar o comando no banco de dados
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}

		}


		//-------------LISTA---------------------------------------------------------------------------------//
		
		//inicio do metodo listar todos
		public List<Cliente> getLista(){



			List<Cliente> listaCliente = new ArrayList<Cliente>();

			try{

				PreparedStatement pstmt =connection.prepareStatement(SHOWLIST);
				ResultSet rs =  pstmt.executeQuery();


				//monta lista de objetos
				while(rs.next()){
					//a cada loop
					Cliente cliente = new Cliente();
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setRg(rs.getString("rg"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setTelefone(rs.getLong("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setEmail(rs.getString("email"));
					//add na lista
					listaCliente.add(cliente);
				}

			}catch (Exception ex) {
				throw new RuntimeException(ex);
			}

			return listaCliente;


		}
		//-------------ALTERAR-----------------------------------------------------------------------------------------------//

		//Inicio do método alterar
		public void altera (Cliente cliente){

			try{
				PreparedStatement stmt = connection.prepareStatement(UPDATE);
				stmt.setString(1,cliente.getNome());
				stmt.setString(2,cliente.getRg());
				stmt.setString(3,cliente.getCpf());
				stmt.setLong(4, cliente.getTelefone());
				stmt.setString(5,cliente.getEndereco());
				stmt.setString(6, cliente.getEmail());
				stmt.execute();
				stmt.close();

			}catch (SQLException e){
				throw new RuntimeException(e);
			}
		}


		//-------DELETAR-----------------------------------------------------------------------------------------------------//


		//inicio do metodo deletar
		public void remove (Cliente cliente){
			try{
				PreparedStatement stmt = connection.prepareStatement(DELETE);
				stmt.setLong(1, cliente.getId());
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}

		//---------------CONSULTAR---------------------------------------------------------------------------------------------//


		public Cliente consultaPorId(int idCliente) {
			Cliente  cliente = new Cliente();

			try{


				PreparedStatement pstmt = connection.prepareStatement(CONSULTA_POR_ID);
				pstmt.setInt(1, idCliente);

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()){
					cliente.setId(rs.getInt("id"));
					cliente.setNome(rs.getString("nome"));
					cliente.setRg(rs.getString("rg"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setTelefone(rs.getLong("telefone"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setEmail(rs.getString("email"));
				}


			}catch (SQLException e){
				throw new RuntimeException (e);
			}
			return cliente;
		}
		
		//------------------------------------------------------------------------------------------------------------//

	}
