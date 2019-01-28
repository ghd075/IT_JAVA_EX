package co.micol.quiz;

public class SoundableExample {
	private static void printSount(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printSount(new Cat());
		printSount(new Dog());
	}

}
