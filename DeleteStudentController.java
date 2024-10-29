package com.besant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.besant.services.impl.DeleteStudentServiceImpl;

@WebServlet("/delete")
public class DeleteStudentController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DeleteStudentServiceImpl service = new DeleteStudentServiceImpl();
		service.deleteStudentRecord(request, response);
	}
}
