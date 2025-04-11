package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import DTO.UserDTO;

public class MysqlDbUtils {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;	
	
	private DataSource dataSource;
	
	//싱글톤 
	private static MysqlDbUtils instance;
	private MysqlDbUtils() throws Exception {
		Context initContext = new InitialContext();
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		dataSource = (DataSource)envContext.lookup("jdbc/MyDB");
		conn = dataSource.getConnection();
		System.out.println("Connection : "+ conn);
	}
	public static MysqlDbUtils getInstance() throws Exception {
		if(instance==null)
			instance = new MysqlDbUtils();
		return instance;
	}
	
	public int userInsert(UserDTO userDTO) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,?,?)");
		pstmt.setString(1, userDTO.getUserid());
		pstmt.setString(2, userDTO.getUsername());
		pstmt.setString(3, userDTO.getUserpassword());
		pstmt.setString(4, userDTO.getUserrole());
		
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	public UserDTO UserCheck(String userid) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_user where userid = ?");
		pstmt.setString(1, userid);
		rs = pstmt.executeQuery();
		UserDTO userDTO = null;
		if(rs.isBeforeFirst()) {
			rs.next();
			userDTO = new UserDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));			
		}
		rs.close();
		pstmt.close();
		return userDTO;
	}
}







