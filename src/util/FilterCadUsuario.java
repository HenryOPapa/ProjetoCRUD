package util;

/**
 * Author: Henry Papa
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Usuario;


@WebFilter("/Filter")
public class FilterCadUsuario implements javax.servlet.Filter {
	private static final String JSP = ".jsp";

   
    public FilterCadUsuario() {
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse rs = (HttpServletResponse) response;
		HttpSession session = rq.getSession();
		
		if (session.getAttribute("acesso") == "Administrador"){
			chain.doFilter(request, response);
		}else{
			rs.sendRedirect("index.jsp");
		}
		
		
	}
	
	

	/**
	 * @see FilterCadUsuario#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
	
