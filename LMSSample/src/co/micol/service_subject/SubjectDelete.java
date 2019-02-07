package co.micol.service_subject;

import java.util.*;

import co.micol.dao.SubInterface;

public class SubjectDelete implements SubInterface {
	private String sCode;
	private SubjectDAO dao;
	
	public SubjectDelete() {
		dao = new SubjectDAO();
	}
	
	@Override
	public String inputData() {
		// TODO Auto-generated method stub
		String sql;
		Scanner sc = new Scanner(System.in);
		dao.selectAll();
		System.out.println("=================");
		System.out.println("삭제할 코드를 입력하세요.");
		sCode = sc.next();
		sql = "delect from s_subject where s_code ='" + sCode +"'";
		return sql;
	}

	@Override
	public void excuteQuery(String sql) {
		if(dao.delect(sql) != 0 ) System.out.println("정상 삭제");
		else System.out.println("삭제 실패");
		dao.selectAll();
	}

	@Override
	public void serviceRun() {
		excuteQuery(inputData());
		dao.close();
	}
}
