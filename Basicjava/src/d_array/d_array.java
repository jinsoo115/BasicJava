package d_array;

import java.util.Arrays;

public class d_array {

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

		//10개의 정수를 저장할 수 있는 배열을 선언 및 초기화 해주세요.
		int[] array;
		array = new int[10];

		//배열의 모든 인덱스에 1~100사이의 랜덤한 값을 저장해주세요.
		for(int i = 0; i < array.length; i ++){
			array[i] = (int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(array));

		//배열에 저장된 모든값의 합계와 평균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < array.length; i++){
			sum += array[i];
		}
		avg = (double)sum/array.length;
		System.out.println("sum: " + sum + " / avg: " + avg);
		
		// 배열에 저장된 값들 중 최소값과 최대값을 출력해주세요.
		// 최소값과 최대값을 저장할 변수를 만들고 0번 인덱스의 값을 저장한다.
		// 배열의 모든값을 비교하기 위해 0번인덱스부터 마지막 인덱스까지 반복한다.
		// 최소값의 배열의 모든 인덱스 값을 배교해 더 작은 값을 만나면 최소값으로 저장한다.
		// 최대값과 배열의 모든 인덱스 값을 비교해 더 큰 값을 만나면 최대값으로 저장한다.		
		int min = array[0];
		int max = array[0];
		for(int i = 0; i < array.length; i++){
			if(min>array[i]){
				min = array[i];
			}
			if(max<array[i]){
				max = array[i];
			}
		}
		System.out.println("min: " + min + " / max: " + max);
		
		// 배열의 값을 섞어주세요.		
		// 0~9사이의 랜덤한 인덱스를 발생시킨다.		
		// 0번 인덱스의 값과 랜덤한 인덱스의 값을 바꾼다
		for(int i = 0; i<100; i++){
			int index = (int)(Math.random()*10);
			int temp = array[0];
			array[0] = array[index];
			array[index] = temp;
		}
		System.out.println(Arrays.toString(array));
	}

}
