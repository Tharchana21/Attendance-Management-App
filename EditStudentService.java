package com.besant.services;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface EditStudentService {
	void editStudent(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException;

	void updateRecord(HttpServletRequest req, HttpServletResponse res);
}
