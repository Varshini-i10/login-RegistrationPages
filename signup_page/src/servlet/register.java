package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class register
 */
public class register extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		try{
			PrintWriter out = response.getWriter();
			String userName = request.getParameter("uname");
			String password = request.getParameter("pwd");
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
			String sql = "insert into login values(?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			int i=st.executeUpdate();  
			if(i>0)  {
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);	}
			
			out.close();
			}
			catch(Exception e){e.printStackTrace();}
				
	
	}

	
}
