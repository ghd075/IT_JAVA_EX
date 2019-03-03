package co.micol.sec05.exam06;

import java.util.function.Function;

public class FunctionAndThenComposeMain {

	public static void main(String[] args) {
		Function<Member, Address> functionA;
		Function<Address, String> functionB;
		Function<Member, String> functionAB;
		String city;
		
		functionA = (m) -> m.getAddress();
		functionB = (m) -> m.getCity();
		
		functionAB = functionA.andThen(functionB);
		city = functionAB.apply(
				new Member("홍길동", "hong", new Address("한국", "서울")));
		System.out.println("거주 도시 : " + city);
		
		functionAB = functionB.compose(functionA);
		city = functionAB.apply(
				new Member("홍길동", "hong", new Address("한국", "서울")));
		System.out.println("거주 도시 : " + city);

	}

}
