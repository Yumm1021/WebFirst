package com.koreait.webfirst;

import java.util.List;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hobby")
public class HobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<HobbyEntity> list = DAO.selHobbyList(); 
		request.setAttribute("list", list);
		request.setAttribute("endIdx", 10);
		
		HttpSession hs = request.getSession();
		hs.setAttribute("loginUser", "");
		
		String jsp ="/WEB-INF/jsp/hobby.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
		
		String hobby = request.getParameter("hobby");
		System.out.println("hobby : " + hobby);
		
		
		HobbyEntity param = new HobbyEntity();
		param.setNm(hobby);
		int result = DAO.insHobby(param); 
		
		
		response.sendRedirect("/hobby");
	}

}
