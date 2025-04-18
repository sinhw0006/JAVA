package Domain.Dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

import Domain.Dto.BookReplyDto;

public class BookReplyDaoImpl extends Dao {

	// 싱글톤 패턴처리
	private static BookReplyDaoImpl instance;

	private BookReplyDaoImpl() throws Exception {
		System.out.println("[DAO] BookReplyDaoImpl init...");
	};

	public static BookReplyDaoImpl getInstance() throws Exception {
		if (instance == null)
			instance = new BookReplyDaoImpl();
		return instance;
	}

	public int insert(BookReplyDto replyDto) throws Exception {
		try {

			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("insert into reply_tbl(bookCode,username,context,createAt) values(?,?,?,?)");
			pstmt.setString(1, replyDto.getBookCode());
			pstmt.setString(2, replyDto.getUsername());
			pstmt.setString(3, replyDto.getContents());
			pstmt.setTimestamp(4, Timestamp.valueOf(replyDto.getCreateAt()));

			return pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
			// Connection release
			connectionPool.releaseConnection(connectionItem);

		}
	}

	public List<BookReplyDto> selectAll(String bookCode) throws Exception {
		List<BookReplyDto> list = new LinkedList<>();
		try {

			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("select * from reply_tbl where bookCode = ? order by no desc");
			pstmt.setString(1, bookCode);
			rs = pstmt.executeQuery();
			BookReplyDto dto = null;
			while (rs.next()) {
				dto = new BookReplyDto();
				dto.setNo(rs.getInt(1));
				dto.setBookCode(rs.getString(2));
				dto.setUsername(rs.getString(3));
				dto.setContents(rs.getString(4));
				dto.setCreateAt(rs.getTimestamp(5).toLocalDateTime());
				list.add(dto);
			}
			return list;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
			}
			// Connection release
			connectionPool.releaseConnection(connectionItem);

		}
	}

	public long bookReplyCount(String bookCode) throws Exception{
		try {

			connectionItem = connectionPool.getConnection();
			Connection conn = connectionItem.getConn();

			pstmt = conn.prepareStatement("select count(*) from reply_tbl where bookCode = ?");
			pstmt.setString(1,bookCode);
			
			rs = pstmt.executeQuery();

			rs.next();
			
			return rs.getLong(1);

		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("USERDAO's INSERT SQL EXCEPTION!!");
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (Exception e2) {
			}
			// Connection release
			connectionPool.releaseConnection(connectionItem);

		}
	}

}
