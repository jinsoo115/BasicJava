package i_collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class Board {

	public static void main(String[] args) {
		/*
		 * ArrayList와 HashMap을 사용해 게시판 테이블을 만들고,
		 * 조회, 등록, 수정, 삭제가 가능한 게시판을 만들어주세요.
		 * 
		 * 번호(PK), 제목, 내용, 작성자, 작성일
		 * 
		 * 
		 * -------------------------------------
		 * 번호	제목		작성자	작성일
		 * -------------------------------------
		 * 4	안녕하세요	홍길동	12/15
		 * 3	안녕하세요	홍길동	12/15
		 * 2	안녕하세요	홍길동	12/15
		 * 1	안녕하세요	홍길동	12/15
		 * -------------------------------------
		 * 1.조회		2.등록	3.종료
		 */
		ArrayList<HashMap<String, Object>> boardTable = new ArrayList<>();
		int board_no=1;
		while(true){
			System.out.println("-------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------");
			for(int i = boardTable.size()-1; i >= 0 ; i--){
				HashMap<String, Object> hashMap = boardTable.get(i);
				System.out.print(hashMap.get("board_no")+"\t");
				System.out.print(hashMap.get("title")+"\t");
				System.out.print(hashMap.get("user")+"\t");
				System.out.print(hashMap.get("date")+"\t");
				System.out.println();
			}
			System.out.println("-------------------------------------");
			System.out.println("1.조회\t2.등록\t3.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				read(boardTable);
				break;
			case 2:
				insert(board_no, boardTable);
				board_no++;
				break;
			case 3:
				System.exit(3);
				break;
			}
		}
	}
	static void read(ArrayList<HashMap<String, Object>> boardTable){
		System.out.print("게시글번호입력>");
		String select = ScanUtil.nextLine();
		for(int i = 0; i < boardTable.size(); i++){
			HashMap<String, Object> temp = boardTable.get(i);
			if(!temp.get("board_no").equals(select) && i ==boardTable.size()){
				System.out.println("없는번호입니다");
				break;
			}else if(temp.get("board_no").equals(select)){
				System.out.println("-------------------------------------");
				System.out.println("번호\t: " + temp.get("board_no"));
				System.out.println("작성자\t: " + temp.get("user"));
				System.out.println("작성일\t: " + temp.get("date"));
				System.out.println("제목\t: " + temp.get("title"));
				System.out.println("내용\t: " + temp.get("content"));
				System.out.println("-------------------------------------");
				System.out.print("1.수정\t2.삭제\t0.메인\n입력>");
				int input = ScanUtil.nextInt();
				switch (input) {
				case 1:
					
					update(temp);
					break;
				case 2:
					delete(boardTable, temp);
					break;
				case 0:
					break;
				}
			}
		}
	}
	static void update(HashMap<String, Object> temp){
		System.out.print("수정할 제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		System.out.print("수정할 내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		temp.put("content", content);
		temp.put("title", title);
	}
	static void delete(ArrayList<HashMap<String, Object>> boardTable, HashMap<String, Object> temp){
		for(int i = 0; i < boardTable.size(); i++){
			if(boardTable.get(i).get("board_no").equals(temp.get("board_no"))){
				boardTable.remove(i);
				break;
			}

		}
	}
	static void insert(int board_no, ArrayList<HashMap<String, Object>> boardTable){
		HashMap<String, Object> board = new HashMap<>();
		board.put("board_no", Integer.toString(board_no));
		System.out.print("제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		board.put("title", title);
		System.out.print("내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		board.put("content", content);
		System.out.print("이름을 입력하세요>");
		String user = ScanUtil.nextLine();
		board.put("user", user);
		board.put("date", new Date());
		boardTable.add(board);
	}

}
