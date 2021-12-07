package practice.interfacePractice;


public class Person implements Creature{

	@Override
	public void method() {
		System.out.println("인터페이스 Creature를 구현한 Member의 method() 호출됨.");

	}

	public void method2(){
		System.out.println("Person 클래스에 있는 멤버메서드이다.");
	}

}