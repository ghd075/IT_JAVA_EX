package co.micol.driver;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Driver driver = new Driver();
//		
//		Bus bus = new Bus();
//		Taxi taxi = new Taxi();
//		
//		driver.drive(bus);
//		driver.drive(taxi);
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFar() 사용불가
		
		Bus bus = (Bus) vehicle;
		
		bus.run();
		bus.checkFare(); //사용가능
	}

}
