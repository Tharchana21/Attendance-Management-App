package com.besant.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.AttendanceServiceImpl;

@WebServlet("/attendance")
public class AttendanceController extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
	{
		AttendanceServiceImpl attendanceService = new AttendanceServiceImpl();
        attendanceService.attendance(req, res);
	}

}
