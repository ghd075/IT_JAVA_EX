package co.micol.sec05.exam03;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.Arrays;

public class FunctionMain {
	private static List<Student> list = Arrays.asList(
			new Student("홍길동", 90, 96),
			new Student("신용권", 95, 93));
	
	
	public static void printStirng(Function<Student, String> function){
		for(Student student : list) { //list에 저장된 항목 수만큼 루핑
			System.out.println(function.apply(student) + " ");
		}
		System.out.println();
	}
	
	public static void printInt(ToIntFunction<Student> function){
		for(Student student : list){ //list에 저장된 항목 수만큼 루핑
			System.out.println(function.applyAsInt(student) + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[학생 이름]");
		printStirng(t -> t.getName());
		
		System.out.println("[영어 이름]");
		printInt(t -> t.getEnglishScore());
		
		System.out.println("[수학 이름]");
		printInt(t -> t.getMathScore());
	}

}
