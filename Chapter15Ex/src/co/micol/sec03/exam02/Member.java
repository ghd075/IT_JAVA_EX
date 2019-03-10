package co.micol.sec03.exam02;

public class Member {
	public String name;
	public int age;
	
	public Member(String name, int age){
		this.name = name;
		this.age = age;
	}

	//name과 age값이 같으면 true를 리턴
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member){
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age);
		}else{
			return false;
		}
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return name.hashCode() + age;
	}
	
	
}
