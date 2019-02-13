package co.micol.running;

public class ThreadB1 extends Thread {
	private WorkObject workObject;
	
	public ThreadB1(WorkObject workObject) {
		this.workObject = workObject;
	}

	@Override
	public void run() {
		for(int i = 0; i<10;i++) {
			workObject.methodB();
		}
	}
}
