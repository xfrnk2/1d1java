package practice.interfacePractice;

//인터페이스의 본질은 추상메서드임.
public interface Creature {

	//인터페이스에서 static final은 부수적 개념
	int MAX = 10;	//static final 생략가능하다. 컴파일시에 컴파일러가 붙여준다.
	public void method();  //abstract 생략이 가능하다. 컴파일시에 컴파일러가 붙여준다.


}