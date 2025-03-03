package controller;

import java.util.Map;

import service.BoardService;
import service.UserService;
import util.ScanUtil;
import util.View;

public class Controller {
	public static void main(String[] args) {
		/*
		 * 발표순서 : 조 소개 > 주제 소개 > 주제 선정 배경 > 메뉴 구조 > 시연
		 * 발표인원 : 발표자 1명, ppt 및 시연 도우미 1명
		 * 
		 * Controller : 화면 이동
		 * Service : 화면 기능
		 * Dao : 쿼리작성
		 */
		
		new Controller().start();
	}
	
	public static Map<String, Object> loginUser;
	
	private UserService userService = UserService.getInstance();
	private BoardService boardService = BoardService.getInstance();
	
	private void start() {
		int view = View.HOME;
		
		while (true) {
			switch (view) {
			case View.HOME: view = home(); break;
			case View.LOGIN: view = userService.login(); break;
			case View.JOIN: view = userService.join(); break;
			case View.BOARD_LIST: view = boardService.boardList(); break;
			case View.BOARD_VIEW: view = boardService.BoardView(); break;
			case View.BOARD_INSERT_FORM: view = boardService.BoardInsert(loginUser); break;
			case View.BOARD_UPDATE_FORM: view = boardService.BoardUpdate(loginUser); break;
			case View.BOARD_DELETE_FORM: view = boardService.BoardDelete(loginUser); break;
			
			}
		}
	}
	
	private int home() {
		System.out.println("---------------------------------------");
		System.out.println("1.로그인\t2.회원가입\t0.프로그램 종료");
		System.out.println("---------------------------------------");
		System.out.print("번호 입력>");
		
		int input = ScanUtil.nextInt();
		
		switch (input) {
		case 1: return View.LOGIN; 
		case 2: return View.JOIN; 
		case 0:
			System.out.println("프로그램이 종료되었습니다.");
			System.exit(0);
			break;
		}
		return View.HOME;
	}
	
}
