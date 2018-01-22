package io.github.oliviercailloux.y2018.web;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.core.MediaType;

import io.github.oliviercailloux.y2018.Cours;

@WebServlet("/course")
public class getCourseServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	//Temporary fake database
	@Inject
	private DatabaseManager DBM;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		
		resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
		resp.setContentType("application/json");
		resp.setLocale(Locale.ENGLISH);
		
		PrintWriter out = resp.getWriter();
		Cours targetCourse = DBM.getCoursesById().get(Integer.parseInt(id));
		out.print(targetCourse);
		out.flush();
	}
}