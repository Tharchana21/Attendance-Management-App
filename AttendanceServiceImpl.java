package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.AttendanceService;
import com.besant.utils.JdbcConnection;

public class AttendanceServiceImpl implements AttendanceService {
	
	public void attendance(HttpServletRequest req, HttpServletResponse res)
	{
		
	System.out.println(req.getParameter("ROLLNUMBER"));
	System.out.println(req.getParameter("STUDENTNAME"));
	System.out.println(req.getParameter("COURSE"));
	System.out.println(req.getParameter("ATTENDANCESTATUS"));
	System.out.println(req.getParameter("ATTENDANCEDATE"));
		 try
		  {
			  JdbcConnection.jdbc();  // Ensure the connection is established
				String insertQuery = "INSERT INTO OnlineAttendanceApp.attendanceData(ROLLNUMBER,STUDENTNAME,COURSE,ATTENDANCESTATUS,ATTENDANCEDATE) VALUES (?,?,?,?,?)";

				PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
				PrintWriter out = res.getWriter();
				
				String ROLLNUMBER = req.getParameter("ROLLNUMBER");
				String STUDENTNAME = req.getParameter("STUDENTNAME");
				String COURSE = req.getParameter("COURSE");
				String ATTENDANCESTATUS = req.getParameter("ATTENDANCESTATUS");
				String ATTENDANCEDATE = req.getParameter("ATTENDANCEDATE");
				
				pre.setString(1, ROLLNUMBER);
				pre.setString(2, STUDENTNAME);
				pre.setString(3, COURSE);
				pre.setString(4, ATTENDANCESTATUS);
				pre.setString(5, ATTENDANCEDATE);
				
				int rowsAffected = pre.executeUpdate();
				if (rowsAffected > 0) {
					//res.sendRedirect("login.html");
					out.println("Success: Data successfully inserted into the database.");
				} else {
					out.println("Error: No rows inserted.");
				}
				//out.println("<p>This is a basic servlet example in Java EE.</p>");
				// out.println("</body></html>");
				// Close resources
				pre.close();
			} catch (Exception e) {
				System.out.println(e);
			}
	}

} 

