package d_array;

import java.util.Arrays;

public class Quiz {

	public static void main(String[] args) {
		//거스름돈 동전 갯수
		int money = (int)(Math.random() * 500) * 10;
		int[] coin = {500, 100, 50, 10};
		
		/*
		 * 거스름돈에 동전이 단위마다 몇개의 동전이 필요한지 출력해주세요.
		 * 
		 * 거스름돈 : 2860원
		 * 500원 : 5개
		 * 100원 : 3개
		 * 50원 : 1개
		 * 10원  : 1개
		 */
		System.out.println("거스름돈 : " + money + "원");
		//int[] count = new int[4];//int[] count = {0,0,0,0};
		
		for(int i = 0; i < coin.length; i++){
			//count[i] += money / coin[i];
			System.out.println(coin[i] + "원 : " + money / coin[i] + "개");
			money = money % coin[i]; 
			//System.out.println(coin[i] + "원 : " + count[i] + "개");
		}
		
		//그래프 그리기
		int[] arr = new int[10];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 5) +1;
		}
		System.out.println(Arrays.toString(arr));
		/*
		 * 1~5의 숫자가 발생된 만큼 *을 사용해 그래프를 그려주세요.
		 * 
		 * 1 : *** 3
		 * 2 : **** 4
		 * 3 : ** 2
		 * 4 : ***** 5
		 * 5 : * 1
		 */
		
		for(int i = 0; i < 5; i++){
			int count = 0;
			System.out.print(i+1 + " : ");
			for(int j = 0; j < arr.length; j++){
				if(arr[j] == i+1){
					System.out.print("*");
					count++;
				}
			}
			System.out.println(" " + count);
		}
		
//		int[] count = new int[5]; 
//		for(int i = 0; i < arr.length; i++){
//			count[arr[i]-1]++;			
//		}
//		for(int i = 0; i < count.length; i++){
//			System.out.print(i+ 1 + " : ");
//			for(int j = 0; j < count[i]; j++){
//				System.out.print("*");
//			}
//			System.out.println(" " + count[i]);
//		}
		
		/*
		 * 1~5사이의 랜덤한 값이 10개 저장된 배열에서 중복된 값이 제거된 배열을 만들어 주세요.
		 * [1, 3, 3, 2, 1, 4, 5, 5, 1, 3]
		 * [1, 3, 2, 4, 5] 
		 */
		
		int[] temp = new int[5];
		int count = 0;

		for(int i = 0; i < arr.length; i++){
			boolean flag = false;
			for(int j = 0; j < temp.length; j++){
				if(arr[i]==temp[j]){
					flag = true;
				}
			}
			if(!flag){
				temp[count++]=arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		int[] result = new int[count];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
		
		
		//나누어 떨어지는 숫자 배열
		arr = new int[100];
		for(int i = 0; i < arr.length; i ++){
			arr[i] = (int)(Math.random() * 100) +1;
		}
		System.out.println(Arrays.toString(arr));
		
		/*
		 * 2~5사이의 랜덤한 수로 나누어 떨어지는 숫자로만 이루어진 배열을 정렬하여 출력해주세요.
		 * 5
		 * [5, 10, 15, 20, 25....]
		 */
		int random = (int)(Math.random() * (5-2+1)) + 2;
		temp = new int[100];
		int index = 0;
		
		for(int i = 0; i < arr.length; i++){
			if(arr[i] % random == 0){
				temp[index++] = arr[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		
		result = new int[index];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
		
//		for(int i =0; i < result.length-1; i++){
//			int min = i;
//			for(int j = i+1; j < result.length; j++){
//				if(result[i] < arr[min]){
//					min=j;
//				}
//			}
//			int tmp = result[i];
//			result[i] = result[min];
//			result[min] = tmp;
//		}
		
		int min = 0;
		for(int i = 0; i < result.length-1; i++){
			for(int j = i+1; j < result.length; j++){
				if(result[i] > result[j]){
					min = result[i];
					result[i] = result[j];
					result[j] = min; 
				}
			}
		}
		System.out.println(Arrays.toString(result));
		
		temp = new int[index];
		index=0;
		for(int i = 0; i < result.length; i++){
			boolean flag = false;
			for(int j = 0; j < temp.length; j++ ){
				if(result[i] == temp[j]){
					flag=true;
				}
			}
			if(!flag){
				temp[index++]=result[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		result = new int[index];
		for(int i = 0; i < result.length; i++){
			result[i] = temp[i];
		}
		System.out.println(Arrays.toString(result));
		
	}

}
