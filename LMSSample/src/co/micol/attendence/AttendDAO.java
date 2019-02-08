package co.micol.attendence;

import java.sql.*;

public class AttendDAO extends DAO {

	private PreparedStatement psmt;
	private ResultSet rs;

	public AttendDAO() {
		super();
	}

	@Override
	public ResultSet select(String sql) {
		try {
			psmt = conn.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = psmt.executeQuery();
		} catch (SQLException e) {
			System.out.println("조회 실패!!!");
			e.printStackTrace();
		}
		return rs;
	}

	@Override
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

	@Override
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

	@Override
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
	
	@Override
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) { }
	}
}
