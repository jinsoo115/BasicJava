package d_array;

import java.util.Arrays;
import java.util.Scanner;

public class Array {

	public static void main(String[] args) {
		//sysout + Ctrl + Apackebar + System.out.println()
		//라인삭제 : Ctrl + D
		//라인복사 : Ctrl + Alt + 방향키(위/아래)
		//라인이동 : Alt + 방향키(위/아래)

		/*
		 *  배열
		 *  - 여러개의 값을 하나의 변수에 저장해서 사용하는 것이다.
		 *  - 참조형 타입이다.
		 *  - 인덱스로 값을 구분한다.
		 *  - 길이를 변경 할 수 없다.
		 */

		int[] array; //배열의 주소를 저장할 공간이 만들어진다.
		array = new int[5]; //배열이 생성되고 그 주소가 저장된다.
		//배열 초기화시 기본값이 저장된다.
		/*
		 * 정수 : 0
		 * 실수 : 0.0
		 * 문자 : ' '(0)
		 * 논리 : false
		 * 참조형 : null
		 */
		array = new int[]{1, 2, 3, 4, 5};

		//		array = {1, 2, 3, 4, 5};
		//선언과 초기화를 동시에 해야한다.
		int[] array2 = {1, 2, 3, 4, 5};

		System.out.println(array[0]);
		System.out.println(array[1]);
		System.out.println(array[2]);
		System.out.println(array[3]);
		System.out.println(array[4]);

		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		array[3] = 40;
		array[4] = 50;

		int sum = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		System.out.println("합계: " + sum);

		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] array3;
		array3 = new int[10];
		//배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for(int i = 0; i< array3.length; i++){
			array3[i] = (int)(Math.random() * 100)+1;
		}
		System.out.println(Arrays.toString(array3));


		//배열에 저장된 모든값의 합계와 평균을 구해주세요
		int sum2 = 0;
		double avg = 0;
		for(int i = 0; i< array3.length; i++){
			sum2 += array3[i];
		}
		avg = (double)sum2/array3.length;

		System.out.println("합계: " + sum2+ " / 평균: " + avg);

		//배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.

		//최소값과 최대값을 저장할 변수를 만들고 0번 인덱스의 값을 저장한다.

		//배열의 모든값을 비교하기 위해 0번인덱스부터 마지막 인덱스까지 반복한다.

		// 최소값의 배열의 모든 인덱스 값을 배교해 더 작은 값을 만나면 최소값으로 저장한다.

		// 최대값과 배열의 모든 인덱스 값을 비교해 더 큰 값을 만나면 최대값으로 저장한다.

		int min = array3[0];
		int max = array3[0];

		for(int i = 0; i < array3.length; i++){
			if(min >= array3[i]){
				min = array3[i];
			}
			if(max <= array3[i]){
				max = array3[i];
			}
		}
		System.out.println("최소값: " + min + " / 최대값: " + max);

		int[] shuffle = new int[10];
		for(int i = 0; i < shuffle.length; i++){
			shuffle[i] = i + 1;
		}
		System.out.println(Arrays.toString(shuffle));

		//배열의 값을 섞어주세요.

		//0~9사이의 랜덤한 인덱스를 발생시킨다.

		//0번 인덱스의 값과 랜덤한 인덱스의 값을 바꾼다.

		int a = 0;
		for(int i = 0; i 
				< 10; i++){
			int index = (int)(Math.random() *shuffle.length);
			a = shuffle[0];
			shuffle[0] = shuffle[index];
			shuffle[index] = a;
		}
		System.out.println(Arrays.toString(shuffle));

		//1~10 사이의 랜덤값을 500번 생성하고, 각 숫자가 생성된 횟수를 출력해주세요.
		/*int[] array4 = new int[500];
		int[] count = new int[10];
		int sum3 = 0;
		for(int i = 0; i < array4.length; i ++){
			array4[i] = (int)(Math.random() * 10)+1;
			for(int j = 0; j < count.length; j++){
				if(array4[i]==j+1){
					count[j]++;
				}
			}	
		}

		for(int i = 0; i < 10; i++){
			System.out.println(i+1 + "의 횟수는 "+count[i]);
			System.out.println(sum3 += count[i]);
		}*/
		//위 문제의 최소값, 최대값, 발생횟수를 입력받아 각 숫자가 생성된 횟수를 출력해주세요.
		Scanner s = new Scanner(System.in);
		int minsc = 0;
		int maxsc = 0;
		int indexsc = 0;

		System.out.print("최소값을 입력해주세요>");
		minsc = Integer.parseInt(s.nextLine());

		do{
			System.out.print("최대값을 입력해주세요>");
			maxsc = Integer.parseInt(s.nextLine());
			if(maxsc <= minsc){
				System.out.println("최대값이 최소값보다 작거나 같습니다.");
			}
		}while(maxsc <= minsc); 

		System.out.print("발생횟수를 입력해주세요>");
		indexsc = Integer.parseInt(s.nextLine());

		int[] random = new int[indexsc];
		int[] count = new int[maxsc-minsc+1];
		int rsum = 0;
		for(int i = 0; i < random.length; i ++){
			random[i] = (int)(Math.random() * (maxsc-minsc+1))+minsc; //(int)(Math.random() * (최대값-최소값+1))+최소값
			for(int j = 0; j < count.length; j++){
				if(random[i]==j+minsc){
					count[j]++;
				}
			}	
		}
		int[] counts = new int[maxsc-minsc+1];
		for(int i = 0; i < indexsc; i ++){
			int random2 =(int)(Math.random() * (maxsc-minsc+1))+minsc;
			counts[random2 - minsc]++;
		}

		for(int i = 0; i < count.length; i++){
			System.out.println(i+minsc + "의 횟수는 "+count[i]);
			System.out.println(i+minsc + "의 횟수는 "+counts[i]);
			rsum += count[i];
		}
		
	}

}
