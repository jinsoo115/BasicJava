package b_operator;

import java.util.Scanner;

public class Etc {

	public static void main(String[] args) {
		/*
		 * 비트연산자
		 * - |, &, ^, !, <<, >>
		 * - 비트 단위로 연산한다.
		 * 
		 * 기타연산자
		 * - .(참조연산자) :특정 범위 내에 속해 있는 멤버를 지정할 때 사용한다.
		 * - (type) : 형변환
		 * - ?:(삼항연산자) : 조건식 ? 조건식이 참일 경우 수행할 문장 : 조건식이 거짓일 경우 수행할문장
		 */
		//1byte: 01010101
		System.out.println(10 | 15);//| : 둘다 0인 경우 0 그외 1
		//10 : 00001010
		//15 : 00001111
		//     00001111
		
		int x = 10;
		int y = 20;
		int result = x < y ? x : y;//int result  = x;
		System.out.println(result);
		
		//주민등록번호 뒷자리의 첫번째 숫자가 1이면 남자 2이면 여자
		int regNo = 9;
		String gender = regNo == 1 ? "남자" : "여자";
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		gender = regNo ==1 ? "남자" : (regNo == 2 ? "여자" : "확인불가");
		System.out.println("당신의 성별은 " + gender + " 입니다.");
		
		//2개의 숫자를 입력받고, 둘 중 더 큰 숫자를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		/*int a;
		int b;
		System.out.print("첫번째 숫자를 입력해 주세요>");
		a = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력해 주세요>");
		b = Integer.parseInt(sc.nextLine());
		boolean c = a < b;
		int d = c == true ? b : a;
		System.out.println(d);*/
		
		/*System.out.print("첫번째 숫자를 입력해 주세요>");
		int a = Integer.parseInt(sc.nextLine());
		System.out.print("두번째 숫자를 입력해 주세요>");
		int b = Integer.parseInt(sc.nextLine());
		int bigger = a > b ? a : b;
		System.out.println(bigger);*/
		
		//숫자를 입력받고, 그숫자가 1이나 3이면 남자를 2나 4면 여자를 출력해주세요.
		//그외의 숫자를 입력하면 확인불가를 출력해주세요.
		System.out.println("숫자를 입력해주세요> ");
		int num = Integer.parseInt(sc.nextLine());
		String gen = num==1 || num==3 ? "남자" : (num==2 || num==4 ? "여자" : "확인불가"); 
		System.out.println("당신의 성별은 " + gen + " 입니다");
	}

}
