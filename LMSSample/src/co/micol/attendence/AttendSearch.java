package co.micol.attendence;

import java.sql.*;

public class AttendSearch implements ServiceInterface {
	private DTO dto;
	private ResultSet rs;
	private String sql;
	private DAO dao;
	
	@Override
	public String input() {
		sql = "select * from attendview";
		return sql;
	}

	@Override
	public void processDao() {
		dao = new AttendDAO();
		rs = dao.select(sql);
		try {
			while(rs.next()) {
				dto = new DTO();
				int i = 0;
				dto.lecture = rs.getString("s_name");
				dto.profe = rs.getString("p_name");
				dto.studentName = rs.getString("student_name");
				while(rs.next()) {
					if(rs.getString("student_name").equals(dto.studentName)) {
						dto.attendence[i++] = rs.getString("a_check");
						continue;
					}else {
						break;
					}
				}
				dto.toString();
				rs.previous();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		input();
		processDao();
		dao.close();

	}

}
