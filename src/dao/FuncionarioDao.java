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
import modelo.Funcionario;

public class FuncionarioDao {


	
	String CREATE = "INSERT INTO funcionario (nome,rg,cpf,telefone,endereco,email) VALUES (?,?,?,?,?,?)";
	String SHOWLIST = "SELECT * FROM funcionario";
	String UPDATE = "UPDATE funcionario SET nome=?, rg=?, cpf=?, telefone=?,endereco=?, email=?";
	String DELETE = "DELETE FROM funcionario WHERE id=?";
	String CONSULTA_POR_ID="SELECT * FROM funcionario WHERE id=?";
	
	//conexão com o banco de dados
		private Connection connection;

		public FuncionarioDao() throws ClassNotFoundException{
			this.connection = new ConectaBanco().getConnection();
		}


		//-------------ADICIONAR---------------------------------------------------------------------------------//

		
		//inicio do metodo adicionar
		public void adiciona (Funcionario funcionario){
			


			try{
				//criar statement para inserção
				PreparedStatement stmt = connection.prepareStatement(CREATE);

				//seta os valores das variaveis no statement
				stmt.setString(1,funcionario.getNome());
				stmt.setString(2,funcionario.getRg());
				stmt.setString(3,funcionario.getCpf());
				stmt.setLong(4, funcionario.getTelefone());
				stmt.setString(5,funcionario.getEndereco());
				stmt.setString(6, funcionario.getEmail());

				//executar o comando no banco de dados
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}

		}


		//-------------LISTA---------------------------------------------------------------------------------//
		
		//inicio do metodo listar todos
		public List<Funcionario> getLista(){



			List<Funcionario> listafuncionario = new ArrayList<Funcionario>();

			try{

				PreparedStatement pstmt =connection.prepareStatement(SHOWLIST);
				ResultSet rs =  pstmt.executeQuery();


				//monta lista de objetos
				while(rs.next()){
					//a cada loop
					Funcionario funcionario = new Funcionario();
					funcionario.setId(rs.getInt("id"));
					funcionario.setNome(rs.getString("nome"));
					funcionario.setRg(rs.getString("rg"));
					funcionario.setCpf(rs.getString("cpf"));
					funcionario.setTelefone(rs.getLong("telefone"));
					funcionario.setEndereco(rs.getString("endereco"));
					funcionario.setEmail(rs.getString("email"));
					//add na lista
					listafuncionario.add(funcionario);
				}

			}catch (Exception ex) {
				throw new RuntimeException(ex);
			}

			return listafuncionario;


		}
		//-------------ALTERAR-----------------------------------------------------------------------------------------------//

		//Inicio do método alterar
		public void altera (Funcionario funcionario){

			try{
				PreparedStatement stmt = connection.prepareStatement(UPDATE);
				stmt.setString(1,funcionario.getNome());
				stmt.setString(2,funcionario.getRg());
				stmt.setString(3,funcionario.getCpf());
				stmt.setLong(4, funcionario.getTelefone());
				stmt.setString(5,funcionario.getEndereco());
				stmt.setString(6, funcionario.getEmail());
				stmt.execute();
				stmt.close();

			}catch (SQLException e){
				throw new RuntimeException(e);
			}
		}


		//-------DELETAR-----------------------------------------------------------------------------------------------------//


		//inicio do metodo deletar
		public void remove (Funcionario funcionario){
			try{
				PreparedStatement stmt = connection.prepareStatement(DELETE);
				stmt.setLong(1, funcionario.getId());
				stmt.execute();
				stmt.close();
			}catch (SQLException e){
				throw new RuntimeException (e);
			}
		}

		//---------------CONSULTAR---------------------------------------------------------------------------------------------//


		public Funcionario consultaPorId(int idfuncionario) {
			Funcionario  funcionario = new Funcionario();

			try{


				PreparedStatement pstmt = connection.prepareStatement(CONSULTA_POR_ID);
				pstmt.setInt(1, idfuncionario);

				ResultSet rs = pstmt.executeQuery();

				if(rs.next()){
					funcionario.setId(rs.getInt("id"));
					funcionario.setNome(rs.getString("nome"));
					funcionario.setRg(rs.getString("rg"));
					funcionario.setCpf(rs.getString("cpf"));
					funcionario.setTelefone(rs.getLong("telefone"));
					funcionario.setEndereco(rs.getString("endereco"));
					funcionario.setEmail(rs.getString("email"));
				}


			}catch (SQLException e){
				throw new RuntimeException (e);
			}
			return funcionario;
		}
		
		//------------------------------------------------------------------------------------------------------------//

	}

