package co.micol.attendence;

import java.sql.*;
import java.util.Arrays;

public class DTO {
	public String lecture;
	public String profe;
	public String studentName;
	public Date adate;
	public String[] attendence = new String[15];
	public String week;
	
	@Override
	public String toString() {
		String ch = null;
		System.out.print(lecture+"  ");
		System.out.print(profe+"  ");
		System.out.print(studentName+"  ");
		
		for(String row : attendence) {
			System.out.print(row+"  ");
		}
		System.out.println();
		return null;
	}
}
