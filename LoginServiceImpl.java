package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.LoginService;
import com.besant.utils.JdbcConnection;

public class LoginServiceImpl implements LoginService {

	public void login(HttpServletRequest req, HttpServletResponse res) {
		
		 try
		  {
			  JdbcConnection.jdbc();  // Ensure the connection is established
			  String SelectQuery = "SELECT id, USERNAME, PASSWORD FROM OnlineAttendanceApp.usersTable WHERE USERNAME = ? AND PASSWORD = ?;";
			  
			  
			  PreparedStatement pre = JdbcConnection.con.prepareStatement(SelectQuery);
				PrintWriter out = res.getWriter();
				
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				
				pre.setString(1, username);
				pre.setString(2, password);
				
				ResultSet resultSet = pre.executeQuery();
				if (resultSet.next()) {

					User user = new User();
					user.setId(resultSet.getInt("id"));
					//storing id temporary
					HttpSession session = req.getSession();
					session.setAttribute("uid", resultSet.getInt("id"));
					System.out.println("login "+session.getAttribute("uid"));

					
					res.sendRedirect("attendance.html");
					out.println("logged in success");
				} else {
					out.println("logged in failed");
				}
				// Close resources
				pre.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}

}

