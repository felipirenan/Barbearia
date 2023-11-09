package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BarbeiroBean;
import model.Daobarbeiro;

/**
 * Servlet implementation class ControllerBarbeiro
 */
@WebServlet(urlPatterns =  {"/ControllerBarbeiro",  "/barbeiros", "/gravaBarbeiro", "/selectBarbeiro", "/updateBarbeiro"} )
public class ControllerBarbeiro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Daobarbeiro daoBarbeiro = new Daobarbeiro();
	BarbeiroBean barbeiros = new BarbeiroBean();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerBarbeiro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getServletPath();
			
			if(action.equals("/barbeiros")) {
				barbeiros(request,response);
			}else if(action.equals("/gravaBarbeiro")) {
				gravaBarbeiro(request, response);
			}else if(action.equals("/selectBarbeiro")) {
				listarBarbeiros(request, response);
			}else if(action.equals("/updateBarbeiro")) {
				editarBarbeiro(request, response);
			}
			
			else {
				response.sendRedirect("index.html");
			}
			
	}
	
	
	protected void barbeiros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<BarbeiroBean> lista = daoBarbeiro.listarBarbeiros();
		request.setAttribute("barbeiros", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Barbeiros.jsp");
		rd.forward(request, response);
	}
	
	
	protected void listarBarbeiros(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		barbeiros.setId(Integer.parseInt(request.getParameter("id")));
		daoBarbeiro.selecionarBarbeiros(barbeiros);
		request.setAttribute("id", barbeiros.getId());
		request.setAttribute("nome", barbeiros.getNome());
		request.setAttribute("tel", barbeiros.getTelefone());
		
		RequestDispatcher rd = request.getRequestDispatcher("BarbeiroEditar.jsp");
		rd.forward(request, response);
	}
	
	
	protected void gravaBarbeiro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		barbeiros.setNome(request.getParameter("nomeBarbeiro"));
		barbeiros.setTelefone(request.getParameter("foneBarbeiro"));
		
		daoBarbeiro.gravaBarbeiro(barbeiros); 
		response.sendRedirect("barbeiros");
	}
	
	protected void editarBarbeiro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		barbeiros.setId(Integer.parseInt(request.getParameter("id")));
		barbeiros.setNome(request.getParameter("nome"));
		barbeiros.setTelefone(request.getParameter("tel"));
		
		daoBarbeiro.alterarBarbeiros(barbeiros);
		response.sendRedirect("barbeiros");
	}

}
