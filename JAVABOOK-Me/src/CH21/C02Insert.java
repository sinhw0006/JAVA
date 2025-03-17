package CH21;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class C02Insert {

	public static void main(String[] args) {
		//DB CONN DATA
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/testdb";
		
		//JDBC참조변수
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//
		try {
			
			// DRIVER 메모리 적재 
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success...");
			// CONNECTION 
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB CONNECTED...");

			// SQL 쿼리 준비(!)
			String name =args[0];
			int age = Integer.parseInt(args[1]);
			String addr = args[2];
			//pstmt=conn.prepareStatement("insert into tbl_std values(?,?,?)");
//			pstmt.setString(1, name);
//			pstmt.setInt(2,age);
//			pstmt.setString(3, addr);
			
			pstmt=conn.prepareStatement("insert into tbl_std values('"+name+"',"+age+",'"+addr+"')");
			
			
			// SQL 실행
			int result =  pstmt.executeUpdate();
			
			if(result>0)
				System.out.println("INSERT 성공");
			else
				System.out.println("INSERT 실패");
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {	
			try { conn.close();} catch (SQLException e) {e.printStackTrace(); }
		}
	}

}
