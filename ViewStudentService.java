package com.besant.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ViewStudentService  {

	public void viewStudent (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;
}
