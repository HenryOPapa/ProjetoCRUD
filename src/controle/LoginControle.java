package controle;
/**
 * Author: Henry Papa
 */


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import modelo.Usuario;
import dao.LoginDao;


public class LoginControle extends HttpServlet{


	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		try {
			String acao = request.getParameter("acao");
			



			//----------------LOGAR--------------------------------------------------------------------------------------------//
			
				String login = request.getParameter("txtLogin");
				String senha = request.getParameter("txtSenha");
				String acesso = request.getParameter("txtAcesso");
				
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				usuario.setAcesso(acesso);
				
				LoginDao lDao = new LoginDao(); 
				int retorno = lDao.verificaLogin(usuario); 
				RequestDispatcher rd;

				if(retorno==1){
					
					
					HttpSession session = request.getSession();
					 session.setAttribute("usuario", login);
					 session.setAttribute("acesso", acesso);
					rd = request.getRequestDispatcher("index.jsp");
					rd.forward(request, response);
										
				}if(retorno==0){
					
					rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
				


		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		}	

	}
	

}
