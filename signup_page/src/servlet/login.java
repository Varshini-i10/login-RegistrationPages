package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con=null;
		try{
			PrintWriter out = response.getWriter();
			String userName = request.getParameter("uname");
			String password = request.getParameter("pwd");
			Class.forName("com.mysql.jdbc.Driver");  
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
			String sql = "select * from login where username=? and password=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, userName);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if(rs.next())
			{	RequestDispatcher requestDispatcher = request.getRequestDispatcher("home.jsp");
			requestDispatcher.include(request, response);	}
			else
			out.println("<font color=red><b>Invalid user name or password</b></font>");
			out.close();
			}
			catch(Exception e){e.printStackTrace();}
				
	
	
	}

	
}
