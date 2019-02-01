package co.micol.quiz;

public class AnonymousMain {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new Vehicel() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
