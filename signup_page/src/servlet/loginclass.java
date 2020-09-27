package servlet;

import java.sql.*;
public class loginclass {

	public static void main(String[] args)   {
		// TODO Auto-generated method stub

		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/login","root","root");  
			 Statement s= con.createStatement();
			 String ss="select * from login";
			 ResultSet r= s.executeQuery(ss);
			 while(r.next()) {
				 System.out.println(r.getString("username"));
			 }
		}
		catch(SQLException e)
		{
			System.out.println("vaski ");
		}
		catch(ClassNotFoundException e)
{
e.printStackTrace();
System.out.println("vaski");
}
		
	}

}
