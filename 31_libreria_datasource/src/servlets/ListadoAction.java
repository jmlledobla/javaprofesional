package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javabeans.Libro;
import javabeans.Tema;
import modelo.GestionLibros;

/**
 * Servlet implementation class ListadoAction
 */
@WebServlet("/ListadoAction")
public class ListadoAction extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idTema=Integer.parseInt(request.getParameter("tema"));
		GestionLibros glibros=new GestionLibros();
		
		List<Libro> libros;
		if(idTema==0) {
			libros=glibros.recuperarTodos();
		}
		else {
			libros=glibros.recuperarLibrosTema(idTema);
		}
		
	}

}
