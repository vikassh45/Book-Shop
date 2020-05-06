

import java.io.IOException;
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
 * Servlet implementation class ImageLoader
 */
@WebServlet("/ImageLoader")
public class ImageLoader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ImageLoader() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int bookid=Integer.parseInt(request.getParameter("bid"));
		String username="root";
		String password="root";
		String url="jdbc:mysql://localhost:3306/bookshop";
		String sql="select image from book where bookid=?";
      try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url,username,password);
			PreparedStatement st= con.prepareStatement(sql);
			st.setInt(1, bookid);
			ResultSet rs=st.executeQuery();
			rs.next();
			byte b[]=rs.getBytes(1);
			ServletOutputStream out=response.getOutputStream();
			out.write(b);
			
	} catch (Exception e) {
		// TODO: handle exception
	}

		
	}

}
