package com.koreait.webfirst;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1") //WebServlet에 문자를 줬기 때문에 저 문자로 주소를 연결시켜 준다 주소 매핑 
public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //get 방식은 웬만하면 파일 여는 거
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/test1.jsp"); //"" 안에 만들어진 객체를 객체화하여 달라고 request에 요청
		rd.forward(request, response); //forward는 jsp 파일을 찾는다 > 물론 객체화가 되어 있는 jsp파일을 !! 주소값을 통해서 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // post 방식은 업무처리
		// TODO Auto-generated method stub
		System.out.println("ddd");
	}

}
