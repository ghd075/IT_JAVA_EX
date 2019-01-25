package co.micol.car;

public class SportsCar extends Car {

	@Override
	public void speedup() {
		// TODO Auto-generated method stub
		speed += 10;
	}
	
	/*
	 * 재정의할 수없음
	 */
//	@Override
//	public void stop() {
//		System.out.println("스포츠카를 멈춤");
//		speed = 0;
//	}
	
}
