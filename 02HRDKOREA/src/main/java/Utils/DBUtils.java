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

	public List<MemberDTO> selectAllMember() throws Exception {
		pstmt = conn.prepareStatement("select m_no,m_name,p_name,p_school,m_jumin,m_city,p_tel1,p_tel2,p_tel3"
				+ " from tbl_member_202005" + " natural join tbl_party_202005");
		rs = pstmt.executeQuery();
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		while (rs.next()) {
			MemberDTO memberDTO = new MemberDTO();
			memberDTO.setM_no(rs.getString("m_no"));
			memberDTO.setM_name(rs.getString("m_name"));
			memberDTO.setP_name(rs.getString("p_name"));
			String school = "";
			switch (Integer.parseInt(rs.getString("p_school"))) {
			case 1:
				school = "고졸";
				break;
			case 2:
				school = "학사";
				break;
			case 3:
				school = "석사";
				break;
			case 4:
				school = "박사";
				break;
			}
			memberDTO.setP_school(school);
			memberDTO.setM_jumin(rs.getString("m_jumin"));
			memberDTO.setM_city(rs.getString("m_city"));
			memberDTO.setP_tel1(rs.getString("p_tel1"));
			memberDTO.setP_tel2(rs.getString("p_tel2"));
			memberDTO.setP_tel3(rs.getString("p_tel3"));
			list.add(memberDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
}