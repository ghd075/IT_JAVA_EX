package co.micol.generic_05;

public class BoundedTypeParemeterMain {

	public static void main(String[] args) {
//		String str = Util.compare("a", "b"); //String은 Number 타입이 아니기때문에 에러 발생
		
		int result1 = Util.compare(10, 20); //자동 박싱(int -> Integer)
		System.out.println(result1);
		
		int result2 = Util.compare(4.5, 3); //자동 박싱(double -> Double)
		System.out.println(result2);

	}

}
