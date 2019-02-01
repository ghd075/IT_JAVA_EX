package co.micol.calcuatable;

public class Anonymous {
	private int field;
	
	public void method(final int arg1, int arg2) {
		final int var1 = 0;
		int var2 = 0;
		field = 10;
		
		//arg1 = 20; (x)
		//arg2 = 20; (x)
		
		//var1 = 30; (x)
		//var2 = 30; (x)
		
		Calculatable calc = new Calculatable() {
			
			@Override
			public int sum() {
				// TODO Auto-generated method stub
				int result = field + arg1 + arg2 + var1 + var2;
				return 0;
			}
		};
	}
}
