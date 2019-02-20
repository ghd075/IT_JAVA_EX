package co.micol.quiz;

public class ThreadMain2 {

	public static void main(String[] args) {
		Thread thread = new MovieThread2();
		thread.start();
		
		try {
			Thread.sleep(1000);
		}catch(InterruptedException e) {
			
		}
		thread.interrupt();

	}

}
