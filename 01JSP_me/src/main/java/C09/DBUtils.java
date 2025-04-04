package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import C04.UserDto;

public class DBUtils {

	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String id = "system";
	private String pw = "1234";

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private static DBUtils instance;

	private DBUtils() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(url, id, pw);

	}

	public static DBUtils getInstance() throws Exception {
		if (instance == null) {
			instance = new DBUtils();
		}
		return instance;
	}

	public int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,'ROLE_USER')");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		int result = pstmt.executeUpdate();

		conn.commit();
		pstmt.close();
		return result;
	}
	
	public int updateUser(UserDto userDto, String userid) throws Exception {
		pstmt = conn.prepareStatement("update tbl_user set userid=?,password=?,role=? where userid = ?");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		pstmt.setString(4, userid);
		int result = pstmt.executeUpdate();

		conn.commit();
		pstmt.close();
		return result;
	}
	
	public int deleteUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_user where userid = ?");
		pstmt.setString(1, userid);
		int result = pstmt.executeUpdate();

		conn.commit();
		pstmt.close();
		return result;
	}
	
	public int userCount() throws Exception {
		pstmt = conn.prepareStatement("select count(*) as Count from tbl_user");
		rs = pstmt.executeQuery();
		rs.next();
		int result = rs.getInt("Count")+1;
		System.out.println(result);
		rs.close();
		pstmt.close();
		return result;
	}

	public List<UserDto> selectAllUser(int pageNum) throws Exception {
		pstmt = conn.prepareStatement("select * from (select ROWNUM as num, t.* from tbl_user t) where num BETWEEN ? And ?");
		pstmt.setInt(1, (pageNum-1)*10);
		pstmt.setInt(2, pageNum*10);
		rs = pstmt.executeQuery();
		List<UserDto> userDtos = new ArrayList();
		while (rs.next()) {
			UserDto userDto = new UserDto(rs.getString("userid"), rs.getString("password"), rs.getString("role"));
			userDtos.add(userDto);
		}
		rs.close();
		pstmt.close();
		return userDtos;
	}

	public UserDto selectUser(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid = ?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		rs.next();
		UserDto userDto = new UserDto(rs.getString("userid"), rs.getString("password"), rs.getString("role"));
		rs.close();
		pstmt.close();
		return userDto;
	}
}