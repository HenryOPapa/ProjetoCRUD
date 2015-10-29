package controle;

/**
 * Author: Henry Papa
 */


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoffControle extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		request.getSession().invalidate();
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	
	}
}
