package co.micol.localfinal;

public class Outter {
	public void method1(final int arg) {
		final int localVariable = 1;
//		arg = 100; //사용가능
//		loclVariable = 100; //사용가능
		class Inner {
			public void method() {
				int result = arg + localVariable;
			}
		}
	}
	
	//자바 8 이후
	public void method2(int arg) {
		int localVariable = 1;
		//arg = 100;
		//localVariable = 100; (x)
		class Inner {
			int result = arg + localVariable;
		}
	}
}
