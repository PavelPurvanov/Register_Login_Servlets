import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import ServletRegisterLogin.ServletRegisterLogin.User;
import ServletRegisterLogin.ServletRegisterLogin.UserRepository;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 public RegisterServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.setContentType("text/html");
			
			String firstName = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String password2 = request.getParameter("password2");
			
		
			User user = new User(firstName, email, password);
			

			if(!UserRepository.contains(user) && password2.equals(password) && Integer.parseInt(password) > 7) {
				
				UserRepository.addUser(user);
				RequestDispatcher rd=request.getRequestDispatcher("Success.html");  
		        rd.forward(request,response); 
		        
			}
			else {
				
				RequestDispatcher rd=request.getRequestDispatcher("Failed.html");  
		        rd.forward(request,response); 
			}
			
		}
		

}
