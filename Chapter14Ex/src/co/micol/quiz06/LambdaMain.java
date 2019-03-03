package co.micol.quiz06;

import java.util.function.ToIntFunction;

public class LambdaMain {
	private static Student[] students = {
		new Student("홍길동", 90, 96),
		new Student("신용권", 95, 93)
	};
	
	//avg() 메소드 작성
	public static double avg(ToIntFunction<Student> function){
		int sum = 0;
		for(Student student : students){
			sum += function.applyAsInt(student);
		}
		double avg = (double) sum / students.length;
		return avg;
	}
	public static void main(String[] args) {
		//문제6번
		double englishAvg = avg( s -> s.getEnglishScore() );
		System.out.println("영어 평균 점수 : " + englishAvg);
		
		double mathAvg = avg( s -> s.getMathScore() );
		System.out.println("수학 평균 점수 : " + mathAvg);
		
		//문제7번
		englishAvg = avg( Student :: getEnglishScore );
		System.out.println("영어 평균 점수 : " + englishAvg);
		
		mathAvg = avg( Student :: getMathScore );
		System.out.println("수학 평균 점수 : " + mathAvg);
	}
}
