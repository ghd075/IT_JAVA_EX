package co.micol.service_subject;

import java.util.Scanner;
import co.micol.dao.SubInterface;

public class SubjectUpdate implements SubInterface {
	
	private String sCode;
	private String sName;
	private SubjectDAO dao;
	
	public SubjectUpdate() {
		dao = new SubjectDAO();
	}
	
	@Override
	public String inputData() {
		Scanner sc = new Scanner(System.in); //키보드 입력
		String sql;
		dao.selectAll();
		System.out.print("과목명을 입력하세요 : ");
		sName = sc.nextLine();
		System.out.print("과목코드를 입력하세요 : ");
		sCode = sc.nextLine();
		sql = "update s_subjec set s_name = '" + sName
				+ "' where s_code = " + sCode;
		return sql;
	}

	@Override
	public void excuteQuery(String sql) {
		if(dao.update(sql) != 0 ) System.out.println("정상 수정");
		else System.out.println("수정 실패");
		dao.selectAll();
	}

	@Override
	public void serviceRun() {
		excuteQuery(inputData());
		dao.close();
	}
}
