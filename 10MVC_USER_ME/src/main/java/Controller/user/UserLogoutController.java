package Controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Controller.SubController;
import Domain.Dto.UserDto;
import Domain.Service.UserServiceImpl;

//FrontController -> UserLogoutController 등록 (URI : /user/logout)
	// UserLogoutController
	

public class UserLogoutController implements SubController {

	private HttpServletRequest req;
	private HttpServletResponse resp;

	private UserServiceImpl userService;

	public UserLogoutController() throws Exception{
		userService = UserServiceImpl.getInstance();
	}

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
		System.out.println("[SC] UserLogoutController execute..");
		
		//  - 1 파라미터받기 생략 
		
		//	- 2 session 안 속성 정보(isAuth , role , username) 꺼내오고 유효성 체크\
		try {
			HttpSession session = req.getSession();
			
			boolean isAuth = isValid(session);
			//  - isAuth == false 라면 포워딩 /WEB-INF/login.jsp   session에 message 속성 추가 "로그인상태가 아닙니다"
			if (!isAuth) {
				req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
				return;
			}
			
			Map<String, Object> servicereq = userService.logout(session);
			//	- isLogout 정보를 확인하여 로그아웃 성공/실패 둘다  /login.do
			req.setAttribute("message", servicereq.get("message"));
			req.getRequestDispatcher("/WEB-INF/view/user/login.jsp").forward(req, resp);
			//  - message는 session 에 저장
		} catch (Exception e) {
			exceptionHandler(e);
		}
		
	}
	
	private boolean isValid(HttpSession session) {
		if (session.getAttribute("role") == null || session.getAttribute("username") == null) {
			req.setAttribute("message", "로그인 상태가 아닙니다.");
			return false;
		}
		// NULL 체크 / 데이터(자료)수준에서의 의미있는데이터가 포함되어져있는지 여부

		return true;
	}
	
	// 예외처리함수
		public void exceptionHandler(Exception e) {
			req.setAttribute("status", false);
			req.setAttribute("message", e.getMessage());
			req.setAttribute("exception", e);
		}
}
