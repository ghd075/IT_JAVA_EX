package co.micol.quiz;

public class MemberService {
	private String id= "hong";
	private String password = "12345";
	
	public boolean login(String id, String password) {
		if(this.id.equals(id)) {
			return true;
		} else {
			return false;
		}
	}
	
	public void logout(String id) {
		if(this.id.equals(id))
			System.out.println("로그아웃 되었습니다.");
	}
	
}
