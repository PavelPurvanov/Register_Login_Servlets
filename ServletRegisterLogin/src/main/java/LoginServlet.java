import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ServletRegisterLogin.ServletRegisterLogin.User;
import ServletRegisterLogin.ServletRegisterLogin.UserRepository;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = logInValidation(email,password);
		
		if(user!=null) {
			request.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher("OnSuccessLogin");  
	        rd.forward(request,response);	
		}
		else {
			RequestDispatcher rd=request.getRequestDispatcher("LogInFailed.html");  
	        rd.forward(request,response); 
		}
	}
	
	public User logInValidation(String email, String password) {
		User user = new User(email,password);
		user = UserRepository.getUser(user);
		return user;
	}

}