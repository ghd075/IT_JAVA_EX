package co.micol.quiz04;

import java.util.function.IntSupplier;

public class LambdaMain {
	
	public static int method(int x, int y){
		IntSupplier supplier = () -> {
//			x *= 10; //매개변수 x는 final타입이 되기 때문에 변경 불가(오류발생)
			int result = x + y;
			return result;
		};
		int result = supplier.getAsInt();
		return result;
	}
	
	public static void main(String[] args) {
		System.out.println(method(3, 5));

	}

}
