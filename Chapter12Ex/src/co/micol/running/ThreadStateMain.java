package co.micol.running;

public class ThreadStateMain {

	public static void main(String[] args) {
		StatePrintThread statePrintThread =
				new StatePrintThread(new TargetThread());
		statePrintThread.start();
	}

}
