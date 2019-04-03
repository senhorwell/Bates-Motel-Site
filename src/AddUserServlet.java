import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdicionarContatoServlet
 */
@WebServlet("/adicionar")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddUserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		
		
		//dataNascimento.setTime(date);
		
		User contato = new User();
		
		contato.setPassword(password);
		contato.setEmail(email);
		contato.setName(name);
		
		UserDAO contatoDao = 
				new UserDAO();
		
		contatoDao.inserir(contato);
		
		RequestDispatcher view = 
				request.getRequestDispatcher("index.jsp");
		view.forward(request, response);

	}

}
