package co.micol.generic_04;

public class CompareMethodMain {

	public static void main(String[] args) {
		Pair<Integer, String> p1 = new Pair<Integer, String>(1, "사과");
		Pair<Integer, String> p2 = new Pair<Integer, String>(1, "사과");
		boolean result1 = Util2.<Integer, String>compare(p1,p2); //구체적인 타입을 명시적으로 지정
		if(result1){ 
			System.out.println("논리적으로 동등한 객체입니다.");
		}else{
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
		
		Pair<String, String> p3 = new Pair<String, String>("user1", "홍길동");
		Pair<String, String> p4 = new Pair<String, String>("user2", "홍길동");
		boolean result2 = Util2.compare(p3, p4); //구체적인 타입을 추정
		if(result2){
			System.out.println("논리적으로 동등한 객체입니다.");
		}else{
			System.out.println("논리적으로 동등하지 않는 객체입니다.");
		}
	}

}
