package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import e_oop.ScanUtil;

public class JDBCUBoard {
	static Object board_no = 0;
	static JDBCUtil jdbc = JDBCUtil.getInstance();
	static String sql="";
	public static void main(String[] args) {
		List<Map<String, Object>> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		/////////////////////////////////////////////
		sql = "select NVL(MAX(board_no),0)+1 as board_no from tb_jdbc_board";
		map = jdbc.selectOne(sql);
		board_no = map.get("BOARD_NO");
		//////////////////////////////////////////////
		while(true){
			System.out.println("-------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------");
			sql = "select Board_no, title, user_id, reg_date "
					+ "from tb_jdbc_board "
					+ "order by board_no desc";
			list = jdbc.selectList(sql);
			for(int i = 0; i < list.size(); i++){
				System.out.print(list.get(i).get("BOARD_NO") + "\t");
				System.out.print(list.get(i).get("TITLE") + "\t");
				System.out.print(list.get(i).get("USER_ID") + "\t");
				System.out.print(list.get(i).get("REG_DATE") + "\t");
				System.out.println();
			}
			System.out.println("-------------------------------------");
			System.out.println("1.조회\t2.등록\t3.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				read();
				break;
			case 2:
				insert();
				break;
			case 3:
				System.exit(3);
				break;
			}
			
		}


	}



	private static void read() {
		System.out.print("게시글 번호 입력>");
		int select = ScanUtil.nextInt();
		List<Object> param = new ArrayList<>();
		sql = "select * from tb_jdbc_board where board_no = ?";
		System.out.println("-------------------------------------");
		Map<String, Object> map = new HashMap<>();
		
		map = jdbc.selectOne(sql, param);
		System.out.println("번호\t: " + map.get("BOARD_NO"));
		System.out.println("작성자\t: " + map.get("USER_ID") );
		System.out.println("작성일\t: " + map.get("REG_DATE"));
		System.out.println("제목\t: " + map.get("TITLE"));
		System.out.println("내용\t: " + map.get("CONTENT"));
		
		System.out.println("-------------------------------------");
		System.out.print("1.수정\t2.삭제\t0.메인\n입력>");
		int input = ScanUtil.nextInt();
		switch (input) {
		case 1:
			update(select);
			break;
		case 2:
			delete(select);
			break;
		case 0:
			break;
		}
	}
	


	private static void delete(int select) {
		sql = "delete from tb_jdbc_board where board_no = ?";
		List<Object> param = new ArrayList<>();
		param.add(select);
		int delete = jdbc.update(sql, param);
		System.out.println("변경된 ROW : " + delete);
	}
	
	private static void update(int select) {
		sql = "update tb_jdbc_board set title = ?, content = ? where board_no = ?";
		List<Object> param = new ArrayList<>();
		System.out.print("수정할 제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		System.out.print("수정할 내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		param.add(title);
		param.add(content);
		param.add(select);
		int update = jdbc.update(sql, param);
		System.out.println("변경된 ROW : " + update);
	}
	
	private static void insert() {
		System.out.print("제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		System.out.print("내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		System.out.print("이름을 입력하세요>");
		String user_id = ScanUtil.nextLine();
		sql = "insert into tb_jdbc_board values(?,?,?,?,sysdate)";
		List<Object> param = new ArrayList<>();
		param.add(board_no);
		param.add(title);
		param.add(content);
		param.add(user_id);
		int result = jdbc.update(sql, param);
		System.out.println("변경된 ROW : " + result);

	}
	
}
