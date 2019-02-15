package co.micol.student;

import java.sql.ResultSet;
import java.sql.SQLException;

import co.micol.student.dao.DAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * 데이터 조회 클래스
 *
 */

public class StudentSelect {
	private ObservableList<StudentBeen> studentData;
	
    public ObservableList<StudentBeen> selectPerson() {
    	studentData = FXCollections.observableArrayList();
    	StudentBeen student = null; 
    	DAO dao = new DAO();
    	String sql = "select * from student";
    	ResultSet rs = dao.Select(sql);
    	try {
    		while(rs.next()) {
    			String id = rs.getString("studentid");
    			String name = rs.getString("studentname");
    			String addr = rs.getString("studentaddr");
    			String tel = rs.getString("studenttel");
    			
    			student = new StudentBeen(id, name, addr, tel);
    			
    			studentData.add(student);
    		}
    	}catch (SQLException e) {
			System.out.println("조회실패!!");
		}
    	return studentData;
    }

}
