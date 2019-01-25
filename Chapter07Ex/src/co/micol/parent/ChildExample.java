package co.micol.parent;

public class ChildExample {

	public static void method1(Parent parent) {
		// TODO Auto-generated method stub
//		Child child = new Child();
//		
//		Parent parent = child;
//		parent.method1();
//		parent.method2();
//		parent.method3(); //(호출 불가능)
		
//		Parent parent = new Child();
//		parent.field1 = "data";
//		parent.method1();
//		parent.method2();
//		/*
//		parent.field2 = "data2"; //(불가능)
//		parent.method3(); //(불가능)
//		 */
//		
//		Child child = (Child) parent;
//		child.field2 = "yyy"; //(가능)
//		child.method3(); //(가능)
		if(parent instanceof Child) {
			Child child = (Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		}else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
		
	}
	
	public static void metho2(Parent parent) {
		Child child = (Child) parent;
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		Parent parentA = new Child();
		method1(parentA);
		metho2(parentA);
		
		Parent parentB = new Parent();
		method1(parentB);
//		metho2(parentB); //예외발생
	}

}
