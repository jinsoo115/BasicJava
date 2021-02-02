package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import controller.Controller;
import util.ScanUtil;
import util.View;
import dao.BoardDao;

public class BoardService {

	private static BoardService instance;
	private BoardService(){}
	public static BoardService getInstance() {
		if(instance == null){
			instance = new BoardService();
		}
		return instance;
	}

	private BoardDao boardDao = BoardDao.getInstance();

	private int currentBoardNo;

	public int boardList(){
		List<Map<String, Object>> boardList = boardDao.selectBoardList();

		System.out.println("=============================");
		System.out.println("번호\t제목\t작성자\t작성일");
		System.out.println("------------------------------");
		for(int i = 0; i < boardList.size(); i++){
			Map<String, Object> board = boardList.get(i);
			System.out.println(board.get("BOARD_NO") + "\t"
					+ board.get("TITLE") + "\t"
					+ board.get("USER_NAME") + "\t"
					+ board.get("REG_DATE"));
		}
		System.out.println("=============================");
		System.out.println("1.조회\t2.등록\t0.로그아웃");
		System.out.print("입력>");

		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			System.out.print("게시글 번호 입력>");
			currentBoardNo = ScanUtil.nextInt();
			return View.BOARD_VIEW;
		case 2:
			return View.BOARD_INSERT_FORM;
		case 0:
			Controller.loginUser = null;
			return View.HOME;
		}
		return View.BOARD_LIST;
	}
	
	public int BoardView(){
		Map<String, Object> board = boardDao.selectBoardView(currentBoardNo);
		if(board==null){
			System.out.println("게시글이 없습니다.");
			return View.BOARD_LIST;
		}else{
			System.out.println("-------------------------------------");
			System.out.println("번호\t: " + board.get("BOARD_NO"));
			System.out.println("작성자\t: " + board.get("USER_NAME") );
			System.out.println("작성일\t: " + board.get("REG_DATE"));
			System.out.println("제목\t: " + board.get("TITLE"));
			System.out.println("내용\t: " + board.get("CONTENT"));
			System.out.println("-------------------------------------");
			System.out.print("1.수정\t2.삭제\t0.메인\n입력>");
		}
		
		int input = ScanUtil.nextInt();

		switch (input) {
		case 1:
			return View.BOARD_UPDATE_FORM;
		case 2:
			return View.BOARD_DELETE_FORM;
		case 0:
			break;
		}
		return View.BOARD_LIST;
	}
	
	public int BoardInsert(Map<String, Object> loginUser){
		System.out.print("제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		System.out.print("내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		int result = boardDao.insertBoard(title, content, loginUser);
		if(0 < result){
			System.out.println("게시글 등록 성공");
		}else{
			System.out.println("게시글 등록 실패");
		}
		return View.BOARD_LIST;
	}
	
	public int BoardUpdate(Map<String, Object> loginUser){
		System.out.print("제목을 입력하세요>");
		String title = ScanUtil.nextLine();
		System.out.print("내용을 입력하세요>");
		String content = ScanUtil.nextLine();
		int result = boardDao.updateBoard(title, content, currentBoardNo, loginUser);
		if(0 < result){
			System.out.println("수정 성공");
		}else{
			System.out.println("수정 실패");
		}
		return View.BOARD_LIST;
		
	}
	public int BoardDelete(Map<String, Object> loginUser){
		int result = boardDao.deleteBoard(currentBoardNo, loginUser);
		if(0 < result){
			System.out.println("삭제 성공");
		}else{
			System.out.println("삭제 실패");
		}
		return View.BOARD_LIST;
		
	}
}
