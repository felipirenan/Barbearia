package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DaoLogin;
import model.LoginBean;



/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns =  {"/Controllerlogin", "/login", "/gravaLogin", "/acessar"})
public class ControllerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public HttpSession session;
	
	
	DaoLogin daoLogin = new DaoLogin();
	LoginBean usuarios = new LoginBean();
	

	

	
	public boolean acesso = false;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	
	
    public ControllerLogin() {
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
		
		
	
		
		if(action.equals("/login")) {
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			
		}else if(action.equals("/gravaLogin")) {
			try {
				gravaLogin(request, response);
			} catch (NoSuchAlgorithmException | ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(action.equals("/acessar")) {
			try {
				acessar(request,response);
			} catch (NoSuchAlgorithmException | ServletException | IOException e) {
				// TODO Auto-generated catch block
			System.out.println(e);;
			}
		}
		
		else {
			response.sendRedirect("index.html");
		}
	}
	
	protected void gravaLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		
		usuarios.setLogin(request.getParameter("nome"));
		usuarios.setSenha(request.getParameter("senha"));
		
		daoLogin.gravaLogin(usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("index.html");
		rd.forward(request, response);
	}
	
	

	
	
	protected void acessar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NoSuchAlgorithmException {
		String usuario;
		
		
		usuarios.setLogin(request.getParameter("nome"));
		usuarios.setSenha(request.getParameter("senha"));
		
		
		
		usuario = daoLogin.acessar(usuarios);
		if (usuario.equals("0")) {
			this.acesso = false;
			request.setAttribute("acesso", acesso);
			System.out.println("usuario incorreto");			
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
			//response.sendRedirect("login.jsp");
			
		}else {
			
			if ( ComparaHash(usuario, usuarios.getSenha())) {
				this.acesso = true;
				this.session = request.getSession();
		        this.session.setAttribute("user", daoLogin.retornaLogin(request.getParameter("nome")));
				
		        LoginBean tst = (LoginBean)session.getAttribute("user");
		        
		        System.out.println(tst.getLogin());
		        
				System.out.println("senha correta");
				
				request.setAttribute("acesso", acesso);
				//request.setAttribute("user", daoLogin.retornaLogin(request.getParameter("nome")));
				
				response.sendRedirect("login.jsp");
				
				
					}else {
						acesso = false;
						request.setAttribute("acesso", acesso);
						System.out.println("senha errada");
					
						response.sendRedirect("login.jsp");
			}
		 
		}
		

	}
	
		
	
	public static boolean ComparaHash(String senhaAtual, String senhaNova) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		
		//String senhaNovaHash = HashSenha(senhaNova);
		
		if (senhaNova.equals(senhaAtual)) {
			return true;
		}else {
			return false;
		}
		
	}

}
