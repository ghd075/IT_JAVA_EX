package co.hong.sec01.exam02;

import java.util.*;
import java.util.stream.Stream;

public class ParallelMain {

	public static void main(String[] args) {
		List<String> list = Arrays.asList(
		"홍길동", "신용권", "김자바", 
		"람다식", "박병렬");
		
		//순차 처리
		Stream<String> stream = list.stream();
		stream.forEach(ParallelMain :: print); // 메소드 참조(s -> ParallelMain.print(s)와 동일)
		System.out.println();
		
		//병렬 처리
		Stream<String> parallelStream = list.parallelStream();
		parallelStream.forEach(ParallelMain :: print); // 메소드 참조
		
	}
	
	public static void print(String str) {
		System.out.println(str + " : " + Thread.currentThread().getName());
	}

}
