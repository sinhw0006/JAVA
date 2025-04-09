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
	
	public int classinsert(classDTO classDTO, String class_name) throws Exception{
		String sql = "insert into tbl_class_202201"
				+ " values(?,?,?,?,"
				+ "(select teacher_code from tbl_teacher_202201 where class_name = ?))";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,classDTO.getRegist_month());
		pstmt.setString(2,classDTO.getC_no());
		pstmt.setString(3,classDTO.getClass_area());
		pstmt.setInt(4,classDTO.getTuition());
		pstmt.setString(5,class_name);
		int result = pstmt.executeUpdate();
		pstmt.close();
		return result;
	}
	
	public List<memberinfoDTO> memberInfoSelect() throws Exception{
		String sql = "select regist_month,c_no,c_name,class_name,class_area,tuition,grade"
				+ " from tbl_member_202201"
				+ " natural join ("
				+ "select regist_month,c_no,class_area,tuition,class_name"
				+ " from tbl_class_202201 natural join tbl_teacher_202201)";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<memberinfoDTO> list = new ArrayList();
		while(rs.next()) {
			memberinfoDTO memberinfoDTO = new memberinfoDTO();
			memberinfoDTO.setRegist_month(rs.getString(1));
			memberinfoDTO.setC_no(rs.getString(2));
			memberinfoDTO.setC_name(rs.getString(3));
			memberinfoDTO.setClass_name(rs.getString(4));
			memberinfoDTO.setClass_area(rs.getString(5));
			memberinfoDTO.setTuition(rs.getInt(6));
			memberinfoDTO.setGrade(rs.getString(7));
			list.add(memberinfoDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<teacherInfoDTO> teacherInfoSelect() throws Exception{
		String sql = "SELECT teacher_code,class_name,teacher_name,SUM(tuition)"
				+ " FROM tbl_class_202201"
				+ " NATURAL JOIN tbl_teacher_202201"
				+ " GROUP BY teacher_code, class_name, teacher_name"
				+ " ORDER BY teacher_code";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<teacherInfoDTO> list = new ArrayList();
		while(rs.next()) {
			teacherInfoDTO teacherInfoDTO = new teacherInfoDTO();
			teacherInfoDTO.setTeacher_code(rs.getString(1));
			teacherInfoDTO.setClass_name(rs.getString(2));
			teacherInfoDTO.setTeacher_name(rs.getString(3));
			teacherInfoDTO.setSum(rs.getInt(4));
			list.add(teacherInfoDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
}