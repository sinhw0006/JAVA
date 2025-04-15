package Domain.Service;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Domain.Dao.UserDao;
import Domain.Dao.UserDaoImpl;
import Domain.Dao.ConnectionPool.ConnectionPool;
import Domain.Dto.UserDto;

public class UserServiceImpl {

	//
	private UserDao userDao;
	private ConnectionPool connectionPool; // TX

	// 싱글톤 패턴
	private static UserServiceImpl instance;

	private UserServiceImpl() throws Exception {
		userDao = UserDaoImpl.getInstance();
		connectionPool = ConnectionPool.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init...");
	};

	public static UserServiceImpl getInstance() throws Exception {
		if (instance == null)
			instance = new UserServiceImpl();
		return instance;
	}

	// 회원가입(+TX처리필요)
	public boolean userJoin(UserDto userDto) throws Exception {
		boolean isJoin = false;
		try {

			connectionPool.beginTransaction();

			isJoin = userDao.insert(userDto) > 0; // sql 질의 다수

			connectionPool.commitTransaction();

		} catch (SQLException e) {
			connectionPool.rollbackTransaction();
		}

		return isJoin;

	};

	// 회원조회

	// 회원정보수정

	// 회원탈퇴

	// 로그인
	public Map<String, Object> login(UserDto userDto, HttpSession session) throws Exception {
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		UserDto userDb = userDao.select(userDto.getUsername()); // sql 질의 다수

		if (userDb == null || !userDb.getPassword().equals(userDto.getPassword())) {
			resp.put("isLogin", false);
			resp.put("message", "아이디 혹은 비밀번호가 일치하지 않습니다..");
		} else {
			session.setAttribute("isAuth", true);
			session.setAttribute("role", userDb.getRole());
			session.setAttribute("username", userDb.getUsername());
			session.setMaxInactiveInterval(60 * 10);

			resp.put("isLogin", true);
			resp.put("message", "로그인 성공");
		}

		return resp;

	};

	// 로그아웃
	public Map<String, Object> logout(HttpSession session) throws Exception {
		Map<String, Object> resp = new LinkedHashMap<String, Object>();
		session.invalidate();
		resp.put("isLogout", true);
		resp.put("message", "로그아웃 성공");

		return resp;

	};
// UserService
// - logout함수 내 처리
// - session invalid 처리 하기
// - Map<String,Object> 로 return "isLogout",true , "message","로그아웃성공"

}
