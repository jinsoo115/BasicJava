package i_collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import d_array.Sort;

public class ArrayListClass {
	public static void main(String[] args) {
		/*
		 * boolean add(Object obj) : 마지막 위치에 객체를 추가 후 성공여부를 반환한다.
		 * void add(int index, Object obj) : 지정된 위치에 객체를 추가한다.
		 * Object set(int index, Object obj) : 지정된 위치에 객체를 저장 후 기존 객체를 반환한다.
		 * Object get(int index) : 지정된 위치의 객체를 반환한다.
		 * int size() : 저장된 객체의 수를 반환한다.
		 * boolean remove(int index) : 지정된 위치에 객체를 제거한다.
		 */
		
		ArrayList sample = new ArrayList();
		
		sample.add("abc");
		sample.add(100);
		sample.add(new Scanner(System.in));
		System.out.println(sample);
		//제네릭을 지정하지 않으면 넣을때는 편하나 꺼낼때는 타입을 예측하기 힘들다.
		//따라서 제네릭의 사용이 권장된다.
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		ArrayList<String> lists = new ArrayList<>();
		lists.add("abc");
		list.add(20);
		System.out.println(list.add(30));
		System.out.println(list);
		
		list.add(1, 40);//1번 인뎃스부터 뒤로 밀고 값을 저장한다.
		System.out.println(list);
		
//		list.add(5,50);
		
		Integer before = list.set(2, 50);//2번 인덱스에 값을 저장하고 기존 값을 반환한다.
		System.out.println("before : " + before);
		System.out.println("after : " + list.get(2));
		System.out.println(list);
		
		Integer integer = list.get(2);
		System.out.println(integer);
		
//		for(int i = 0; i < list.size(); i++){
//			System.out.println(i + " : " + list.get(i));
//			
//			list.remove(i);
//		}
		
		for(int i = list.size()-1; 0 <= i; i--){
			System.out.println(i + " : " + list.get(i));
			list.remove(i);
		}
		System.out.println(list);
		
		/*
		 * Wrapper 클래스 : 기본형 타입을 객체로 사용해야 할때 대신 사용하는 클래스
		 * - boolean	: Boolean
		 * - char		: Character
		 * - byte		: Byte
		 * - short		: Short
		 * - int		: Integer
		 * - long		: Long
		 * - float		: Float
		 * - double		: Double
		 */
		
		ArrayList<Integer> li = new ArrayList<>();
		
		li.add(new Integer(10));
		li.add(10); //오토박싱 : 기본형타입이 wrapper클래스로 자동 변환
		
		Integer _integer = li.get(0);
		//int i = li.get(0); //언박싱 : wrapper클래스가 기본형타입으로 자동 변환
		//list에 1 ~ 100 사이의 랜덤값을 10개 저장해주세요.
		for(int j = 0; j < 10; j++){
			list.add((int)(Math.random() * 100)+1);
		}
		System.out.println(list);
		
		//list에 저장된 값을 합계와 편균을 구해주세요.
		int sum = 0;
		double avg = 0;
		for(int i = 0; i < list.size(); i++){
			sum += list.get(i);
		}
		avg = (double)sum/list.size();
		System.out.println("합계 : " + sum + "평균 : " + avg);
		
		//list에서 최소값과 최대값을 구해주세요.
		int max = list.get(0);
		int min = list.get(0);
		for(int i = 0; i <list.size(); i++){
			if(max < list.get(i)){
				max = list.get(i);
			}
			if(min > list.get(i)){
				min = list.get(i);
			}
		}
		System.out.println("최대값 : " + max + "최소값 : " + min);
		
		//list를 오름차순으로 정렬해주세요.
		
		for(int i = 0; i < list.size(); i++){
			for(int j = 0; j < list.size(); j++){
				if(list.get(i) < list.get(j)){
					int temp = list.set(i, list.get(j));
					list.set(j, temp);
					
					
				}
			}
		}
		Collections.sort(list);
		System.out.println(list);
		
		//2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
		
		ArrayList<Integer> _list = new ArrayList<>();
		_list.add(10);
		_list.add(20);
		_list.add(30);
		
		list2.add(_list);
		
		_list = new ArrayList<>();
		_list.add(40); 
		_list.add(50);
		
		list2.add(_list);
				
		System.out.println(list2);
		
		for(int i = 0; i < list2.size(); i++){
			ArrayList<Integer> tempList = list2.get(i);
			for(int j = 0; j < tempList.size(); j++){
				System.out.println(tempList.get(j) + "\t");
			}
			System.out.println();
		}
	}
}

