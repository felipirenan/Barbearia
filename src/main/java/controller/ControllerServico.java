package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ServicoBean;
import model.DaoServico;

/**
 * Servlet implementation class ControllerServico
 */
@WebServlet(urlPatterns =  {"/ControllerServico", "/update", "/servicos", "/gravaServico"  , "/selectServico"})
public class ControllerServico extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	DaoServico daoServico = new DaoServico();
	ServicoBean servicos = new ServicoBean();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public ControllerServico() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		
		System.out.println(action);
		
		if(action.equals("/servicos")) {
			servicos(request, response);
			
		}else if(action.equals("/gravaServico")) {
			gravaServico(request, response);
			
		} else if (action.equals("/selectServico")) {
			listarServico(request, response);
			
		} else if (action.equals("/update")) {
			editarServico(request,response);
		}else {
			response.sendRedirect("index.html");
		}
		
	}
	
	protected void servicos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ArrayList<ServicoBean> lista = daoServico.listarServico();
		request.setAttribute("servicos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("Servicos.jsp");
		rd.forward(request, response);
	}
	
	protected void listarServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		servicos.setId(Integer.parseInt(request.getParameter("id")));
		daoServico.selecionarServico(servicos);
		request.setAttribute("id", servicos.getId());
		request.setAttribute("descricao", servicos.getDescricao());
		request.setAttribute("valor", servicos.getValor());
		
		RequestDispatcher rd = request.getRequestDispatcher("ServicoEditar.jsp");
		rd.forward(request, response);
	}
	
	protected void gravaServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//String valor = request.getParameter("valor").replaceAll( "," , "." );
		double valorDouble = Double.parseDouble( request.getParameter("valor") );
		
		servicos.setDescricao(request.getParameter("descricao"));
		servicos.setValor(valorDouble);
		
		daoServico.gravaServico(servicos);
		 
		response.sendRedirect("servicos");
	}
	
	
	
	protected void editarServico(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		servicos.setId(Integer.parseInt(request.getParameter("id")));
		servicos.setDescricao(request.getParameter("descricao"));
		servicos.setValor(Double.parseDouble(request.getParameter("valor")));
		
		daoServico.alterarServico(servicos);
		response.sendRedirect("servicos");
	}
	

}
