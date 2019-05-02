package co.hong.sec02.exam03;

import java.util.stream.IntStream;

public class FromIntRangeMain {
	public static int sum;
	
	public static void main(String[] args) {
		IntStream stream = IntStream.rangeClosed(1, 100);
		stream.forEach(a -> sum += a);
		System.out.println("총합 : " + sum);
	}

}
