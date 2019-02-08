package co.micol.attendence;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AttendenceDataInput implements ServiceInterface {
	private String sql;
	private DAO dao;

	@Override
	public String input() {
		int rownum = 1;
		String date = "2019-03-23";
		char att = 'N';
		sql = "insert into s_attend values('" + 
				rownum + "','" + date + "','" + att + "')";
		return sql;
	}

	@Override
	public void processDao() {
		dao = new AttendDAO();
		int n = dao.insert(sql);
		if(n != 0) System.out.println("정상 입력");
		else System.out.println("입력 실패");

	}

	@Override
	public void run() {
		ResultSet rs;
		input();
		processDao();
		rs = dao.select("select * from s_attend order by l_sub_recode asc");
		try {
			while(rs.next()) {
				System.out.print(rs.getInt("l_sub_recode")+"  ");
				System.out.print(rs.getDate("a_date")+"  ");
				System.out.println(rs.getString("a_check"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		dao.close();
	}
}
