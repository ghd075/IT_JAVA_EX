package co.micol.couse;

import java.sql.*;
import java.util.*;

public class CourseDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "micol";
	private static final String PASS = "1234";
	
	//연결
	public CourseDAO() {
		try {
			Class.forName(DRIVER); //드라이버를 로드합니다.
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(URL, USER, PASS);
			System.out.println("오라클 연결 성공");
		}catch(ClassNotFoundException e) { //드라이버를 찾지 못하면
			System.out.println("jdbc driver 로딩 실패");
		}catch(SQLException e) {
			System.out.println("오라클 연결 실패");
		}
	}
	
	//삽입
	public int input(CourseDTO dto) {
		int n = 0;
		String sql = "insert into couse values(?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getDeptcode());
			psmt.setString(2, dto.getStudentid());
			psmt.setString(3, dto.getCourse());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//수정
	public int update(CourseDTO dto) {
		int n = 0;
		String sql = "update couse set course = ? " +
					 "where deptcode = ? and studentid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getCourse());
			psmt.setString(2, dto.getDeptcode());
			psmt.setString(3, dto.getStudentid());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//삭제
	public int delete(CourseDTO dto) {
		int n = 0;
		String sql = "delete from couse " +
					 "where deptcode = ? and studentid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getDeptcode());
			psmt.setString(2, dto.getStudentid());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return n;
	}
	
	//조회
	public void selectAll() {
		String sql = "select * from couse";
		CourseDTO dto = new CourseDTO();
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("<--조회결과-->");
			System.out.println("학과코드     학번        학과명");
			while(rs.next()) { //다음 레코드 실행을 위해
				System.out.print(rs.getString("deptcode")+"  ");
				System.out.print(rs.getString("studentid")+"  ");
				System.out.println(rs.getString("course"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("쿼리 결과 값이 없습니다.");
		}
	}
}
