package CH38.Domain.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import CH38.Domain.DTO.BookDTO;

public class BookDAOImpl {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	// DB Info
	private String id = "root";
	private String pw = "1234";
	private String url = "jdbc:mysql://localhost:3306/bookDB";

	// 싱글톤 패턴처리
	private static BookDAOImpl instace;

	private BookDAOImpl() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB 연결 성공");
	}

	public static BookDAOImpl getInstance() throws ClassNotFoundException, SQLException {
		if (instace == null)
			instace = new BookDAOImpl();
		return instace;
	}

	// CRUD
	public int insert(BookDTO BookDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("insert into tbl_book values(?,?,?,?)");
			pstmt.setString(1, BookDTO.getBookCode());
			pstmt.setString(2, BookDTO.getBookName());
			pstmt.setString(3, BookDTO.getPublisher());
			pstmt.setString(4, BookDTO.getIsbn());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO : INSERT SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public int update(BookDTO BookDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO : UPDATE SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public int delete(BookDTO BookDTO) throws SQLException {
		try {
			pstmt = conn.prepareStatement("");
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("BookDAO : DELETE SQL EXCEPTION");
		} finally {
			try {pstmt.close();} catch (Exception e2) {}
		}
	}

	public BookDTO select(BookDTO BookDTO) {
		return null;
	}

	public List<BookDTO> selectAll() {
		return null;
	}
}