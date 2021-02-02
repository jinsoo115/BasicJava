package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class BoardDao {
	private static BoardDao instance;
	private BoardDao(){}
	public static BoardDao getInstance() {
		if(instance == null){
			instance = new BoardDao();
		}
		return instance;
	}
	
	private JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String, Object>> selectBoardList(){
		String sql = "SELECT A.BOARD_NO, A.TITLE, A.CONTENT, B.USER_NAME, A.REG_DATE "
				+ "FROM TB_JDBC_BOARD A "
				+ "LEFT OUTER JOIN TB_JDBC_USER B "
				+ "ON A.USER_ID = B.USER_ID "
				+ "ORDER BY A.BOARD_NO DESC";
		return jdbc.selectList(sql);
	}
	
	public Map<String, Object> selectBoardView(int currentBoardNo){
		String sql = "SELECT A.BOARD_NO, B.USER_NAME, A.REG_DATE, A.TITLE, A.CONTENT "
				+ "FROM TB_JDBC_BOARD A "
				+ "LEFT OUTER JOIN TB_JDBC_USER B "
				+ "ON A.USER_ID = B.USER_ID "
				+ "WHERE A.BOARD_NO = ?";
		List<Object> param = new ArrayList<>();
		param.add(currentBoardNo);
		
		return jdbc.selectOne(sql, param);
	}
	
	public int insertBoard(String title, String content, Map<String, Object> loginUser){
		String sql ="insert into tb_jdbc_board "
				+ "values((select NVL(MAX(board_no),0)+1 from tb_jdbc_board),?,?,?,sysdate)";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(loginUser.get("USER_NAME"));
		return jdbc.update(sql, param);
		
	}
	public int updateBoard(String title, String content, int currentBoardNo, Map<String, Object> loginUser){
		String sql = "update tb_jdbc_board "
				+ "set title = ?, content = ? "
				+ "where board_no = ?"
				+ "AND USER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(title);
		param.add(content);
		param.add(currentBoardNo);
		param.add(loginUser.get("USER_ID"));
		return jdbc.update(sql, param);
		
	}
	public int deleteBoard(int currentBoardNo, Map<String, Object> loginUser){
		String sql = "DELETE FROM TB_JDBC_BOARD "
				+ "WHERE BOARD_NO = ? "
				+ "AND USER_ID = ?";
		List<Object> param = new ArrayList<>();
		param.add(currentBoardNo);
		param.add(loginUser.get("USER_ID"));
		return jdbc.update(sql, param);
		
	}
}
