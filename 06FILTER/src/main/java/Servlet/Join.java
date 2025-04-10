package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.UserDTO;
import Utils.MysqlDbUtils;

@WebServlet("/join.do")
public class Join extends HttpServlet{

	//GET - 	/join.do - /WEB-INF/user/join.jsp 연결
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
	}
	
	//POST - /join.do - 회원가입처리(username,password 받아 DBUtils를 이용한 DB INSERT)
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String userid = req.getParameter("userid");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		UserDTO userDTO = new UserDTO(userid, username, password, "ROLE_USER");
		
		System.out.println("POST /join.do userid : "+ userid);
		System.out.println("POST /join.do username : "+ username);
		
		Boolean success = false;
		try {
			success = MysqlDbUtils.getInstance().userInsert(userDTO) > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		//성공시 - /login.do 로 리다이렉트
		if(success) {
			resp.sendRedirect("./login.do");
			return;
		}
		//실패시 - /join.do 로 포워딩
		req.getRequestDispatcher("/WEB-INF/user/join.jsp").forward(req, resp);
	}
	
	
	
	
}
