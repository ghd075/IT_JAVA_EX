package co.micol.generic_04;

import co.micol.generic_02.Box2;

public class BoxingMethodMain {

	public static void main(String[] args) {
		Box2<Integer> box1 = Util.<Integer>boxing(100);
		int Value = box1.get();
		
		Box2<String> box2 = Util.boxing("홍길동");
		String strValue = box2.get();
	}

}
