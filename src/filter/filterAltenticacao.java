package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/principal/*"})// intercepta todas as requisiçoes que vierem do projeto ou mapeamento
public class filterAltenticacao implements Filter {

  
    public filterAltenticacao() {
    }

    // encerra o processo quando o servidor e parado 
    // mataria o processo de conexao com o banco 
	public void destroy() {
	}

	// Itercepta as requisiçoes e da as respostas no sistema
	// Tudo que fizer no sistema vai passar por aqui
	// Validação de autenticação
	// dar commit e ralback de transaçoes no banco
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		String usuarioLogado = (String) session.getAttribute("usuario");
		
		String urlParaAutenticar = req.getServletPath();/*Url que está sendo acessada*/
		
		/*Validar se está logado senão redireciona para a tela de login*/
		if (usuarioLogado == null  && 
				!urlParaAutenticar.equalsIgnoreCase("/principal/ServletLogin")) {/*Não está logado*/
			
			RequestDispatcher redireciona = request.getRequestDispatcher("/index.jsp?url=" + urlParaAutenticar);
			request.setAttribute("msg", "Por favor realize o login!");
			redireciona.forward(request, response);
			return; /*Para a execução e redireciona para o login*/
		}else {
			chain.doFilter(request, response);
		}
	
		
	}

	// inicia o processo e recursos quando o servidor sobe o projeto 
	// exemplo: iniciar conexao com o banco
	public void init(FilterConfig fConfig) throws ServletException {
	}

}