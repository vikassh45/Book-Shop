

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show2
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		
		String username="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/bookshop";
		String sql="select * from login";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			PrintWriter out=response.getWriter();
			out.println("<html><title>Users</title>");
			out.println("<body>");
			out.println("<table align=center border=1>");
			out.println("<tr>");
			out.println("<th>First Name</th>");
			out.println("<th>Last Name</th>");
			out.println("<th>User-ID</th>");
			out.println("<th>Password</th>");
			out.println("<th>Email-ID</th>");
			//out.println("<th>Delete</th>");
			out.println("</tr>");
         	if(rs.next())
			{
			do
			{  			String fname=rs.getString(1);
		             	String lname=rs.getString(2);
		             	String uname=rs.getString(3);
		             	String pass=rs.getString(4);
		             	String email=rs.getString(5);

				        out.println("<tr>");
			            out.println("<td>");
						out.println(fname);
						out.println("</td>");
						out.println("<td>");
						out.println(lname);
						out.println("</td>");
						out.println("<td>");
						out.println(uname);
						out.println("</td>");
						out.println("<td>");
						out.println(pass);
						out.println("</td>");
						out.println("<td>");
						out.println(email); // ide is the name and id is the value we are giving
						out.println("</td>");
						out.println("</tr>");


			
						
				//out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("price")+" "+rs.getString("author"));

			} while(rs.next());
			out.println("</table>");
			out.println("</body></html>");
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
