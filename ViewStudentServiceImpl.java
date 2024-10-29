package com.besant.services.impl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.model.Student;
import com.besant.services.ViewStudentService;
import com.besant.utils.JdbcConnection;

public class ViewStudentServiceImpl implements ViewStudentService  {

	@Override
	public void viewStudent (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Student> students = new ArrayList<>();
		try {
			JdbcConnection.jdbc();
			PreparedStatement pre = JdbcConnection.con.prepareStatement("SELECT * FROM OnlineAttendanceApp.attendanceData");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
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
				System.out.println(students);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("students", students);
		request.getRequestDispatcher("students.jsp").forward(request, response);
	}

	
}

