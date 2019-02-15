package co.micol.student;

import co.micol.student.dao.DAO;

public class StudentUpdate {
	private String sql;
	private DAO dao;
	
	public void processDao(String sId, String sAddr ,String sTel) {
		sql = "update student set studentaddr = '"+sAddr+"', studenttel = '"+ sTel +"' where studentid = '"+sId+"'";
		dao = new DAO();
		if(dao.update(sql) != 0) System.out.println("정상 수정");
		else System.out.println("수정 실패");
	}
}
