package c_statement;

import java.util.ArrayList;
import java.util.Scanner;

public class SelfTest {

	public static void main(String[] args) {
		//탄수화물 중독 자가진단 테스트프로그램을 만들어주세요.
		Scanner sc = new Scanner(System.in);
		int count =0;
		String yesno = null;
		System.out.println("탄수화물 중독 자가진단 Y/N 로 입력하시오 (소/대문자)");
		
		System.out.print("아침을 배불리 먹은 후 점심시간 전에 배가 고프다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("밥, 빵, 과자 등 음식을 먹기 시작하면끝이 없다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("음식을 금방 먹은 후에도 만족스럽지 못하고 더 먹는다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("정말 배고프지 않더라도 먹을 때가 있다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("저녁을 먹고 간식을 먹지 않으면 잠이 오지 않는다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("스트레스를받으면 자꾸 먹고 싶어진다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("책상이나 식탁 위에 항상 과자, 초콜릿 등이 놓여있다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("오후 5시가 되면피곤함과 배고픔을 느끼고 일이손에 안잡힌다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("과자, 초콜릿등 단 음식은 상상만해도 먹고 싶어진다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		System.out.print("다이어트를 위해 식이조절을 하는데 3일도 못 간다.");
		yesno = sc.nextLine();
		if(yesno.equals("Y")||yesno.equals("y")){
			count++;
		}
		
		if(count>=7){
		System.out.println("당신의 테스트 결과는 "+ count +"개입니다.");
		System.out.println("7개 이상\n중독!\n전문의 상담이 필요함");
		}else if(count>=4){
			System.out.println("당신의 테스트 결과는 "+ count +"개입니다.");
			System.out.println("4~6개 이상\n위험!\n탄수화물 섭취 줄이기 위한식습관 개선이 필요함");
		}else if(count==3){
			System.out.println("당신의 테스트 결과는 "+ count +"개입니다.");
			System.out.println("3개\n주의!\n위험한 수준은 아니지만 관리 필요.");
		}else{
			System.out.println("당신의 테스트 결과는 "+ count +"개입니다.");
			System.out.println("건강하네요!");
		}
		
	}

}
