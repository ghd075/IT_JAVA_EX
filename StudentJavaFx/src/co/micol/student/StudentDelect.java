package co.micol.student;

import co.micol.student.dao.DAO;

public class StudentDelect {
	
	private String sql;
	private DAO dao;
	
	public void processDao(String sId) {
		sql = "delete from student where studentid ='"+sId+"'";
		dao = new DAO();
		int n = dao.delete(sql);
		if(n != 0) System.out.println("정상 삭제");
		else System.out.println("삭제 실패");
	}
}
