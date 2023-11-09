package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AgendamentoBean;

import model.DaoAgendamento;
import model.LoginBean;



/**
 * Servlet implementation class ControllerAgendamento
 */
@WebServlet(urlPatterns =  { "/ControllerAgendamento", "/agendamentos", "/novoAgendamento", "/horarios", "/gravarAgendamento", "/delete"} )
public class ControllerAgendamento extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HttpSession session;
	LoginBean user;
	DaoAgendamento daoAgendamento = new DaoAgendamento();
	AgendamentoBean agendamentos = new AgendamentoBean();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerAgendamento() {
        super();
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		
		
		
	
		
		if(action.equals("/agendamentos")) {
			agendamentos(request,response);
		}else if(action.equals("/novoAgendamento")) {
			response.sendRedirect("AgendamentoNovo.jsp");
		}else if(action.equals("/horarios")) {
			getHorarios(request,response);
		}else if(action.equals("/gravarAgendamento")) {
			gravaAgendamento(request, response);
		}else if(action.equals("/delete")) {
			deleteAgendam(request, response);
		}else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void agendamentos(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		session = request.getSession();
		
		
		if(session.getAttribute("user") == null){
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			System.out.println("Acesso negado - sem session");
		}
		
		 user = (LoginBean) session.getAttribute("user");
		
		System.out.println("Usuario session " + user.getId());
		
		
		ArrayList<AgendamentoBean> lista = daoAgendamento.listarAgendamento(user.getId());
		request.setAttribute("agendamentos", lista);
		RequestDispatcher rd = request.getRequestDispatcher("agendamento.jsp");
		rd.forward(request, response);
	}
	

	
	protected void getHorarios(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	

		agendamentos.setId(Integer.parseInt(request.getParameter("barbeiro")));
		agendamentos.setDia(request.getParameter("calendario").replace("-", ""));
		
	
		
		ArrayList<AgendamentoBean> lista = daoAgendamento.listaHorarios(agendamentos);
		request.setAttribute("horarios", lista);
		
		RequestDispatcher rd = request.getRequestDispatcher("Horario.jsp");
		rd.forward(request, response);
	}
	
	protected void gravaAgendamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idUSer = user.getId();
		agendamentos.setBarbeiro(request.getParameter("barbeiro"));
		agendamentos.setServico(request.getParameter("servico"));
		agendamentos.setDia(request.getParameter("calendario").replace("-", ""));
		agendamentos.setHorario(request.getParameter("horario").replace(":", ""));
		agendamentos.setStatusAgen("1");
		agendamentos.setIdUser(idUSer);
		
		daoAgendamento.gravaAgendamento(agendamentos);
		
		response.sendRedirect("agendamentos");
	}
	
	protected void deleteAgendam(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		agendamentos.setId(Integer.parseInt(request.getParameter("id")));
		daoAgendamento.deleteAgend(agendamentos);
		response.sendRedirect("agendamentos");
	}
	
	

	

	
	
	

}
