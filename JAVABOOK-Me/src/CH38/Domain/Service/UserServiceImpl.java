package CH38.Domain.Service;

import java.sql.SQLException;

import CH38.Domain.DAO.UserDAOImpl;
import CH38.Domain.DTO.UserDTO;

public class UserServiceImpl {

	private UserDAOImpl userDAO;

	private static UserServiceImpl instance;

	private UserServiceImpl() throws ClassNotFoundException, SQLException {
		userDAO = UserDAOImpl.getInstance();
		System.out.println("[SERVICE] UserServiceImpl init");
	}

	public static UserServiceImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instance == null) {
			instance = new UserServiceImpl();
		}
		return instance;
	}
	
	//회원가입(+TX처리필요)
	public boolean userJoin(UserDTO userDTO) throws SQLException{
		return userDAO.insert(userDTO) > 0;
	};
	//회원조회
	
	//회원정보수정
	
	//회원탈퇴
	
	//로그인
	
	//로그아웃

}
