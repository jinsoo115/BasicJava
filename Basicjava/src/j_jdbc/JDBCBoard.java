package j_jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import e_oop.ScanUtil;

public class JDBCBoard {

	public static void main(String[] args) {
		/*
		 * 오라클 데이터베이스에 게시판 테이블을 생성하고, 게시판 프로그램을 만들어주세요.
		 * 테이블: TB_JDBC_BOARD
		 * 컬럼 : BOARD_NO, TITLE, CONTENT, USER_ID, REG_DATE
		 */

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "jinsu";
		String password = "java";

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		////////////////////////
		int board_no = 0;
		try {
			con = DriverManager.getConnection(url, user, password);
			String primary = "select NVL(MAX(board_no),0)+1 as board_no from tb_jdbc_board";
			ps = con.prepareStatement(primary);
			rs = ps.executeQuery();
			while(rs.next()){
				board_no =rs.getInt("board_no");  
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
		/////////////////////////
		try {
		while(true){
			System.out.println("-------------------------------------");
			System.out.println("번호\t제목\t작성자\t작성일");
			System.out.println("-------------------------------------");
			////////////////////////////////////
			String sql = "select * from tb_jdbc_board order by board_no desc";
			con = DriverManager.getConnection(url, user, password);
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				System.out.print(rs.getObject("Board_no") + "\t");
				System.out.print(rs.getObject("title") + "\t");
				System.out.print(rs.getObject("user_id") + "\t");
				System.out.print(rs.getObject("reg_date") + "\t");
				System.out.println();
			}
/////////////////////////////////////////////////
			System.out.println("-------------------------------------");
			System.out.println("1.조회\t2.등록\t3.종료");
			System.out.print("입력>");
			int input = ScanUtil.nextInt();

			switch (input) {
			case 1:
				read(con, ps, rs);
				break;
			case 2:
				insert(board_no, con, ps);
				break;
			case 3:
				System.exit(3);
				break;
			}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
		

	}

	private static void read(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			System.out.print("게시글 번호 입력>");
			int select = ScanUtil.nextInt();
			String read = "select * from tb_jdbc_board where board_no = ?";
			ps = con.prepareStatement(read);
			ps.setObject(1, select);
			rs = ps.executeQuery();
			
			System.out.println("-------------------------------------");
			while(rs.next()){
				System.out.println("번호\t: " + rs.getObject("board_no"));
				System.out.println("작성자\t: " + rs.getObject("user_id") );
				System.out.println("작성일\t: " + rs.getObject("reg_date"));
				System.out.println("제목\t: " + rs.getObject("title"));
				System.out.println("내용\t: " + rs.getObject("content"));
			}
			System.out.println("-------------------------------------");
			System.out.print("1.수정\t2.삭제\t0.메인\n입력>");
			int input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				update(select, con, ps);
				break;
			case 2:
				delete(select, con, ps);
				break;
			case 0:
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) try{rs.close();} catch(Exception e) {}
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}



	private static void delete(int select, Connection con,PreparedStatement ps) {
		try {
			String delete = "delete from tb_jdbc_board where board_no = ?";
			ps = con.prepareStatement(delete);
			ps.setObject(1, select);
			int result = ps.executeUpdate();
			System.out.println("변경된 ROW : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}

	}

	private static void update(int select, Connection con, PreparedStatement ps) {
		try {
			String update = "update tb_jdbc_board set title = ?, content = ? where board_no = ?";
			ps = con.prepareStatement(update);
			System.out.print("수정할 제목을 입력하세요>");
			String title = ScanUtil.nextLine();
			System.out.print("수정할 내용을 입력하세요>");
			String content = ScanUtil.nextLine();
			ps.setObject(1, title);
			ps.setObject(2, content);
			ps.setObject(3, select);
			int result = ps.executeUpdate();
			System.out.println("변경된 ROW : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}

	private static void insert(int board_no, Connection con, PreparedStatement ps) {
		try {
			String insert = "insert into tb_jdbc_board values(?,?,?,?,sysdate)";
			ps = con.prepareStatement(insert);
			System.out.print("제목을 입력하세요>");
			String title = ScanUtil.nextLine();
			System.out.print("내용을 입력하세요>");
			String content = ScanUtil.nextLine();
			System.out.print("이름을 입력하세요>");
			String user_id = ScanUtil.nextLine();

			ps.setObject(1, board_no);
			ps.setObject(2, title);
			ps.setObject(3, content);
			ps.setObject(4, user_id);
			int result = ps.executeUpdate();
			System.out.println("변경된 ROW : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(ps != null) try{ps.close();} catch(Exception e) {}
			if(con != null) try{con.close();} catch(Exception e) {}
		}
	}
}
