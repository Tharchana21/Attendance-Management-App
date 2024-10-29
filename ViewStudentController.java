package com.besant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.ViewStudentServiceImpl;

@WebServlet("/view")
public class ViewStudentController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		ViewStudentServiceImpl service = new  ViewStudentServiceImpl();
		service.viewStudent(request, response);

	}
}
