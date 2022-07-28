package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ModelLogin;

// ou chamadas de controller ou ServletController
@WebServlet("/ServletLogin")// mapeamento de url que vem da tela 
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletLogin() {
        super();
       
    }

	// Recebe os dados pela url em parametros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	// Recebe os dados enviados por um formulario
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
	
		
		if(login != null && !login.isEmpty() && senha !=null && !senha.isEmpty()){
			ModelLogin modelLogin = new ModelLogin();
			modelLogin.setLogin(login);
			modelLogin.setSenha(senha);
		}else {
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg","Verifique se a senha ou login esta correto");
			redirecionar.forward(request, response);
		}
		
		
		
		
		
		
		
	}

}
