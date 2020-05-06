

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
 * Servlet implementation class Show
 */
@WebServlet("/Show")
public class Show extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show() {
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
		String sql="select * from book";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			PrintWriter out=response.getWriter();
           

			if(rs.next())
			{
			do
			{
				out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("price")+" "+rs.getString("author"));

			} while(rs.next());
			//out.println("Total number of books available are");
			//out.println(k);
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	

		
	}

}
