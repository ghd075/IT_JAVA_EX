package co.micol.generic_04;

import co.micol.generic_02.Box2;

public class Util {
	public static <T> Box2<T> boxing(T t){
		Box2<T> box = new Box2<T>();
		box.set(t);
		return box;
	}
}
