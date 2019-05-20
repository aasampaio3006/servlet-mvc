package br.org.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.servlet.DAO.EmpresaDAO;
import br.org.servlet.model.Empresa;

/**
 * Servlet implementation class ListaEmpresaServlet
 */
@WebServlet("/listaEmpresa")
public class ListaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		List<Empresa> lista = EmpresaDAO.list();
	   request.setAttribute("empresas", lista);
	   
	   RequestDispatcher requestDispatcher = request.getRequestDispatcher("/listaEmpresa.jsp");
	   requestDispatcher.forward(request, response);
	   
	}

}
