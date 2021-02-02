package b_operator;

public class ArithmeticOperator {

	public static void main(String[] args) {
		/*
		 * 산술연산자
		 * - 사칙연산: +, -, *, /, %(나머지)
		 * - 복합연산자: +=, -=, *=, /=, %=
		 * - 증감연산자: ++, -- 
		 */
		
		int result = 10 + 20- 30 * 40 / 50 % 60;
		//곱하기와 나누기가 더하기 뺴기보다 우선순위가 높다.
		System.out.println(result);
		
		//나머지 연산
		result = 10 / 3;
		System.out.println(result);
		//3.3333.... 이 연산의결과여야 하지만 타입이 int이기 떄문에 정수만표현된다.
		result = 10 % 3;
		System.out.println(result);
		
		//5개의 산술연산자를 사용해 5개의  연산을 수행 후 출력해주세요.
		System.out.println(100+20);
		System.out.println(200-30);
		System.out.println(30*40);
		System.out.println(40/20);
		System.out.println(10%3);
		
		//복합연산자
		//변수에 저장되어 있는 값에 연산을 수행할 때 수행할연산자와 대입연산자를 결합해 사용할 수 있다.
		result = result + 3;
		System.out.println(result);
		
		result += 3;
		System.out.println(result);
		
		result -= 5;
		System.out.println(result);
		
		result *= 2;
		System.out.println(result);
		
		//아래의 문장을 복합연산자를 사용한 문장으로 만들어주세요.
		//result = result + 10;
		result += 10;
		System.out.println(result);
		//result = result - 2 * 3;
		result -= 2 * 3;
		System.out.println(result);
		//result = result % 5;
		result %= 5;
		System.out.println(result);
		
		//증감연산자
		//증가연산자(++) : 변수의 값을 1 증가시킨다.
		//감소연산자(--) : 변수의 값을 1 감소시킨다.
		int i = 0;
		
		++i; //전위형: 변수의 값을 읽어오기전에 1 증가된다.
		i++; //후위형: 변수의 값을 읽어온 후에 1 증가된다.
		--i;
		i--;
		
		i = 0;
		System.out.println("++i = " + ++i);
		i = 0;
		System.out.println("i++ = " + i++);
		System.out.println(i);
		
		//피연산자의 타입이 서로 같아야만 연산이 가능하다.
		int _int = 10;
		double _double = 3.14;
		double result2 = _int + _double; //표현범위가 더 큰 타입으로 형변환된다.
		//double result3 = _int + (int)_double; //표현범위가 더 큰 타입으로 형변환된다. int를 사용하면 int로 형변환이 된다.
		System.out.println(result2);
		//System.out.println(result3);
		
		long _long = 100L;
		_long = _int + _long;
		_int = _int + (int)_long;
		
		byte _byte = 5;
		short _short = 10;
		int result3 = _byte + _short; //int보다 작은타입은 int로 형변환된다.
		System.out.println(result3);
		
		char _char = 'a';
		char _char2 ='b';
		_int = _char + _char2;
		System.out.println(_int);
		
		//오버플로우, 언더플로우
		//표현범위를 벗어나는 값을 표현할 때 발생하는 현상
		byte b = 127;
		b++;
		System.out.println(b);
		b--;
		System.out.println(b);
		
		//타입을 선택할 때 연산의 범위를 고려해야한다.
		
		//다음을 한줄씩 계산해서 최종 결과값을 출력해주세요.
		//1. 123456 + 654321
		//2. 1번의 결과값 * 123456
		//3. 2번의 결과값 / 123456
		//4. 3번의 결과값 - 654321
		//5. 4번의 결과값 % 123456
		int num = 123456;
		int num1 = 654321;
		long sum =0;
		sum = num + num1;
		System.out.println(sum);
		sum *= num;
		System.out.println(sum);
		sum /= num;
		System.out.println(sum);
		sum -= num1;
		System.out.println(sum);
		sum %= num;
		System.out.println(sum);
		
		//3개의 int형 변수를 선언 및 초기화 후 합계와 평균을 구해주세요.
		
		int _num1 = 125;
		int _num2 = 456;
		int _num3 = 789;
		
		int sum1 = _num1 + _num2 + _num3;
		System.out.println("합계 " + sum1);
		double avg1 = sum1/3.0; // 계산하는 값이 둘다 int일 경우 값이 int형으로만 나오기 떄문에 둘중 하나는 double형으로 만들어서 계산하여야 한다. 
		System.out.println("평균 " + avg1);
		
		//반올림
		//avg1 = Math.round(avg1);//Math.round() 무조건 소숫점 첫째자리에서 반올림
		//System.out.println(avg1);
		avg1 = Math.round(avg1 * 100) / 100.0;
		System.out.println(avg1);
		
		
		//랜덤
		int random = (int)(Math.random() * 100) + 1; //0.0~0.99999...
		System.out.println(random);
	}

}
