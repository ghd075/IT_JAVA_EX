package co.micol.service_subject;

import java.sql.*;
import java.util.*;

import co.micol.dao.SubInterface;

public class SubjectInput implements SubInterface {
	private String sCode;
	private String sName;
	private SubjectDAO dao;
	
	public SubjectInput() {
		// TODO Auto-generated constructor stub
		dao = new SubjectDAO();
	}
	
	@Override
	public String inputData() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); //키보드 입력
		String sql;
		dao.selectAll();
		System.out.print("과목명을 입력하세요 : ");
		sName = sc.nextLine();
		System.out.print("과목코드를 입력하세요 : ");
		sCode = sc.nextLine();
		sql = "insert into s_subjec values('" + sCode + "','"+
				sName + "')";
		
		return sql;
	}

	@Override
	public void excuteQuery(String sql) {
		// TODO Auto-generated method stub
		if(dao.insert(sql) != 0) System.out.println("정상입력");
		else System.out.println("입력 실패");
		dao.selectAll();
	}

	@Override
	public void serviceRun() {
		// TODO Auto-generated method stub
		excuteQuery(inputData());
		dao.close();
	}	

}
