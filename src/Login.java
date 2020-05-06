

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	String uname=request.getParameter("uname");
	String pass=request.getParameter("pass");
	Logindao dao=new Logindao();
	if(dao.check(uname, pass))
	{
		HttpSession session=request.getSession();
		session.setAttribute("username", uname);
		response.sendRedirect("Buyer");
	}
	else 
	{
		response.sendRedirect("login.jsp");
	}
	
		
	}

}
