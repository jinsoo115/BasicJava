package c_statement;

import java.util.Scanner;

public class ConditionalStatement {

	public static void main(String[] args) {
		/*
		 * 조건문
		 * - if문
		 * - switch문
		 * 
		 * - if문
		 * - if(조건식){ } : 조건식의 결과가 true이면 블럭안의 문장을 수행한다.
		 * - else if(조건식){ } : 다수의 조건이 필요할때 if뒤에 추가한다.
		 * - else{ } : 결과가 true인 조건이 하나도 없는 경우를 위해서 축한다.
		 */

		int a = 1;

		if(a == 1){
			System.out.println("조건식의 연산결과가 true이면 수행된다.");
		}

		if(a == 0){
			System.out.println("조건식의 연산결과가 false이면 수행되지 않는다.");
		}

		if(a == 1){
			System.out.println("a가 1인 경우에 하고싶은 것");
		}else if(a == 2){
			System.out.println("a가 2인 경우에하고싶은 것");
		}else if(a == 3){
			System.out.println("a가 3인경우에 하고싶은 것");
		}else{
			System.out.println("이외의 경우에 하고싶은 것");
		}

		if(a < 10){
			System.out.println("a가 10보다 작다.");
		}else if(a < 20){
			System.out.println("a가 20보다 작다.");
		}

		//시험점수가 60점 이상이면 합격 그렇지 않으면 불합격
		int score = 50;

		if(score >= 60){
			System.out.println("합격입니다.");
		}else{
			System.out.println("불합격입니다.");
		}

		//성적에 등급을 부여하는 프로그램을 만들어보자.
		score = 80;
		String grade = null;

		if(score >= 90){
			grade = "A";
		}
		else if(score < 90 && score <= 80){
			grade = "B";
		}
		else if(score < 80 && score <= 70){
			grade = "C";
		}
		else if(score < 70 && score <= 60){
			grade = "D";
		}
		else{
			grade = "F";
		}
		System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");



		score = 97;
		grade=null;

		if(score >= 90){
			grade = "A";
			if(score >= 97){
				grade += "+";
			}else if(score <= 93){
				grade += "-";
			}
		}else if(score >= 80){
			grade = "B";
			if(score >= 87){
				grade += "+";
			}else if(score < 83){
				grade += "-";
			}
		}else if(score >= 70){
			grade = "C";
			if(score >= 77){
				grade += "+";
			}else if(score < 73){
				grade += "-";
			}
		}else if(score >= 60){
			grade = "D";
			if(score >= 67){
				grade += "+";
			}else if(score < 63){
				grade += "-";
			}
		}else{
			grade ="F";
		}

		System.out.println(score + "점에 해당하는 등급은 " + grade + "입니다.");

		/*
		 * switch문
		 * - switch(int/String){case 1: brea;}
		 * - 조건식의 결과는 정수와 문자열인(JDK1.7부터 문자열 허용) 허용한다.
		 * - 조건식과 일치하는 case문 이후의 문장을 수행한다.
		 */

		a = 1;

		switch(a){
		case 1:
			System.out.println("a가 1인 경우에 하고싶은것");
			break;
		case 2:
			System.out.println("a가 2인 경우에 하고싶은 것");
			break;
		case 3:
			System.out.println("a가 3인 경우에 하고싶은 것");
			break;
		default:
			System.out.println("이외의 경우에 하고싶은 것");
		}

		String b= "a";

		switch(b){
		case "a":
			System.out.println("b가 \"a\"인 경우에 하고싶은것");
			break;
		case "b":
			System.out.println("b가 \"b\"인 경우에 하고싶은 것");
			break;
		default:
			System.out.println("이외의 경우에 하고싶은 것");
			break;
		}

		//주어진 월에 해당하는 계절을 출력해봅시다.
		int month = 1;
		String season = null;

		switch(month){
		case 3:
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:	case 7:	case 8:
			season = "여름";
			break;
		case 9:	case 10: case 11:
			season = "가을";
		case 12: case 1: case 2:
			season = "겨을";
			break;
		default:
			System.out.println("잘못된 월을 입력하셨습니다.");
			break;
		}
		System.out.println(month + "월은" + season + "입니다.");

		score = 90;
		grade = null;

		switch(score/10){
		case 10: case 9: grade = "A"; break;
		case 8: grade = "B"; break;
		case 7: grade = "C"; break;
		case 6: grade = "D"; break;
		default:grade = "F";
		}
		System.out.println(score + "점에 대한 등급은" + grade +" 입니다.");

		//숫자를 입력받아 그 숫자가 0인지 아닌지 출력해주세요.
		Scanner sc = new Scanner(System.in);
		/*		System.out.print("숫자를 입력해주세요>");
		int number = Integer.parseInt(sc.nextLine());

		if(number == 0){
			System.out.println("입력하신 숫자는 0입니다");
		}else{
			System.out.println("입력하신 숫자는 0이 아닌 "+ number + "입니다.");
		}

		switch(number){
		case 0: System.out.println("입력하신 숫자는 0입니다"); break;
		default: System.out.println("입력하신 숫자는 0이 아닌 "+ number + "입니다.");
		}
		 */		
		/*		//숫자를 입력받아 그 숫자가 홀수인지 짝수인지 출력해주세요.
		System.out.print("숫자를 입력해주세요>");
		int number = Integer.parseInt(sc.nextLine());
		if(number%2 == 0){
			System.out.println(number + "은(는) 짝수 입니다.");
		}else if(number%2 ==1){
			System.out.println(number + "은(는) 홀수 입니다.");
		}

		switch(number%2){
		case 0: System.out.println(number + "은(는) 짝수 입니다."); break;
		case 1: System.out.println(number + "은(는) 홀수 입니다."); break;
		}

		 */		
		//점수 3개를 입력받아 총점, 평균, 평균등급을 출력해주세요
		/*		System.out.print("국어 점수를 입력해주세요>");
		int kor =  Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력해주세요>");
		int eng =  Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력해주세요>");
		int math =  Integer.parseInt(sc.nextLine());

		int sum = kor + eng + math;
		System.out.println("총점은 " + sum);
		double avg = Math.round(sum/3.0 * 10) / 10.0;
		System.out.println("평균은 " + avg);
		grade =null;

		if(avg >= 90){
			grade = "A";
		}
		else if(avg >= 80){
			grade = "B";
		}
		else if(avg >= 70){
			grade = "C";
		}
		else if(avg >= 60){
			grade = "D";
		}
		else{
			grade = "F";

		}
		System.out.println("평균점수인 " + avg + "점에 해당하는 등급은 " + grade + "입니다.");
		 */
		//1 ~ 100사이의 랜덤한 숫자를3개 발생시키고 오름차순으로출력해주세요 number1, number2, number3
		int number1 = (int) ((Math.random() * 100) + 1);
		int number2 = (int) ((Math.random() * 100) + 1);
		int number3 = (int) ((Math.random() * 100) + 1);
		System.out.println(number1 + " "+number2 + " "+number3 + " ");
		/*if(number1 >= number2 && number1 >= number3){
			if(number2 >= number3){
				System.out.println(number3 + "<" + number2 + "<" + number1);
			}else if(number3 >= number2){
				System.out.println(number2 + "<" + number3 + "<" + number1);
			}
		}else if(number2 >= number3 && number2 >= number1){
			if(number3 >= number1){
				System.out.println(number1 + "<" + number3 + "<" + number2);
			}else if(number1 >= number3){
				System.out.println(number3 + "<" + number1 + "<" + number2);
			}
		}else if(number3 >= number1 && number3 >= number2){
			if(number1 >= number2){
				System.out.println(number2 + "<" + number1 + "<" + number3);
			}else if(number2 >= number1){
				System.out.println(number1 + "<" + number2 + "<" + number3);
			}
		}*/

		int temp = 0;
		if(number1 >= number2){
			temp = number1;
			number1 = number2;
			number2 = temp;
		}
		if(number1 >= number3){
			temp = number1;
			number1 = number3;
			number2 = temp;
		}
		if(number2 >= number3){
			temp = number2;
			number2 = number3;
			number3 = temp;
		}
	
		System.out.println(number1 + "<" + number2 + "<" + number3);
		
	}

}


















