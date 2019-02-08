package co.micol.attendence;

public interface ServiceInterface {
	public String input(); //데이터 입력 sql 생성부
	public void processDao(); //DAO 호출해서 처리
	public void run(); //캡슐화 실행부
}
