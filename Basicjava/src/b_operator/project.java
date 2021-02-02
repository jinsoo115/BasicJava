package b_operator;

import java.util.Scanner;

public class project {

	public static void main(String[] args) {
		//다음과 같은 프로그램을 작성해주세요
		/*
		 * =============회원가입=============
		 * 아이디>admin
		 * 비밀번호(4자리숫자)>1234
		 * 이름>홍길동
		 * 나이>30
		 * 키>185.5
		 * ===============================
		 * 아이디: admin
		 * 비밀번호: 1234
		 * 이름: 홍길동
		 * 나이: 30세
		 * 키: 185.5cm
		 * ===============================
		 */
		Scanner sc = new Scanner(System.in); //입력받기 위한 클래스
		System.out.println("=============회원가입=============");
		System.out.print("아이디>");
		String id = sc.nextLine();
		System.out.print("비밀번호(4자리숫자)>");
		int password = Integer.parseInt(sc.nextLine());
		System.out.print("이름>");
		String name = sc.nextLine();
		System.out.print("나이>");
		int age = Integer.parseInt(sc.nextLine());
		System.out.print("키>");
		double height = Double.parseDouble(sc.nextLine());

		System.out.println("===============================");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + password);
		System.out.println("이름: " + name);
		System.out.println("나이: " + age + "세");
		System.out.println("키: " + height + "cm");
		System.out.println("===============================");   

	}

}
