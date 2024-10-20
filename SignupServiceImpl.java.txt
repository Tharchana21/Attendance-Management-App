package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.SignupService;
import com.besant.utils.JdbcConnection;

public class SignupServiceImpl implements SignupService {
    @Override
	public void signup(HttpServletRequest req, HttpServletResponse res) {
		
			
			
			System.out.println(req.getParameter("USERNAME"));
			System.out.println(req.getParameter("EMAIL"));
			System.out.println(req.getParameter("DEPARTMENT"));
			System.out.println(req.getParameter("COURSE"));
			System.out.println(req.getParameter("PASSWORD"));
			System.out.println(req.getParameter("CONFIRM PASSWORD"));
			
			try {
				
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "INSERT INTO OnlineAttendanceApp.usersTable(USERNAME, EMAIL, DEPARTMENT, COURSE, PASSWORD, CONFIRMPASSWORD) VALUES (?,?,?,?,?,?)";
			
			//String deleteQuery = "DELETE FROM OnlineAttendanceApp.usersTable WHERE USERNAME=null";
			
			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = res.getWriter();
			
			
			String USERNAME = req.getParameter("USERNAME");
			String EMAIL = req.getParameter("EMAIL");
			String DEPARTMENT = req.getParameter("DEPARTMENT");
			String COURSE = req.getParameter("COURSE");
			String PASSWORD = req.getParameter("PASSWORD");
			String CONFIRMPASSWORD = req.getParameter("CONFIRM PASSWORD");
			
			
			pre.setString(1, USERNAME);
			pre.setString(2, EMAIL);
			pre.setString(3, DEPARTMENT);
			pre.setString(4, COURSE);
			pre.setString(5, PASSWORD);
			pre.setString(6, CONFIRMPASSWORD);
			
			
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				res.sendRedirect("login.html");
				out.println("<h2>Success: Data successfully inserted into the database.</h2>");
			} else {
				out.println("<h2>Error: No rows inserted.</h2>");
			}
			//out.println("<p>This is a basic servlet example in Java EE.</p>");
			//out.println("</body></html>");
			// Close resources
			pre.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

