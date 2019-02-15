package co.micol.student;

import co.micol.student.dao.DAO;

public class StudentInsert {
	private String sql;
	private DAO dao;
	
	public void processDao(String sId, String sName, String sAddr, String sTel) {
		sql = "insert into student values ('"
			  + sId + "', '" + sName + "', '" + sAddr + "', '" + sTel + "','001')";
		dao = new DAO();
		int n = dao.insert(sql);
		if(n != 0) System.out.println("정상 입력");
		else System.out.println("입력 실패");
	}
}
