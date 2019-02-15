package co.micol.student.dao;

import java.sql.*;

/**
 * DAO 클래스
 *
 */

public class DAO {
	// JDBC에 사용되는 객체 선언
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

	// 드라이버, DB주소, DB계정명, 패스워드 선언 및 초기화
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "micol";
	private String pass = "1234";

	// 디비연결
	public DAO() {
		try {
			Class.forName(driver); // 드라이버를 로드합니다.
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, pass); // 오라클에 연결합니다.
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) { // 드라이버를 찾지 못하면
			System.out.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
	}

	// 조회
	public ResultSet Select(String sql) {
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("조회 실패");
			e.printStackTrace();
		}
		return rs;
	}
	
	//삽입
	public int insert(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("삽입 실패!!!");
			e.printStackTrace();
		}
		return n;
	}
	
	//삭제
	public int delete(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("삭제 실패!!!");
			e.printStackTrace();
		}
		return n;
	}
	
	//수정
	public int update(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("수정 실패!!!");
		}
		return n;
	}

}
