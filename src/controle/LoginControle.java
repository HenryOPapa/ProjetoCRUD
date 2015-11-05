package controle;
/**
 * Author: Henry Papa
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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
			
			//----------------LOGAR--------------------------------------------------------------------------------------------//
			
				String login = request.getParameter("txtLogin");
				String senha = request.getParameter("txtSenha");
				
				Usuario usuario = new Usuario();
				usuario.setLogin(login);
				usuario.setSenha(senha);
				
				LoginDao lDao = new LoginDao(); 
				int retorno = lDao.verificaLogin(usuario); 
				String acesso = lDao.recuperaAcesso(usuario);
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
				


		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();

		}
	}
	

}
