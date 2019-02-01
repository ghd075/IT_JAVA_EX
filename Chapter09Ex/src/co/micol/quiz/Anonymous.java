package co.micol.quiz;

public class Anonymous {
	Vehicel field = new Vehicel() {
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");
			
		}
	};
	void method1() {
		Vehicel localVar = new Vehicel() {
			@Override
			public void run() {
				System.out.println("승용차가 달립니다.");
			}
		};
		localVar.run();
	}
	
	void method2(Vehicel v) {
		v.run();
	}
}
