package g_oop2;

public interface SampleInterface {
	//인터페이스 : 상수와 추상 메서드만 가질수 있다.
	//인터페이스의 모든 멤버변수는 public static final 제어자를 사용해야한다.
	public static final int NUM1=1;
	
	//모든 멤버변수의 제어자가 같기 때문에 생력이 가능하다.
	int NUM2=2;
	
	//인터페이스의 모든 메서드는 public abstract 제어자를 사용해야한다.
	public abstract void method1();
	
	//모든 메서드의 제어자가 같기 때문에 생략이 가능하다.
	void method2();
}

class SampleImplement implements SampleInterface, SampleInterface2{

	@Override
	public void method1() {
		
	}

	@Override
	public void method2() {
		
	}

	@Override
	public void method3() {
		
	}
	
}

interface SampleInterface2{
	void method1();
	void method3();
}

