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

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	

			
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("test01", "1234", "김테스트"));
		memberList.add(new Member("test02", "5678", "최테스트"));
		memberList.add(new Member("test03", "qwer", "박테스트"));
		// 멤버리스트에 셋 추가
		
		//-----------------------------------------------------------
		
		/*
		 * String inputId = req.getParameter("inputId"); // 추가 int index =
		 * memberList.indexOf(inputId); // 추가
		 */		
		String memberId = req.getParameter("memberId");
		String memberPw = req.getParameter("memberPw");
		String memberName = req.getParameter("memberName");
		
		// 존재하는 경우 
		for(Member member : memberList) {
			if(member.getMemberId().equals(memberId)) {
			
				HttpSession session = req.getSession();
				session.setAttribute("message", memberId + "은/는 이미 존재하는 아이디 입니다.");
				resp.sendRedirect("/");
				return ;
			}
			
			
		}
		
		// 존재하지 않는 경우 forward (가입시켜줌)
		Member member = new Member(memberId, memberPw, memberName);
		memberList.add(member);
		String message = String.format("%s/%s 님이 가입 되었습니다 (비밀번호 : %s)" ,
										memberId, memberName, memberPw);
		req.setAttribute("message", message);
		String path = "/WEB-INF/views/success.jsp"; // 주소 수정
		req.getRequestDispatcher(path).forward(req, resp);
	

	}
	
	/*
	 * 2. 입력 받은 아이디가 List에 있다면 "/" 로 redirect 수행. redirect 시
	 * "(아이디)은/는 이미 존재하는 아이디 입니다." 메시지도 전달하여 응답 화면에서 출력
	 * 
	 * * 1. 입력 받은 아이디가 List에 없다면 List에 추가 후 "/WEB-INF/views/success.jsp"로 forward
	 * 수행. forward 시 "(아이디)/(이름) 님이 가입 되었습니다 (비밀번호 : OOOO)" 메시지도 전달하여 응답 화면에서 출력
	 *
	 * redirect 부터 
	 * 
	 * 존재 o redirect
	 * 존재 x forward
	 *     - 이름을 하나 입력 받아 "/search", POST 방식으로 요청
	 *     
	 *     둘이 바꿔줘야됨

    - Servlet에 존재하는 이름이 모인 List에서
      입력받은 이름과 같은 이름이 있는지 확인

    - 존재하는 경우
      -> "OOO님은 X번째 인덱스에 존재 합니다" 
          문자열을 request scope 객체에 세팅.

          /WEB-INF/views/result.jsp 로 요청 위임해 결과 출력
          (forward)

    - 존재하지 않은 경우
      -> "OOO님은 존재하지 않습니다"
          문자열을 session scope에 세팅 후
          "/" (메인페이지 == index.jsp)로 재요청하여 출력
        (redirect)
	 */
}