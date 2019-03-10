package co.micol.sec03.exam02;

import java.util.*;

public class HashSetMain2 {

	public static void main(String[] args) {
		Set<Member> set = new HashSet<Member>();
		
		//인스턴스는 다르지만 내부 데이터가 동일하므로 객체 1개만 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30));
		
		System.out.println("총 객체수 : " + set.size());
	}

}
