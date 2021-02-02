package i_collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class HashMapClass {
	public static void main(String[] args) {
		/*
		 * Object put(Object key, Object value) : 지정된 키와 값을 저장한다.
		 * Object remove(Object key) : 지정된 키로 저장된 값을 제거한다.
		 * Object get(Object key) : 지정된 키의 값(없으면 null)을 반환한다.
		 * Set keySet() : 저장된 모든 키를 Set으로 반환한다.
		 */
		
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("a", 10);
		map.put("b", "홍길동");
		map.put("c", new Scanner(System.in));//map은 순서가 존재하지 않는다.
		
		System.out.println(map);
		
		map.put("b", "이순신"); //덮어쓴다.
		System.out.println(map);
		
		map.remove("c");//삭제
		System.out.println(map);
		
		
		Object value = map.get("b");
		System.out.println(value);
		
		int value1 = (Integer)map.get("a"); //형변환 하여 반환시킬수 있다.
		String value2 = (String)map.get("b");
		System.out.println(map);
		
		//keySet은 map에 저장된 모든 값을 저장 하거나 map에 저장된 키를 모를때
		Set<String> keys = map.keySet();//저장된 모든 키
		for(String key : keys){//keys에 있는 값을 한개씩 key변수에 저장하며 for문을 돌림
			System.out.println(key + " : " + map.get(key));
			System.out.println(System.identityHashCode(key));
		}
		//HashMap을 이용해 DB의 한개 행(ROW)를 출력가능
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i : list){
			
		}
		
		//회원테이블
		//아이디, 비밀번호, 이름, 전화번호
		/*
		 * id		password	name	tel
		 * admin	admin123	관리자	010-1234-5678
		 */
		HashMap<String, String> user = new HashMap<>();
		user.put("id", "admin");
		user.put("password", "admin123");
		user.put("name", "관리자");
		user.put("tel", "010-1234-5678");
		
		System.out.println(user);
		
		ArrayList<HashMap<String, String>> table = new ArrayList<>();
		table.add(user);
		System.out.println(table);
		user = new HashMap<>();
		user.put("id", "jinsu");
		user.put("password", "jinsu123");
		user.put("name", "사용자");
		user.put("tel", "010-9876-5432");
		table.add(user);
		System.out.println(table);
		for(HashMap<String, String> hashMap : table){
			Set<String> users = hashMap.keySet();
			for(String key : users){
				System.out.println(hashMap.get(key));
			}
		}
		
		
		for(int i = 0; i < table.size(); i++){
			HashMap<String, String> hashMap = table.get(i);
			Set<String> keySet = hashMap.keySet();
			for(String key : keySet){
				System.out.println(key + " : " + hashMap.get(key));
			}
		}
		
	}
	
}
