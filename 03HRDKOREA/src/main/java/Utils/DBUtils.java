package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<teacherDTO> teacherAllSelect() throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_teacher_202201");
		rs = pstmt.executeQuery();
		List<teacherDTO> list = new ArrayList();
		while(rs.next()) {
			teacherDTO teacherDTO = new teacherDTO();
			teacherDTO.setTeacher_code(rs.getString(1));
			teacherDTO.setTeacher_name(rs.getString(2));
			teacherDTO.setClass_name(rs.getString(3));
			teacherDTO.setClass_price(rs.getInt(4));
			teacherDTO.setTeacher_regist_date(rs.getString(5));
			list.add(teacherDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<memberDTO> memberAllSelect() throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_member_202201");
		rs = pstmt.executeQuery();
		List<memberDTO> list = new ArrayList();
		while(rs.next()) {
			memberDTO memberDTO = new memberDTO();
			memberDTO.setC_no(rs.getString(1));
			memberDTO.setC_name(rs.getString(2));
			memberDTO.setPhone(rs.getString(3));
			memberDTO.setAddress(rs.getString(4));
			memberDTO.setGrade(rs.getString(5));
			list.add(memberDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<memberDTO> memberOneSelect() throws Exception{
		pstmt = conn.prepareStatement("select * from tbl_member_202201 where");
		rs = pstmt.executeQuery();
		List<memberDTO> list = new ArrayList();
		while(rs.next()) {
			memberDTO memberDTO = new memberDTO();
			memberDTO.setC_no(rs.getString(1));
			memberDTO.setC_name(rs.getString(2));
			memberDTO.setPhone(rs.getString(3));
			memberDTO.setAddress(rs.getString(4));
			memberDTO.setGrade(rs.getString(5));
			list.add(memberDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
}