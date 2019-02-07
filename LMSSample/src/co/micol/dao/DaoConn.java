package co.micol.dao;
/*
 * Dao 상위클래스
 * 2019.01.31
 * ver 1.0
 * hong
 */
import java.sql.*;
import java.util.*;
import java.io.*;

public abstract class DaoConn {
	private String driver;
	private String url;
	private String user;
	private String password;
	
	public Connection conn;
	
	//파일읽어오기
	private void confiration() {
		String path = "config/db.properties";
		Properties pr = new Properties();
		try {
			pr.load(new FileReader(path));
			driver = pr.getProperty("driver");
			url = pr.getProperty("url");
			user = pr.getProperty("user");
			password = pr.getProperty("pass");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("파일 읽기 실패!!!");
		}
	}
	
	//디비 연결
	public DaoConn() {
		confiration();
		try {
			Class.forName(driver); //드라이버를 로드합니다.
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password); //오라클에 연결합니다.
			System.out.println("오라클 연결 성공");
		}catch(ClassNotFoundException e) { //드라이버를 찾지 못하면
			System.out.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
	}
	
	public abstract ResultSet select(String sql);
	public abstract int insert(String sql);
	public abstract int update(String sql);
	public abstract int delect(String sql);
	public abstract void close();
	public abstract void selectAll();
}
