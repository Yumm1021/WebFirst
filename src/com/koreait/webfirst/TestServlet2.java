package com.koreait.webfirst;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		String jsp = "/WEB-INF/jsp/test2.jsp";
//		request.getRequestDispatcher(jsp).forward(request, response); // get 방식은 파일 여는 것 

		String msg = request.getParameter("msg");
		System.out.println("msg : " + msg);
		RequestDispatcher rd2 = request.getRequestDispatcher("/WEB-INF/jsp/test2.jsp");
		rd2.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("돼지"); // get방식과 post방식은 호출되는 메서드가 달라서임

		String msg = request.getParameter("msg");
		String title = request.getParameter("title");
		String ctnt = request.getParameter("ctnt");

		System.out.println("msg: " + msg);
		System.out.println("title : " + title);
		System.out.println("ctnt : " + ctnt);

		response.sendRedirect("/test1");

	}

}
