package g_oop2;

public class AccessModifier {//public 접근제어자
	
	public String publicVar = "public : 접근제한이 없음";
	protected String protectedVar = "protected : 같은 패키지 + 상속받은 클래스에서 접근 가능";
	String defaultVar = "defaultVar : 같은 패키지에서만 접근 가능";
	private String privateVar = "private : 클래스 내에서만 접근 가능";
	
	public void publicMethod(){
		System.out.println(publicVar);
	}
	
	protected void protectedMthod(){
		System.out.println(protectedVar);
	}
	
	void defaultMethod(){
		System.out.println(defaultVar);
	}
	
	private void privateMethod(){
		System.out.println(privateVar);
	}
	
	public static void main(String[] args) {
		AccessModifier am = new AccessModifier();
		
		System.out.println(am.publicVar);
		am.publicMethod();
		
		System.out.println(am.protectedVar);
		am.protectedMthod();
		
		System.out.println(am.defaultVar);
		am.defaultMethod();
		
		System.out.println(am.privateVar);
		am.privateMethod();
		
		
		Time t = new Time();
		
//		t.hour = 9;
//		t.minute = 380;
//		t.second = -30;
		
		t.setHour(23);
		t.setMinute(59);
		t.setSecond(50);
		
		System.out.println(t.getTime());
		
		/*
		 * 접근제어자를 사용하는 이유
		 * - 데이터를 보호하기 위해
		 * - 사용하는데 불필요한 멤버를 숨기기 위해
		 */
		
		t.clock();
		
	}
}
