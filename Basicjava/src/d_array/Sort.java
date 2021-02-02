package d_array;

import java.util.Arrays;

public class Sort {

	public static void main(String[] args) {
		/*
		 * 정렬
		 * - 석차구하기 : 정수를 비교해 작은 정수의 등수를 증가시키는 방식
		 * - 선택정렬 : 가장 적은 숫자를 찾아서 앞으로 보내는 방식
		 * - 버블정렬 : 바로 위의 숫자와 비교해서 큰 수를 뒤로 보내는 방식
		 * - 삽입정렬 : 두번째 숫자부터 앞의 숫자들과 비교해서 큰수는 뒤로 밀고 중간에 삽입하는 방식
		 */

		int[] arr = new int[10];

		for(int i = 0; i<arr.length; i++){
			arr[i] = (int)(Math.random() * 100) + 1;
		}
		System.out.println(Arrays.toString(arr));
		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
		
		//삽입정렬
		//두번쨰 숫자를 변수에 저장한다.
		//앞의 숫자와 비교해서 큰수를 만나면 한칸뒤로 보낸다.
		//작은수를 만나면 작은수의 바로 뒷칸에 변수의 값을 저장하고 반복문을 빠져나간다.
//		for(int i = 1; i < arr.length; i++){
//			int temp = arr[i];
//			for(int j = i - 1; j >= 0 ; j--){
//				if(temp < arr[j]){
//					arr[j+1] = arr[j];
//				}
//				if(temp > arr[j]){
//					arr[j+1] = temp;
//					break;
//				}
//			}
//
//		}
//		System.out.println(Arrays.toString(arr));

		//버블정렬
//		for(int i = 0; i < arr.length-1; i++){
//			boolean flag = false;
//			
//			for(int j = 0; j < arr.length-1 - i; j++){
//				if(arr[j] > arr[j+1]){
//					int temp = arr[j];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//					flag = true;
//				}
//			}
//			
//			if(!flag){
//				break;
//			}
//		}
//		System.out.println(Arrays.toString(arr));




		//선택정렬
//		int min=0;
//		for(int i = 0; i < arr.length-1; i++){
//			//min = i;
//			for(int j = i+1; j < arr.length; j++){
//				if(arr[j] < arr[min]){
//					min = j;	
//				}
//			}
//			int temp = arr[i];
//			arr[i] = arr[min];
//			arr[min] = temp;
//
//		}
//		System.out.println(Arrays.toString(arr));



		//석차구하기
				int[] rank = new int[arr.length];
				for(int i = 0; i< rank.length; i++){
					rank[i] =1;
				}
				for(int i = 0; i < arr.length; i++){
					for(int j = 0; j < arr.length; j++){
						if(arr[i] < arr[j]){
							rank[i]++;
						}
					}
				}
				System.out.println(Arrays.toString(rank));


	}

}
