package Domain.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Domain.Dao.ConnectionPool.ConnectionItem;
import Domain.Dao.ConnectionPool.ConnectionPool;
import Domain.Dto.BookDto;
import Domain.Dto.UserDto;

public class BookDaoImpl implements BookDao {
	//DB Attr
//	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
//	private String id="root";
//	private String pw="1234";
//	private String url="jdbc:mysql://localhost:3306/bookDB";
	
	private ConnectionPool connectionPool;
	private ConnectionItem connectionItem;
	
	
	//싱글톤
	
	private static BookDao instance;
	private BookDaoImpl() throws ClassNotFoundException, SQLException {
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		conn = DriverManager.getConnection(url,id,pw);
		connectionPool = ConnectionPool.getInstance();
		System.out.println("UserDaoImpl DB Connection Success");
		
	};
	public static BookDao getInstance() throws ClassNotFoundException, SQLException {
		if(instance==null)
			instance=new BookDaoImpl();
		return instance;
	}
	
	//CRUD 
	 
	@Override
	public int insert(BookDto bookDto) throws Exception {
		try {
			//connection  get
			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();
			
			pstmt = conn.prepareStatement("insert into book_tbl values(?,?,?,?)");
			pstmt.setString(1, bookDto.getBookCode());
			pstmt.setString(2, bookDto.getBookName());
			pstmt.setString(3, bookDto.getPublisher());
			pstmt.setString(4, bookDto.getIsbn());
			
			//connection release
			connectionPool.releaseConnection(connectionItem);
			
			return pstmt.executeUpdate();
			
		}catch(SQLException e) {
			return 0;
		}finally {
			try {pstmt.close();}catch(Exception e2) {}
		}
	}
	
 
	@Override
	public int update(UserDto userDto) throws SQLException {
		return 0;
	}
 
	@Override
	public int delete(UserDto userDto) throws SQLException {
		return 0;
	}
	//단건조회
 
	@Override
	public UserDto select(UserDto userDto) {	
		return null;
	}
	//다건조회
 
	@Override
	public List<UserDto> selectAll() {	
		return null;
	}
	
	public int bookCount(String input) throws Exception {
		
		connectionItem = connectionPool.getConnection();
		Connection conn = connectionItem.getConn();
		
		pstmt = conn.prepareStatement("select count(*) as Count from book_tbl where bookName like ?");
		pstmt.setString(1, "%"+input+"%");
		rs = pstmt.executeQuery();
		rs.next();
		int result = rs.getInt("Count");
		

		connectionPool.releaseConnection(connectionItem);
		
		rs.close();
		pstmt.close();
		
		
		return result;
	}

	public List<BookDto> selectAllBookPage(int pageNum, String sortBy, String orderBy, String input) throws Exception {
		
		connectionItem = connectionPool.getConnection();
		Connection conn = connectionItem.getConn();
		
		pstmt = conn.prepareStatement(
				"SELECT ROW_NUMBER() OVER (ORDER BY "
				+ sortBy
				+ " " + orderBy
				+ ") AS num, t.* FROM book_tbl t where bookName like ? limit ?,10");
		pstmt.setString(1, "%"+input+"%");
		pstmt.setInt(2, (pageNum - 1) * 10);
		rs = pstmt.executeQuery();
		List<BookDto> bookDtos = new ArrayList();
		while (rs.next()) {
			BookDto bookDto = new BookDto(rs.getString(2), rs.getString(3), rs.getString(4),
					rs.getString(5));
			bookDtos.add(bookDto);
		}
		

		connectionPool.releaseConnection(connectionItem);
		
		rs.close();
		pstmt.close();
		
		
		return bookDtos;
	}
}




