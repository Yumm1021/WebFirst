package com.koreait.webfirst;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delHobby")
public class DelHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		
		System.out.println("i_hobby : " + i_hobby);
		
		HobbyEntity param = new HobbyEntity(); // 사용하려고 객체화 함
		param.setI_hobby(i_hobby);
		DAO.delHobby(param); // DAO는 데이터베이스와 직관적으로 하는 일 , servlet과는 별개
		
		//TODO: 삭제처리
		
		response.sendRedirect("/hobby"); // hobby로 주소값 호출 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
