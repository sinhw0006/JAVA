package C09;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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

	public int insertUser(UserDto userDto) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_user values(?,?,'ROLE_USER',?)");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getAddr());
		int result = pstmt.executeUpdate();

		conn.commit();
		pstmt.close();
		return result;
	}

	public int updateUser(UserDto userDto, String userid) throws Exception {
		pstmt = conn.prepareStatement("update tbl_user set userid=?,password=?,role=?,addr=? where userid = ?");
		pstmt.setString(1, userDto.getUserid());
		pstmt.setString(2, userDto.getPassword());
		pstmt.setString(3, userDto.getRole());
		pstmt.setString(4, userDto.getAddr());
		pstmt.setString(5, userid);
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
		int result = rs.getInt("Count");
		rs.close();
		pstmt.close();
		return result;
	}

	public List<UserDto> selectAllUser(int pageNum) throws Exception {
		pstmt = conn.prepareStatement(
				"select * from (select ROWNUM as num, t.* from tbl_user t) where num BETWEEN ? And ?");
		pstmt.setInt(1, (pageNum - 1) * 10 + 1);
		pstmt.setInt(2, pageNum * 10);
		rs = pstmt.executeQuery();
		List<UserDto> userDtos = new ArrayList();
		while (rs.next()) {
			UserDto userDto = new UserDto(rs.getString("userid"), rs.getString("addr"), rs.getString("password"),
					rs.getString("role"));
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
		UserDto userDto = new UserDto(rs.getString("userid"), rs.getString("addr"), rs.getString("password"),
				rs.getString("role"));
		rs.close();
		pstmt.close();
		return userDto;
	}
	// ORDER

	public List<OrderDto> selectAllOrder() throws Exception {

		String sql = "select category,sum(price*quantity) from tbl_order" + " group by category"
				+ " having sum(price*quantity) >=50000" + " order by sum(price*quantity) DESC";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDto> orderDtos = new ArrayList();
		while (rs.next()) {
			OrderDto orderDto = new OrderDto(rs.getString(1), rs.getInt(2));
			orderDtos.add(orderDto);
		}
		rs.close();
		pstmt.close();
		return orderDtos;
	}

	public List<OrderDto2> selectAllOrder2() throws Exception {

		String sql = "select order_date,round(avg(price*quantity),2) from tbl_order" + " group by order_date";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDto2> orderDtos = new ArrayList();
		while (rs.next()) {
			OrderDto2 orderDto = new OrderDto2(rs.getDate(1).toLocalDate(), rs.getInt(2));
			orderDtos.add(orderDto);
		}
		rs.close();
		pstmt.close();
		return orderDtos;
	}

	public List<OrderDto3> selectAllOrder3() throws Exception {

		String sql = "select addr, order_date, sum(price*quantity)"
				+ " from tbl_user u join tbl_order o on u.userid = o.userid"
				+ " group by addr, order_date"
				+ " order by sum(price * quantity) desc";

		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		List<OrderDto3> orderDtos = new ArrayList();
		while (rs.next()) {
			OrderDto3 orderDto = new OrderDto3(rs.getString(1),rs.getDate(2).toLocalDate(),rs.getInt(3));
			orderDtos.add(orderDto);
		}
		rs.close();
		pstmt.close();
		return orderDtos;
	}

}