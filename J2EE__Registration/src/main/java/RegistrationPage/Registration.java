package RegistrationPage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException{
		
		resp.setContentType("text/html");
		PrintWriter pw=resp.getWriter();
		
		String n1 = req.getParameter("name");
		String c1 = req.getParameter("contact");
//		int contact=Integer.parseInt(c1);
		String u1 = req.getParameter("username");
		String p1 = req.getParameter("password");
		
		System.out.println(n1); 
		System.out.println(c1); 
		System.out.println(u1); 
		System.out.println(p1); 
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","9923388663");
			String query="insert into registrationdetails (name,contact,username,password)values(?,?,?,?)";
			PreparedStatement pstmt=con.prepareStatement(query);
//			pstmt.setInt(1,100);
			pstmt.setString(1, n1);
//			pstmt.setInt(2, contact);
			pstmt.setString(2, c1);
			pstmt.setString(3, u1);
			pstmt.setString(4, p1);
			pstmt.executeUpdate();	
			
			
//		    pw.println("<h3>Welcome</h3>");
		    req.getRequestDispatcher("/LoginServlet").forward(req, resp);
				
				
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
