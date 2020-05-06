

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Show2
 */
@WebServlet("/Show2")
public class Show2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Show2() {
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
			out.println("<html><title>Books</title>");
			out.println("<body>");
			out.println("<table align=center border=1>");
			out.println("<tr>");
			out.println("<th>Book Id</th>");
			out.println("<th>Book Image</th>");
			out.println("<th>Book Name</th>");
			out.println("<th>Book Price</th>");
			out.println("<th>Book Author</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");
         	if(rs.next())
			{
			do
			{  			int bookid=rs.getInt("bookid");
		             	String name=rs.getString("name");
		             	int price=rs.getInt("price");
		             	String author=rs.getString("author");
		             	//byte b[]=rs.getBytes("image");
		            // 	ServletOutputStream out1=response.getOutputStream();
		             			

				        out.println("<tr>");
			            out.println("<td>");
						out.println(bookid);
						out.println("</td>");
						out.println("<td>");
						out.println("<img width=100 height=120 src=\"ImageLoader?bid="+bookid+"\">");
						out.println("</td>");
						out.println("<td>");
						out.println(name);
						out.println("</td>");
						out.println("<td>");
						out.println(price);
						out.println("</td>");
						out.println("<td>");
						out.println(author);
						out.println("</td>");
						out.println("<td>");
						out.println("<a href=Delete?ide="+bookid+">Delete</a>"); // ide is the name and id is the value we are giving
						out.println("</td>");
						out.println("</tr>");


			
						
				//out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("price")+" "+rs.getString("author"));

			} while(rs.next());
			out.println("</table>");
			out.println("<a href=Logout align=right>Logout</a>");
			out.println("</body></html>");
			
		}
		}catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}
