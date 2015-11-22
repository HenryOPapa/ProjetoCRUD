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

import dao.FuncionarioDao;
import modelo.Funcionario;

public class FuncionarioControle extends HttpServlet{

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
				Funcionario funcionario = new Funcionario();
				funcionario.setNome(nome);
				funcionario.setRg(rg);
				funcionario.setCpf(cpf);
				funcionario.setTelefone(Long.parseLong(telefone));
				funcionario.setEndereco(endereco);
				funcionario.setEmail(email);


				//salva o contato
				FuncionarioDao dao;
				try {
					dao = new FuncionarioDao();
					dao.adiciona(funcionario);
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

					FuncionarioDao cDAO = new FuncionarioDao();

					List<Funcionario> listaFuncionarios = cDAO.getLista();

					//add lista no request
					request.setAttribute("listaFuncionarios", listaFuncionarios);
					RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionario.jsp");
					rd.forward(request, response);

				}else

					//--------------Editar----------------------------------------------------------------------------------------------//

					if(acao.equals("Editar")){

						int idfuncionario = Integer.parseInt(request.getParameter("txtId"));

						FuncionarioDao cDAO = new FuncionarioDao();

						Funcionario funcionario = cDAO.consultaPorId(idfuncionario);

						request.setAttribute("funcionario", funcionario);
						RequestDispatcher rd = 
								request.getRequestDispatcher("AtualizarFuncionario.jsp");
						rd.forward(request, response);


					}else
						//-------------DELETAR----------------------------------------------------------------------------------------------//

						if(acao.equals("Excluir"))	{

							int idfuncionario = Integer.parseInt(request.getParameter("txtId"));
							FuncionarioDao cDAO = new FuncionarioDao();


							Funcionario funcionario = cDAO.consultaPorId(idfuncionario);
							cDAO.remove(funcionario);

							List<Funcionario> listaFuncionarios = cDAO.getLista();
							request.setAttribute("listaFuncionarios", listaFuncionarios);

							RequestDispatcher rd = request.getRequestDispatcher("ListarFuncionario.jsp");
							rd.forward(request, response);


						}else



							//-------------ATUALIZAR----------------------------------------------------------------------------------------------//


							if (request.getParameter("acao").equals("Atualizar")){
								FuncionarioDao cDAO = new FuncionarioDao();


								String idFunciorio = request.getParameter("txtId");
								String nome = request.getParameter("txtNome");
								String rg = request.getParameter("txtRg");
								String cpf = request.getParameter("txtCpf");
								String telefone = request.getParameter("txtTelefone");
								String endereco = request.getParameter("txtEndereco");
								String email = request.getParameter("txtEmail");



								Funcionario funcionario = new Funcionario();
								funcionario.setId(Integer.parseInt(idFunciorio));
								funcionario.setNome(nome);
								funcionario.setRg(rg);
								funcionario.setCpf(cpf);
								funcionario.setTelefone(Long.parseLong(telefone));
								funcionario.setEndereco(endereco);
								funcionario.setEmail(email); 


								cDAO.altera(funcionario);


								RequestDispatcher rd = 
										request.getRequestDispatcher("index.jsp");
								rd.forward(request, response);
							}






		}catch(Exception erro) {

			//erro.jsp


		}
	}

}
