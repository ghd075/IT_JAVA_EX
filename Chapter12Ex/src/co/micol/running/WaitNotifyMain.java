package co.micol.running;

public class WaitNotifyMain {

	public static void main(String[] args) {
		WorkObject sharedObject = new WorkObject();
		
		ThreadA1 threadA1 = new ThreadA1(sharedObject);
		ThreadB1 threadB1 = new ThreadB1(sharedObject);
		
		threadA1.start();
		threadB1.start();
	}

}
