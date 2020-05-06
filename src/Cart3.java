

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
 * Servlet implementation class Cart3
 */
@WebServlet("/Cart3")
public class Cart3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String username="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/bookshop";
		String sql="select * from cart";
		int total=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			ResultSet rs=st.executeQuery();
			PrintWriter out=response.getWriter();
			if(rs.next())
			{
			
			out.println("<html><title>Cart</title>");
			out.println("<body>");
			out.println("<table align=center border=1>");
			out.println("<tr>");
			out.println("<th>Book Id</th>");
			out.println("<th>Book Image</th>");
			out.println("<th>Book Name</th>");
			out.println("<th>Book Price</th>");
			
			out.println("<th>Remove book</th>");
			out.println("</tr>");
         	
			do
			{  			int bookid=rs.getInt("bookid");
		             	String name=rs.getString("name");
		             	int price=rs.getInt("price");
		             	total=total+price;
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
						out.println("<a href=Removecart?bid="+bookid+">Remove from cart</a>"); // ide is the name and id is the value we are giving
						out.println("</td>");
						out.println("</tr>");


			
						
				//out.println(rs.getInt("id")+" "+rs.getString("name")+" "+rs.getInt("price")+" "+rs.getString("author"));

			} while(rs.next());
			out.println("</table>");
			out.println("<h3 align=center border=1>Total Amount is "+total+" </h3>");
			out.println("<h4 align=center><a href=done.jsp >Buy now</a></h4>");
			out.println("</body></html>");
			
		}
			else {out.println("No books in your Cart");}
		}catch (Exception e) {
			e.printStackTrace();
		}
	

		
	}

}
