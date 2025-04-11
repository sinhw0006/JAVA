package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DTO.UserDTO;
import Utils.MysqlDbUtils;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	// GET - /login.do - /WEB-INF/user/login.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
	}

	// POST - /login.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		try {
			//실패시 : /login.do로 포워딩
			UserDTO userDTO = MysqlDbUtils.getInstance().UserCheck(userid);
			if(userDTO == null || !userDTO.getUserpassword().equals(password)) {
				req.setAttribute("message", "아이디 혹은 비밀번호가 틀렸습니다.");
				req.getRequestDispatcher("/WEB-INF/user/login.jsp").forward(req, resp);
				return;
			}
			HttpSession session = req.getSession();
			session.setAttribute("userid", userDTO.getUserid());
			session.setAttribute("username", userDTO.getUsername());
			session.setAttribute("role", userDTO.getUserrole());
			resp.sendRedirect("./login.do");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// 성공시 : /main.do 로 리다이렉트

}