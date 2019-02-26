package co.micol.sec05.exam01;

public class RunnableMain {

	public static void main(String[] args) {
		Runnable runnable = () -> {
			for(int i = 0; i<10; i++){
				System.out.println(i);
			}
		};
		
		Thread thread = new Thread(runnable);
		thread.start();
	}
}
