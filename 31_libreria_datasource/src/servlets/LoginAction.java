package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.GestionClientes;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwd=request.getParameter("pwd");
		String us=request.getParameter("user");
		GestionClientes gclientes=new GestionClientes();
		if(gclientes.estaregistrado(us, pwd)){
			String valorCookie="";
			if(request.getParameter("recordar")!=null) {
				valorCookie=request.getParameter("user");
			}
			guardarCookie(valorCookie,response);
			//guardamos el usuario en un atributo de sesi�n
			HttpSession s=request.getSession();
			s.setAttribute("user", request.getParameter("user"));		
			//obtener requestdispatcher
			RequestDispatcher rd=request.getRequestDispatcher("temas.jsp");
			//trasnferir petici�n
			rd.forward(request, response);
			
		}else{
			//obtener requestdispatcher
			RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
			//trasnferir petici�n
			rd.forward(request, response);
		}
	}
	private void guardarCookie(String valor, HttpServletResponse resp) {
		Cookie ck=new Cookie("user",valor);
		ck.setMaxAge(200000);
		resp.addCookie(ck);
	}

}
