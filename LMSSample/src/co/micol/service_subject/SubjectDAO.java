package co.micol.service_subject;

import java.sql.*;
import co.micol.dao.*;

public class SubjectDAO extends DaoConn {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public ResultSet select(String sql) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("입력 실패!!!");
		}
		return n;
	}

	@Override
	public int update(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("수정 실패!!!");
		}
		return n;
	}

	@Override
	public int delect(String sql) {
		int n = 0;
		try {
			psmt = conn.prepareStatement(sql);
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("삭제 실패!!!");
		}
		return n;
	}

	@Override
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void selectAll() {
		String sql = "select * from s_subjec order by s_code";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("과목코드 \t과목명");
			while(rs.next()) {
				System.out.print(rs.getString("s_code")+"  ");
				System.out.println(rs.getString("s_name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
			System.out.println("조회 실패!!!");
		}
	}

}
