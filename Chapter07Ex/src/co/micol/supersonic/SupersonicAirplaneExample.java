package co.micol.supersonic;

public class SupersonicAirplaneExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SupersoniAirplane sa = new SupersoniAirplane();
		
		sa.takeOff();
		sa.fly();
		sa.flyMode = SupersoniAirplane.NORMAL;
		sa.fly();
		sa.land();
	}
}
