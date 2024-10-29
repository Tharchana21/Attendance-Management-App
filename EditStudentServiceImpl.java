package com.besant.services.impl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.services.EditStudentService;
import com.besant.utils.JdbcConnection;

public class EditStudentServiceImpl implements EditStudentService {

	@Override
	public void editStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<Student> students = new ArrayList<>();

		try {
			JdbcConnection.jdbc();

			PreparedStatement pre = JdbcConnection.con
					.prepareStatement("SELECT * FROM OnlineAttendanceApp.attendanceData where id= ?");

			int id = Integer.parseInt(req.getParameter("id"));

			pre.setInt(1, id);

			ResultSet rs = pre.executeQuery();

			if (rs.next()) {
				Student student = new Student();
				student.setID(rs.getString("ID"));
				student.setROLLNUMBER(rs.getString("ROLLNUMBER"));
				student.setSTUDENTNAME(rs.getString("STUDENTNAME"));
				student.setCOURSE(rs.getString("COURSE"));
				student.setATTENDANCESTATUS(rs.getString("ATTENDANCESTATUS"));
				student.setATTENDANCEDATE(rs.getString("ATTENDANCEDATE"));
				student.setCREATOR_ID(rs.getInt("CREATOR_ID"));
				student.setCREATED_AT(rs.getString("CREATED_AT"));
				students.add(student);
				
				
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

		req.setAttribute("students", students);
		req.getRequestDispatcher("EditStudent.jsp").forward(req, res);
	}

	@Override
	public void updateRecord(HttpServletRequest req, HttpServletResponse res) {
		try {
			// Ensure the connection is established
			JdbcConnection.jdbc();

			// SQL query to update the student record
			String updateQuery = "UPDATE OnlineAttendanceApp.attendanceData SET ROLLNUMBER=?, STUDENTNAME=?, COURSE=?, ATTENDANCESTATUS=?, ATTENDANCEDATE=? WHERE ID=?;";

			// Prepare the statement
			PreparedStatement pre = JdbcConnection.con.prepareStatement(updateQuery);
			PrintWriter out = res.getWriter();

			// Get parameters from the request
			String ROLLNUMBER = req.getParameter("ROLLNUMBER");
			String STUDENTNAME = req.getParameter("STUDENTNAME");
			String COURSE = req.getParameter("COURSE");
			String ATTENDANCESTATUS = req.getParameter("ATTENDANCESTATUS");
			String ATTENDANCEDATE = req.getParameter("ATTENDANCEDATE");
			//int CREATOR_ID= Integer.parseInt(req.getParameter("CREATOR_ID"));
			int ID = Integer.parseInt(req.getParameter("ID")); // The student's id to update
			//String ID = req.getParameter("ID");
			
			// Set the parameters for the prepared statement
			pre.setString(1, ROLLNUMBER);
			pre.setString(2, STUDENTNAME);
			pre.setString(3, COURSE);
			pre.setString(4, ATTENDANCESTATUS);
			pre.setString(5, ATTENDANCEDATE);
			//pre.setInt(6, CREATOR_ID);
			pre.setInt(6, ID);
			
			// Execute the update
			int rowsAffected = pre.executeUpdate();

			if (rowsAffected > 0) {
				// Redirect to the viewStudents page after successful update
				res.sendRedirect("/AttendanceManagementApp/view");
			} else {
				out.println("<h2>Error: No rows updated. The record might not exist.</h2>");
			}

			pre.close();

		} catch (Exception e) {
			e.printStackTrace(); // Print stack trace for debugging
		}
	}

}
