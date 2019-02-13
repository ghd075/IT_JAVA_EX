package co.micol.running;

public class ThreadB extends Thread {
	public boolean stop = false; //종료 플래그
	public boolean work = false; //작업 진행 여부 플래그
	
	public void run() {
		while(!stop) {
			if(work) {
				System.out.println("ThreadB 작업 내용");
			}else {
				Thread.yield();
			}
		}
		System.out.println("ThreadB 종료");
	}
}
