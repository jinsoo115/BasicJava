package d_array;

import java.util.Scanner;

public class SetComma {

	public static void main(String[] args) {
		//숫자를 입력받아 입력받은 숫자에 3자리 마다 콤마(,)를 붙여출력해주세요
		//10,000,000
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자입력");
		String number = sc.nextLine();
		String comma="";
		int count = 0;
		
		for(int i = number.length() -1;  i>= 0; i--){
			comma = number.charAt(i) + comma;
			count++;
			if(count % 3 == 0 && count != number.length()){
				comma ="," + comma;
			}
		}
		System.out.println(comma);
//		System.out.print("숫자를 입력하세요>");
//		String number = sc.nextLine();
//		System.out.println(number);
//		int firstComma = number.length() % 3;
//		String saveNumber = "";
//		if(firstComma !=0){
//			saveNumber = number.substring(0,firstComma);
//			saveNumber += ",";
//		}
//
//		for(int i = firstComma; i < number.length()-2; i+=3){
//			if(i==number.length()-3){
//				saveNumber += number.substring(i,i+3);
//				break;
//			}else{
//				saveNumber += number.substring(i,i+3);
//				saveNumber += ",";
//			}
//		}
//		System.out.println(saveNumber);
	}

}
