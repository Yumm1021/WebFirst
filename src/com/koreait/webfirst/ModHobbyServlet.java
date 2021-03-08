package com.koreait.webfirst;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/modHobby")
public class ModHobbyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		System.out.println("i_hobby : " + i_hobby);
		
		HobbyEntity param = new HobbyEntity();
		param.setI_hobby(i_hobby);
		HobbyEntity data = DAO.selHobby(param);
		
		request.setAttribute("data", data);
		
		
		String jsp = "WEB-INF/jsp/modHobby.jsp";
		request.getRequestDispatcher(jsp).forward(request, response);
		
		// 자료를 가져와서 화면에 내용을 뿌려줄거야 (기존 내용)
		
		// 그 화면에서 수정
		
		// 수정 버튼 누름 . doPost 실행
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 수정처리 할거임
		int i_hobby = Integer.parseInt(request.getParameter("i_hobby"));
		System.out.println("i_hobby : " + i_hobby);
		
		String nm = request.getParameter("hobby");
		System.out.println("nm : " + nm);
		
		HobbyEntity param = new HobbyEntity();
		param.setI_hobby(i_hobby);
		param.setNm(nm);
		
		//TODO: 수정처리
		DAO.updHobby(param);
		
		response.sendRedirect("/hobby");
	}

}
