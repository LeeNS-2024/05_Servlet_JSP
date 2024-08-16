package edu.kh.test.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import edu.kh.test.model.dto.Member;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/join") // 랩 싸서 join 넣어줌 (수정 1)
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// doGet -> doPost Post방식이 보안에 더 뛰어나고 index.jsp에서 온 method 방식이 post방식이었음(수정 2)
		String inputId = req.getParameter("memberId"); // inputId -> memberId (수정)
		String inputPw = req.getParameter("memberPw"); // inputPw -> memberPw
		
		if (inputId.equals("user01") && inputPw.equals("pass01")) { // forward 방식
			req.setAttribute("message", "user01 로그인 성공!"); // message
			String path = "/WEB-INF/views/result.jsp";
			req.getRequestDispatcher(path).forward(req, resp); // result 파일로 넘겨주는 코드 추가(수정 3) ??
			
		} else { // redirect 방식
			HttpSession session = req.getSession(); // session을 넣어줬음 (수정)
			session.setAttribute("message","아이디 또는 비밀번호가 일치하지 않습니다"); //(수정)4
			resp.sendRedirect("/");
			return;

			
			
			// 성공 시 "/WEB-INF/views/result.jsp"로 forward 방식 수행 "user01 로그인 성공!" 출력
			// 불일치 시 "/"로 redirect 방식으로 수행 "아이디 또는 비밀번호가 일치하지 않습니다" 출력
		}

	}
}