package co.micol.quiz2;

public class ContainerMain {

	public static void main(String[] args) {
		Container<String> container1 = new Container<String>();
		container1.setT("홍길동");
		String str = container1.get();
		
		Container<Integer> container2 = new Container<Integer>();
		container2.setT(6);
		int value = container2.get();

	}

}
