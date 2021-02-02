package b_operator;

import java.util.Scanner;

public class SimpleCalculator {

	public static void main(String[] args) {
		//두개의 숫자와 연산자를 입력 받아 연산결과를 알려주는프로그램을 만들어주세요
		Scanner sc = new Scanner(System.in);
		System.out.print("첫번째 숫자를 입력해주세요>");
		double number1 = Double.parseDouble(sc.nextLine());
		System.out.print("연산자를 입력해주세요>");
		String operator = sc.nextLine();
		System.out.print("두번째 숫자를 입력해주세요>");
		double number2 = Double.parseDouble(sc.nextLine());
		
		String sum;
		sum  = operator.equals("+") ? Double.toString(number1 + number2) 
				:operator.equals("-") ? Double.toString(number1 - number2) 
						: operator.equals("*") ? Double.toString(number1 * number2) 
								: operator.equals("/") ? Double.toString(number1 / number2) 
										: operator.equals("%") ? Double.toString(number1 % number2) 
												: " 연산자를 잘못 입력 하셨습니다."; 
		
		
		/*if(operator.equals("+")){
			sum = number1 + number2;
		}
		else if(operator.equals("-")){
			sum = number1 - number2;
		}
		else if(operator.equals("*")){
			sum = number1 * number2;
		}
		else if(operator.equals("/")){
			sum = number1 / number2;
		}
		else if(operator.equals("%")){
			sum = number1 % number2;
		}
		else{
			System.out.println("연산자를 잘못 입력하셨습니다.");
		}*/
		System.out.println(number1  + " " + operator + " " + number2 + "의 정답은" + sum);
		sc.close();
	}

}
