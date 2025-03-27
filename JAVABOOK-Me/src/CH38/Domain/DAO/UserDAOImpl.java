package CH38.Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import CH38.Domain.DTO.UserDTO;

public class UserDAOImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// DB Info
	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookDB";

	// 싱글톤 패턴처리
	private static UserDAOImpl instace;

	private UserDAOImpl() throws SQLException, ClassNotFoundException {
		System.out.println("[DAO] UserDAOImpl init");
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB 연결 성공");
	}

	public static UserDAOImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instace == null)
			instace = new UserDAOImpl();
		return instace;
	}

	// CRUD
	public int insert(UserDTO userDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
			pstmt.setString(1, userDTO.getUserid());
			pstmt.setString(2, userDTO.getUsername());
			pstmt.setString(3, userDTO.getPassword());
			pstmt.setString(4, "ROLE_USER");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO : INSERT SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public int update(UserDTO userDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO : UPDATE SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public int delete(UserDTO userDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO : DELETE SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public UserDTO select(UserDTO userDTO) {
		return null;
	}

	public List<UserDTO> selectAll() {
		return null;
	}
}