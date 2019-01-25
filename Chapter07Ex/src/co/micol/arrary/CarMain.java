package co.micol.arrary;

public class CarMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = new Car();
		
		for(int i=1;i<=5;i++) {
			int problemLocation = car.run();
			if(problemLocation != 0) {
				System.out.println(car.tires[problemLocation-1].location + " HankooKTire로 교체");
				car.tires[problemLocation-1] =
						new HankookTire(car.tires[problemLocation-1].location, 15);
			}
			System.out.println("---------------------------");
		}
	}

}
