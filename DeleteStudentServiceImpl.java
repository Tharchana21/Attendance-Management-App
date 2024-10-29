package com.besant.services.impl;

import java.io.PrintWriter;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.utils.JdbcConnection;

public class DeleteStudentServiceImpl {

	public void deleteStudentRecord(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		try {
			JdbcConnection.jdbc(); // Ensure the connection is established
			String insertQuery = "DELETE FROM OnlineAttendanceApp.attendanceData WHERE id=?;";
			PreparedStatement pre = JdbcConnection.con.prepareStatement(insertQuery);
			PrintWriter out = response.getWriter();
			int id = Integer.parseInt(request.getParameter("id"));
			pre.setInt(1, id);
			int rowsAffected = pre.executeUpdate();
			if (rowsAffected > 0) {
				response.sendRedirect("/AttendanceManagementApp/view");
			} else {
				out.println("<h2>Error: No rows deleted. The record might not exist.</h2>");
			}
			pre.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
