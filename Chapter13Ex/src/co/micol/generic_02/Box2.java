package co.micol.generic_02;

public class Box2<T> {
	private T object;
	public void set(T object){ this.object = object; }
	public T get() { return object; }
}
