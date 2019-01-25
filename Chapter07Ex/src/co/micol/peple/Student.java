package co.micol.peple;

public class Student extends People{
	public int studentNo;
	
	public Student(String name, String ssn, int strudentNo) {
		super(name,ssn);
		this.studentNo = strudentNo;
	}
}
