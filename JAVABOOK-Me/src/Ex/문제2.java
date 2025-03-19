package Ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class 문제2 {
	private static String id = "root";
	private static String pw = "1234";
	private static String url = "jdbc:mysql://localhost:3306/tmpdb";

	private static Connection conn;
	private static PreparedStatement pstmt;
	private static ResultSet rs;

	public static void freeConnection(PreparedStatement pstmt) throws Exception {
		pstmt.close();
	}

	public static void freeConnection(PreparedStatement pstmt, ResultSet rs) throws Exception {
		pstmt.close();
		rs.close();
	}

	public static void conn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(url, id, pw);
		System.out.println("DB연결 성공");
	}

	public static List<BookDTO> selectAll() throws Exception {
		List<BookDTO> dtos = new ArrayList<BookDTO>();
		pstmt = conn.prepareStatement("select * from tbl_book");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			BookDTO dto = new BookDTO(rs.getLong("bookCode"), rs.getString("bookName"), rs.getString("publisher"),
					rs.getString("isbn"));
			dtos.add(dto);
		}
		freeConnection(pstmt, rs);
		return dtos;
	}

	public static BookDTO select(Long bookCode) throws Exception {
		pstmt = conn.prepareStatement("select * from tbl_book where bookCode = ?");
		pstmt.setLong(1, bookCode);
		rs = pstmt.executeQuery();
		rs.next();
		BookDTO dto = new BookDTO(rs.getLong("bookCode"), rs.getString("bookName"), rs.getString("publisher"),
				rs.getString("isbn"));
		freeConnection(pstmt, rs);
		return dto;
	}

	public static int insertBook(BookDTO bookDTO) throws Exception {
		pstmt = conn.prepareStatement("insert into tbl_book(bookCode,bookName,publisher,isbn) Values(?,?,?,?)");
		pstmt.setLong(1, bookDTO.getBookCode());
		pstmt.setString(2, bookDTO.getBookName());
		pstmt.setString(3, bookDTO.getPublisher());
		pstmt.setString(4, bookDTO.getIsbn());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result;
	}

	public static int updateBook(BookDTO bookDTO) throws Exception {
		pstmt = conn.prepareStatement("update tbl_book set bookName = ?, publisher = ?, isbn = ? where bookCode = ?");
		pstmt.setString(1, bookDTO.getBookName());
		pstmt.setString(2, bookDTO.getPublisher());
		pstmt.setString(3, bookDTO.getIsbn());
		pstmt.setLong(4, bookDTO.getBookCode());
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result;
	}

	public static int deleteBook(Long bookCode) throws Exception {
		pstmt = conn.prepareStatement("delete from tbl_book where bookCode = ?");
		pstmt.setLong(1, bookCode);
		int result = pstmt.executeUpdate();
		freeConnection(pstmt);
		return result;
	}

	public static void main(String[] args) throws SQLException {
		try {
			conn();

			conn.setAutoCommit(false);

			insertBook(new BookDTO(1L, "도서명1", "출판사명1", "isbn-1"));
			insertBook(new BookDTO(2L, "도서명2", "출판사명2", "isbn-2"));
			insertBook(new BookDTO(3L, "도서명3", "출판사명3", "isbn-3"));

			List<BookDTO> allBook = selectAll();
			System.out.println("selectAll : ");
			allBook.forEach(el -> System.out.println(el));

			BookDTO dto = select(1L);
			System.out.println("select : " + dto);

			dto.setBookName("수정도서명-2");
			dto.setPublisher("수정출판사명-2");
			int r1 = updateBook(dto);
			if (r1 > 0)
				System.out.println("수정완료 : " + r1);

			int r2 = deleteBook(2L);
			if (r2 > 0)
				System.out.println("삭제완료 : " + r2);
			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			try {
				conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
