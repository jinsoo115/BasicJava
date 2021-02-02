package e_oop;

import java.util.Scanner;

public class OOP {

	public static void main(String[] args) {
		/*
		 * 객체지향 프로그래밍(Object Oriented Programing)
		 * - 프로그래밍을 단순히 코드의 연속으로 보는것이 아니라 객체간의 상호작용으로 보는것
		 * - 코드는 재사용성이 높고 유지보수가 용이하다.
		 */
		
		SampleClass sc = new SampleClass();
		
		System.out.println(sc.field);
		
		sc.method1();
		
		String returnValue= sc.method2(5);
		System.out.println(returnValue);
		sc.flowTest1();
		
		
		Calculator cal = new Calculator();
		
		double result = cal.addition(123456, 654321);
		System.out.println(result);
		
		result = cal.multiplication(result, 123456);
		System.out.println(result);
		
		result = cal.division(result, 123456);
		System.out.println(result);
		
		result = cal.subtraction(result, 654321);
		System.out.println(result);
		
		result = cal.remainder(result, 123456);
		System.out.println(result);
		
		
		/*
		 * 어떤 대상을 잡아 클래스를 만들어주세요.
		 * 메서드의 내용은 구체적이지 않아도 괜찮습니다.
		 * 파라미터의 리턴타입 위주로 만들어주세요.
		 * 클래스에 메서드를 만들어보면서 파라미터와 리턴타입을 생각해보는것이 중요합니다.
		 * 만들어진 클래스를 main메서드에서 사용해주세요.
		 */
		Scanner s = new Scanner(System.in);
		hellow hel = new hellow();
		System.out.println("첫번째 숫자입력");
		int num=Integer.parseInt(s.nextLine());
		System.out.println("두번째 숫자입력");
		int num2=Integer.parseInt(s.nextLine());
		System.out.println("세번째 숫자입력");
		int num3=Integer.parseInt(s.nextLine());
		System.out.println("네번째 숫자입력");
		int num4=Integer.parseInt(s.nextLine());
		int sum = hel.sum(num, num2, num3, num4);
		double avg = hel.avg(num, num2, num3, num4);
		double[] sumAndAvg = new double[2];
		sumAndAvg=hel.sumAndAvg(num, num2, num3, num4);
		System.out.println("합계는"+ sum + " 평균은" + avg);
		for(int i = 0; i < sumAndAvg.length; i++){
			System.out.println(sumAndAvg[i]);
		}
		s.close();
		
	}

}
