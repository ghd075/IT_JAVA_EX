package co.micol.attendence;

import java.io.*;
import java.sql.*;
import java.util.*;

//상위클래스
public abstract class DAO {
	private String driver;
	private String url;
	private String user;
	private String password;
	private String path;
	
	public Connection conn;

	// Properties 파일 읽기
	private void configuration() {
		Properties per = new Properties();
		path = "config/db.properties";
		try {
			per.load(new FileReader(path));
			driver = per.getProperty("driver");
			url = per.getProperty("url");
			user = per.getProperty("user");
			password = per.getProperty("pass");
		} catch (IOException e) {
			System.out.println("파일 읽기 실패");
			e.printStackTrace();
		}
	}

	public DAO() {
		configuration();
		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		}catch (SQLException e) {
			System.out.println("오라클 연결 실패");
			e.printStackTrace();
		}
	}
	
	public abstract ResultSet select(String sql);
	public abstract int insert(String sql);
	public abstract int delete(String sql);
	public abstract int update(String sql);
	public abstract void close();
}
