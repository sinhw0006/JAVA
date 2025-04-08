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
	
	public int insertVote(VoteDTO voteDTO) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_vote_202005 Values(?,?,?,?,?,?)");
		pstmt.setString(1, voteDTO.getV_jumin());
		pstmt.setString(2, voteDTO.getV_name());
		pstmt.setString(3, voteDTO.getM_no());
		pstmt.setString(4, voteDTO.getV_time());
		pstmt.setString(5, voteDTO.getV_area());
		pstmt.setString(6, voteDTO.getV_confirm());
		int result =  pstmt.executeUpdate();
		pstmt.close();
		return result;
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
	public List<VoteDTO> selectAllVote() throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_vote_202005");
		rs = pstmt.executeQuery();
		List<VoteDTO> list = new ArrayList<VoteDTO>();
		while (rs.next()) {
			VoteDTO voteDTO = new VoteDTO();
			voteDTO.setV_jumin(rs.getString(1));
			voteDTO.setV_name(rs.getString(2));
			voteDTO.setM_no(rs.getString(3));
			voteDTO.setV_time(rs.getString(4));
			voteDTO.setV_area(rs.getString(5));
			voteDTO.setV_confirm(rs.getString(6));
			list.add(voteDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	public List<CountVoteDTO> CountVote() throws Exception {
		pstmt = conn.prepareStatement("select m_no,m_name,count(*) from tbl_member_202005 natural join tbl_vote_202005 where v_confirm = 'Y' group by m_no,m_name order by count(m_no) desc");
		rs = pstmt.executeQuery();
		List<CountVoteDTO> list = new ArrayList<CountVoteDTO>();
		while (rs.next()) {
			CountVoteDTO countVoteDTO = new CountVoteDTO();
			countVoteDTO.setM_no(rs.getString(1));
			countVoteDTO.setV_name(rs.getString(2));
			countVoteDTO.setCount(rs.getString(3));
			list.add(countVoteDTO);
		}
		rs.close();
		pstmt.close();
		return list;
	}
}