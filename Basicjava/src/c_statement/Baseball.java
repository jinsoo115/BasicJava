package c_statement;

import java.util.Scanner;

public class Baseball {

	public static void main(String[] args) {
		/* 숫자야구 만들기^^
		 * 135
		 * 
		 * 123 : 1S 1B 1O
		 */
		Scanner s = new Scanner(System.in);
		String yesno;


		do{
			int random1 = 0;
			int random2 = 0;
			int random3 = 0;
			while(random1 == random2 || random1 == random3 || random2 == random3){
				random1 = (int)(Math.random() * 9)+1;
				random2 = (int)(Math.random() * 9)+1;
				random3 = (int)(Math.random() * 9)+1;
			}
			System.out.println(random1 + " " + random2 + " " + random3);
			int input1=0, input2=0, input3=0, strike=0, ball=0, out=0 ;
			
			
			do{
				strike = 0;
				ball = 0;
				out = 0;

				System.out.print("첫번쨰 숫자를 입력해주세요>");
				input1 = Integer.parseInt(s.nextLine());

				do{
					System.out.print("두번쨰 숫자를 입력해주세요>");
					input2 = Integer.parseInt(s.nextLine());
					if(input1 == input2){			
						System.out.println("첫번째 숫자와 같은걸 입력하셨습니다. 새로 입력하세요");
					}
				}while(input1 == input2);

				do{
					System.out.print("세번쨰 숫자를 입력해주세요>");
					input3 = Integer.parseInt(s.nextLine());
					if(input1 == input3){
						System.out.println("첫번째 숫자와 같은걸 입력하셨습니다. 새로 입력하세요");
					}else if(input2 == input3){
						System.out.println("두번째 숫자와 같은걸 입력하셨습니다. 새로 입력하세요");
					}
				}while(input1 == input3 || input2 == input3);



				if(input1==random1){
					strike++;
				}else if(input1==random2 || input1 == random3){
					ball++;
				}

				if(input2==random2){
					strike++;
				}else if(input2==random1 || input2 == random3){
					ball++;
				}

				if(input3==random3){
					strike++;
				}else if(input3==random1 || input3 == random2){
					ball++;
				}
				out = 3 - strike - ball;

				System.out.println(strike + "S " + ball + "B " + out + "O");
				System.out.println("입력하신 번호는 "+input1 + " " + input2 + " " + input3+" 입니다.");
				System.out.println("다시 입력해주세요^^");

			}while(strike!=3);
			System.out.println("정답입니다. 게임을 다시 하시겠습니까?(Y/N)");
			yesno = s.nextLine();
		}while(yesno.equals("Y")||yesno.equals("y"));
		System.out.println("수고하셨습니다.");
	}

}
