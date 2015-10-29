package controle;

/**
 * Author: Henry Papa
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import dao.UsuarioDao;

public class UsuarioControle extends HttpServlet{


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
				String login = request.getParameter("txtLogin");
				String senha = request.getParameter("txtSenha");
				String acesso = request.getParameter("txtAcesso");



				//monta um objeto contato
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				usuario.setAcesso(acesso);
				

				//salva o contato
				UsuarioDao dao;	
				try {
					dao = new UsuarioDao();
					dao.adiciona(usuario);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				//add lista no request
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);

			}

		}catch(Exception erro) {

			//erro.jsp


		}

	}
}