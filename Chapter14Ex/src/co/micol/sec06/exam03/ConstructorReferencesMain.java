package co.micol.sec06.exam03;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ConstructorReferencesMain {

	public static void main(String[] args) {
		Function<String, Member> function1 = Member :: new; //생성자 참조
		Member member1 = function1.apply("ange1");
		
		BiFunction<String, String, Member> function2 = Member :: new; //생성자 참조
		Member member2 = function2.apply("신천사","ange1");
	}

}
