

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

/**
 * Servlet implementation class temp
 */
@WebServlet("/temp")
public class temp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public temp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name="";
		String author="";
		String description="";
		int price=0;
		byte imgdata[]=null;
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		
		try {
			List<FileItem> items=upload.parseRequest(new ServletRequestContext(request)); 
for (FileItem item : items) {
	String s=item.getFieldName();
	if(s.equals("name"))
	{
		name=item.getString();
	}
	else if(s.equals("price"))
	{
		price=Integer.parseInt(item.getString());
	}
	else if(s.equals("img"))
	{
		imgdata=item.get();
	}
	else if(s.equals("author"))
	{
		 author=item.getString();      
	}
	else if(s.equals("description"))
	{
		description=item.getString();
	}
}
String username="root";
String password="root";
String url="jdbc:mysql://localhost:3306/test";
String sql="insert into book(name,price,author,image,description) values(?,?,?,?,?);";


	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,username,password);
	PreparedStatement st= con.prepareStatement(sql);
	st.setString(1, name);
	st.setInt(2, price);
	st.setString(1, author);
	st.setBytes(3, imgdata);
	st.setString(1, description);
	int n=st.executeUpdate();
	PrintWriter out=response.getWriter();
	if(n>0)
	{
		
		out.println("Book Added");
	}
		
	else out.println("Not added");
	


			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        

		
		
	}

}
