package controle;
/**
 * Author: Henry Papa
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import modelo.Cliente;

public class ClienteControle extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		PrintWriter out = response.getWriter();

		try{

			String acao = request.getParameter("acao");


			//----------------CADASTRAR--------------------------------------------------------------------------------------------//


			if(acao.equals("Cadastrar")){

				//recuperando os parametros com request
				String nome = request.getParameter("txtNome");
				String rg = request.getParameter("txtRg");
				String cpf = request.getParameter("txtCpf");
				String telefone = request.getParameter("txtTelefone");
				String endereco = request.getParameter("txtEndereco");
				String email = request.getParameter("txtEmail");


						//monta um objeto contato
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setRg(rg);
				cliente.setCpf(cpf);
				cliente.setTelefone(Long.parseLong(telefone));
				cliente.setEndereco(endereco);
				cliente.setEmail(email);


				//salva o contato
				ClienteDao dao;
				try {
					dao = new ClienteDao();
					dao.adiciona(cliente);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//add lista no request
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

			}else

				//-------------LISTAR----------------------------------------------------------------------------------------------//


				if(acao.equals("Listar")){

					ClienteDao cDAO = new ClienteDao();

					List<Cliente> listaClientes = cDAO.getLista();

					//add lista no request
					request.setAttribute("listaClientes", listaClientes);
					RequestDispatcher rd = request.getRequestDispatcher("ListarCliente.jsp");
					rd.forward(request, response);

				}else

					//--------------CONSULTA----------------------------------------------------------------------------------------------//

					if(acao.equals("consultaPorId")){

						int idCliente = Integer.parseInt(request.getParameter("idCliente"));

						ClienteDao cDAO = new ClienteDao();

						Cliente cliente = cDAO.consultaPorId(idCliente);

						request.setAttribute("cliente", cliente);
						RequestDispatcher rd = 
								request.getRequestDispatcher("AtualizarCliente.jsp");
						rd.forward(request, response);


					}else
						//-------------DELETAR----------------------------------------------------------------------------------------------//

						if(acao.equals("Excluir"))	{
							int idCliente = Integer.parseInt(request.getParameter("idCliente"));
							ClienteDao cDAO = new ClienteDao();

							Cliente cliente = cDAO.consultaPorId(idCliente);
							cDAO.remove(cliente);


							request.setAttribute("cliente", cliente);
							RequestDispatcher rd = 
									request.getRequestDispatcher("ListarCliente.jsp");
							rd.forward(request, response);


						}else



							//-------------ATUALIZAR----------------------------------------------------------------------------------------------//


							if (request.getParameter("acao").equals("Atualizar")){
								ClienteDao cDAO = new ClienteDao();


								String idContato = request.getParameter("txtId");
								String nome = request.getParameter("txtNome");
								String rg = request.getParameter("txtRg");
								String cpf = request.getParameter("txtCpf");
								String telefone = request.getParameter("txtTelefone");
								String endereco = request.getParameter("txtEndereco");
								String email = request.getParameter("txtEmail");
								


								Cliente cliente = new Cliente();
								cliente.setId(Integer.parseInt(idContato));
								cliente.setNome(nome);
								cliente.setRg(rg);
								cliente.setCpf(cpf);
								cliente.setTelefone(Long.parseLong(telefone));
								cliente.setEndereco(endereco);
								cliente.setEmail(email); 


								cDAO.altera(cliente);


								RequestDispatcher rd = 
										request.getRequestDispatcher("Index.jsp");
								rd.forward(request, response);
							}






		}catch(Exception erro) {

			//erro.jsp


		}
	}
}


