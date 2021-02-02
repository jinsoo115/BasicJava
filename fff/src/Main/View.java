package Main;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

import service.*;
import DataBase.Dbclass;
import VO.BannerVO;
import VO.CategoryVO;
import VO.ItemVO;
import VO.MemberProductVO;
import VO.MemberVO;
import VO.MessageVO;
import VO.MyBuyView;
import VO.MyCellView;
import VO.MyItemView;

public class View {
	private Service service = new Imservice();
	String input; // 각각 switch문에 들어가기 위해 문자열로 선언
	Scanner sc = new Scanner(System.in);
	private MemberVO loginMember = null; // 로그인시 누구인지 판별
	int in;
	/**
	 * 화면전환 할때마다 보여줄 상단바
	 * 
	 */
	private void showBar(String str) {
		System.out.println();
		System.out.println("┌─────────────────────────────────────┐");
		System.out.println("\t\t" + str);
		System.out.println("└─────────────────────────────────────┘");
		System.out.println();
	}
	/**
	 * 메인에서 호출될 함수
	 */
	public void view() {
		while (true) {
			String str = "메인화면";
			showBar(str);
			System.out.println("1.회원가입");
			System.out.println("2.로그인");
			System.out.println("3.종료");
			System.out.print("무엇을 도와드릴까요 : ");
			input = sc.nextLine();
			switch (input) {
			case "1":
				signUp();
				break;
			case "2":
				login();
				break;
			case "3":
				System.exit(0);
				break;
			}
		}
	}

	/**
	 * 회원가입 메서드
	 */
	private void signUp() {
		MemberVO mv = new MemberVO();
		String mem_id = inputId(); // 회원 아이디
		String mem_pw = inputPw(); // 회원 패스워드
		String mem_name = inputName(); // 회원 이름
		String mem_phone = inputPhone(); // 회원 핸드폰번호
		String mem_birth = inputBirth(); // 회원 생년월일
		System.out.println("!!회원가입 완료!!");
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("mem_id", mem_id);
		/**
		 * 회원가입메서드
		 * boolean memberInser(Map<String, String> params);
		 */
		mv.setMem_id(mem_id);
		mv.setMem_pw(mem_pw);
		mv.setMem_name(mem_name);
		mv.setMem_phone(mem_phone);
		mv.setMem_birth(mem_birth);
		service.memberInsert(mv);
	}

	/**
	 * 회원가입 생일 입력받는 창
	 * 
	 * @return
	 */
	private String inputBirth() {
		String mem_birth = null;
		while (true) {
			System.out.print("(yyyy-mm-dd)생년월일 입력 : ");
			mem_birth = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regBirth(mem_birth);
			if (result == false) {
				System.out.print("(yyyy-mm-dd)양식에 맞게 입력해주세요.");
				continue;
			} else {
				break;
			}
		}
		return mem_birth;
	}

	/**
	 * 회원가입 핸드폰번호 입력받는 창
	 * 
	 * @return
	 */
	private String inputPhone() {
		String mem_phone = null;
		while (true) {
			System.out.print("phone : ");
			mem_phone = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regPhone(mem_phone);
			if (result == false) {
				System.out.println("(000-0000-0000)양식에 맞춰 주세요");
				continue;
			} else {
				break;
			}
		}
		return mem_phone;
	}

	/**
	 * 회원가입 이름 입력받는 창
	 * 
	 * @return
	 */
	private String inputName() {
		String mem_name = null;
		while (true) {
			System.out.print("(2~5한글)이름 : ");
			mem_name = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regName(mem_name);
			if (result == false) {
				System.out.println("이름은 2~5자리 이어야 한다.");
				continue;
			} else {
				break;
			}
		}
		return mem_name;
	}

	/**
	 * 회원가입 아이디 입력받는 창
	 * 
	 * @return
	 */
	private String inputId() {
		String mem_id = null;
		while (true) {
			System.out.print("ID : ");
			mem_id = sc.nextLine();
			// 정규식 체크
			boolean result = RegEx.regId(mem_id);
			if (result == false) {
				System.out.println("아이디는 4~10자리 이어야 한다.");
				continue;
			} else {
				if (service.iDcheck(mem_id) == true) {
					System.out.println("중복된 ID입니다.");
					continue;
				} else {
					break;
				}
			}
		}
		return mem_id;
	}

	/**
	 * 회원가입 비밀번호를 입력받는 창
	 * 
	 * @return
	 */
	private String inputPw() {
		String mem_pw = null;
		while (true) {
			System.out.print("PW : ");
			mem_pw = sc.nextLine();
			boolean result = RegEx.regPw(mem_pw);
			if (result == false) {
				System.out.println("비밀번호는 4~10자리 이어야 한다.");
				continue;
			} else {
				break;
			}
		}
		return mem_pw;
	}

	/**
	 * 로그인 화면 메서드
	 */
	private void login() {
		showBar("로그인");
		String mem_id = "";
		String mem_pw = "";
		while (!input.toLowerCase().equals("main")
				&& !input.toLowerCase().equals("q")) {
			Map<String, String> login = new HashMap<String, String>();
			System.out.print("ID : ");
			mem_id = sc.nextLine();
			System.out.print("PW : ");
			mem_pw = sc.nextLine();
			login.put("mem_id", mem_id);
			login.put("mem_pw", mem_pw);
			loginMember = service.logIn(login);
			if (loginMember == null) {
				System.out.println("다시 입력하세요");
				continue;
			}
			if (loginMember.isAdmin() == true) {
				admin();
			} else if (loginMember.isLimit() == true) {
				member();
			}
		}
	}

	/**
	 * 관리자 화면 메서드
	 */
	private void admin() {
		while (!input.toLowerCase().equals("main")) {
			showBar("관리자메인");
			System.out.println("1. 회원관리");
			System.out.println("2. 광고관리");
			System.out.println("3. 카테고리관리");
			System.out.println("4. 아이템관리");
			System.out.println("5. 게시판관리");
			System.out.println("나가기(Q/q)");
			System.out.println();
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				memberManagement();
				break;
			case "2":
				bannerManagement();
				break;
			case "3":
				categoryManagement();
				break;
			case "4":
				itemManagement();
				break;
			case "5":
				noticeboard();
				break;
			default:

			}
		}

	}


	/**
	 * 아이템관리 메서드
	 */
	private void itemManagement() {
		while (!input.toLowerCase().equals("main")) {
			showBar("아이템관리");
			System.out.println("1.아이템조회");
			System.out.println("2.아이템수정");
			System.out.println("3.아이템삭제");
			System.out.println("나가기(Q/q)");
			System.out.print("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				itemShow();
				break;
			case "2":
				itemUpdate();
				break;
			case "3":
				itemDelete();
				break;
			default:
				System.out.println("다시입력해주세요.");
			}
		}
	}

	/**
	 * 카테고리관리 메서드
	 */
	private void categoryManagement() {
		while (!input.toLowerCase().equals("main")) {
			showBar("카테고리관리");
			System.out.println("1.카테고리조회");
			System.out.println("2.카테고리수정");
			System.out.println("3.카테고리삭제");
			System.out.println("4.카테고리추가");
			System.out.println("나가기(Q/q)");
			System.out.println("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				cateShow();
				break;
			case "2":
				cateUpdate();
				break;
			case "3":
				cateDelete();
				break;
			case "4":
				cateInsert();
				break;
			default:
			}
		}
	}

	/**
	 * 광고관리 메서드
	 */
	private void bannerManagement() {
		while (!input.toLowerCase().equals("main")) {
			showBar("광고관리");
			System.out.println("1.광고조회");
			System.out.println("2.광고수정");
			System.out.println("3.광고삭제");
			System.out.println("4.광고추가");
			System.out.println("나가기(Q/q)");
			System.out.println("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				bannerShow();
				break;
			case "2":
				bannerUpdate();
				break;
			case "3":
				bannerDelete();
				break;
			case "4":
				bannerInsert();
				break;
			default:

			}
		}
	}

	/**
	 * 회원관리 메서드
	 */
	private void memberManagement() {
		while (!input.toLowerCase().equals("main")) {
			showBar("회원관리");
			System.out.println("1.회원조회");
			System.out.println("2.회원삭제");
			System.out.println("나가기(Q/q)");
			System.out.println("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				memberShow();
				break;
			case "2":
				memberDelete();
				break;
			default:

			}
		}
	}

	/**관리자
	 * 회원조회 메서드
	 */
	private void memberShow() {
		showBar("회원조회");
		ArrayList<MemberVO> mlist = service.viewList();
		for (int i = 1; i < mlist.size(); i++) {
			System.out.println("----------------------------------------------");
			System.out.println("no" + i + "  ID:" + mlist.get(i).getMem_id()
					+ "  이름:" + mlist.get(i).getMem_name() + "  폰번호:"
					+ mlist.get(i).getMem_phone() + "  생일:"
					+ mlist.get(i).getMem_birth());
			System.out.println("----------------------------------------------");
		}
	}

	/**
	 * 회원수정 메서드
	 */
	private void memberUpdate() {
		System.out.println("회원수정입니다.");
	}

	/**
	 * 회원삭제 메서드
	 */
	private void memberDelete() {
		showBar("회원 삭제");

		System.out.print("삭제할 회원의 ID를 입력해주세요");
		input = sc.nextLine();
		if (service.deleteMv(input)) {
			System.out.println("회원 삭제 완료");
		} else {
			System.out.println("잘못된 아이디입니다.");
		}
	}

	/**
	 * 회원추가 메서드
	 */
	private void memberInsert() {
		System.out.println("회원추가입니다.");
	}

	/**
	 * 광고조회 메서드
	 */
	private void bannerShow() {
		List<BannerVO> list = null;
		list = service.bannerShow();
		System.out.println("=======================================================");
		for (int i = 0, cnt=1; i < list.size(); i++) {
			if (list.get(i).isLimit() == true) {
				System.out.println("No."+ cnt +"\t"  + "[ID: " + list.get(i).getBanner_id() + "]"+ list.get(i).getBanner_name() + "\t" + list.get(i).getBanner_content());
				cnt++;
			}
			if (list.get(i).isLimit() == true && i < list.size() - 1) {
				System.out.println("-------------------------------------------------------");
				
			}
		}
		System.out.println("=======================================================");
	}

	/**
	 * 광고수정 메서드
	 */
	private void bannerUpdate() {
		bannerShow();
		System.out.println("수정할 광고를 선택해주세요 : ");
		in = inputInt();
		for(int i = 0; i<service.bannerShow().size(); i++){
			if(service.bannerShow().get(i).getBanner_id()==in){
				System.out.print("title : ");
				String title = sc.nextLine();
				System.out.print("concent : ");
				String content = sc.nextLine();
				service.bannerShow().get(i).setBanner_name(title);
				service.bannerShow().get(i).setBanner_content(content);
				return;
			}
		}
		System.out.println("잘못입력했습니다.");
	}

	/**
	 * 광고삭제 메서드
	 */
	private void bannerDelete() {
		BannerVO bann;
		showBar("광고 삭제");
		bannerShow();
		bann = selectBanner();
		if(bann == null){
			return;
		}
		
		if(service.bannerDelete(bann.getBanner_id())){
			System.out.println("광고 삭제 완료");
		}else{
			System.out.println("광고 삭제를 실패하였습니다.");
		}
	}
	
	/**
	 * 광고삭제를 위한 광고 선택 메서드
	 * 
	 * @return 광고 객체
	 */
	BannerVO selectBanner() {
		List<BannerVO> list = null;
		list = service.bannerShow();
		int banner_sq = -1;
		while (true) {
			
			System.out.print("삭제할 ID : ");
			banner_sq = inputInt();
			if((banner_sq) < 0){
				System.out.println("잘못된 번호입니다. 다시 입력해주세요");
				continue;
			}
			
			if (banner_sq < list.size()) {
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 입력해주세요");
				continue;
			}
		
		}
		return list.get((banner_sq));
	
	}
	/**
	 * 숫자를 입력받는 메서드
	 * 예외처리를 받으면 다시 입력받는다.
	 * @return
	 */
	private int inputInt() {
		int inputInt;
		while (true) {
			try {
				inputInt = sc.nextInt();
				sc.nextLine();
				if (inputInt < 0) {
					System.out.println("0 이상을 입력해주세요");
					continue;
				}
				return inputInt;
			} catch (InputMismatchException e) {
				inputInt = -1;
				sc.nextLine();
				break;
			} catch (Exception e) {
				System.out.println("잘못 입력하셨습니다.");
				sc = new Scanner(System.in);
				continue;
			}
		}
		return inputInt;
	}

	/**
	 * 광고추가 메서드
	 */
	private void bannerInsert() {
		BannerVO bv = new BannerVO();
		showBar("광고추가");
		String banner_name = bannerName();  // 배너 제목
		String banner_content = bannerContent(); //배너 내용
		System.out.println("!!광고추가 완료!!");
		bv.setBanner_name(banner_name);
		bv.setBanner_content(banner_content);
		service.addCv(bv);
	}
	/**
	 * 광고추가
	 * 제목 입력받는 창
	 * @return 유림
	 */
	private String bannerName() {
		String banner_name = null;
		System.out.print("title : ");
		banner_name = sc.nextLine();
		return banner_name;
			
	}
	/**광고추가
	 * 내용물를 입력받는 창
	 * @return 유림
	 */
	private String bannerContent(){
		String banner_content = null;
		System.out.print("content : ");
		banner_content = sc.nextLine();
		return banner_content;
	}

	/**
	 * 카테고리 조회를 위한 메서드
	 * @author 소형
	 */
	private void cateShow() {
		List<CategoryVO> list = null;
		list = service.allCateList();
		System.out.println("No\t" + "카테고리명");
		System.out.println("--------------------------------------");
		for (int i=0; i<list.size(); i++) {
			System.out.println((i+1)+".\t"+ list.get(i).getCate_name());			
		}
		System.out.println("--------------------------------------");
	}

	/**
	 * 카테고리 수정을 위한 메서드
	 * @author 소형
	 */
	private void cateUpdate() {
		showBar("카테고리 수정");
		cateShow();
		
		int cate_id = 0;
		String cate_name = "";
		
		List<CategoryVO> list = null;
		list = service.allCateList();

		
		cate_id = inputCateId();
		cate_name = inputCateName();
		
		CategoryVO cv = new CategoryVO();
		cv.setCate_id(cate_id);
		cv.setCate_name(cate_name);

		cate_name = service.cateUpdate(cv);
		
		
		System.out.println(cate_name+"으로 수정되었습니다.");		
	}
	
	/**
	 * 카테고리 이름을 입력받는 메서드
	 * @author 소형
	 * @return 카테고리 이름
	 */
	private String inputCateName() {
		String cate_name = "";
		while (true) {
			System.out.print("카테고리의 이름을 입력하세요: ");
			cate_name = sc.nextLine();

			if(service.cateNamecheck(cate_name)){
				System.out.println("중복된 카테고리 이름이 존재합니다.");
				continue;
			}else{
				break;	
			}
		}
		return cate_name;
	}
	
	
	
	/**
	 * 카테고리 아이디를 입력받는 메서드
	 * @author 소형
	 * @return 카테고리 아이디
	 */
	private int inputCateId() {
		int cate_id = 0;
		CategoryVO cv = null;                                                                                                     
		while (true) {
			System.out.print("카테고리의 번호를 입력하세요: ");
			cate_id = inputInt();
			cate_id -= 1;
			cv = cateSearch(cate_id);
			if(cv == null){
				System.out.println("해당 번호의 카테고리가 존재하지 않습니다.");
				continue;
			}else{
				break;	
			}
		}
		return cate_id;
	}
	/**
	 * 카테고리 아이디로 카테고리 객체를 검색하는 메서드
	 * @param 카테고리 아이디
	 * @author 소형
	 * @return 카테고리 아이디에 해당하는 카테고리 객체
	 */
	private CategoryVO cateSearch(int cate_id) {
		CategoryVO cv = new CategoryVO();
		cv = service.cateSearch(cate_id);		
		return cv;
	}

	/**
	 * 카테고리 삭제를 위한 카테고리 아이디 받기
	 * @return
	 */
	private int cateSelect(){

		int sq=0;
		int cate_id = 0;
		List<CategoryVO> cateList = service.allCateList();
		System.out.println("----------------------------------------------");
		for (int i=0; i<cateList.size(); i++) {
			System.out.println((i+1)+".\t"+ cateList.get(i).getCate_name());			
		}
		System.out.println("----------------------------------------------");
	
		System.out.print("삭제할 카테고리의 번호를 입력하세요: ");
		sq = inputInt();
		
		for(int i = 0 ; i<cateList.size(); i++){
			if((sq-1) == i){
				cate_id = cateList.get(i).getCate_id();
				return cate_id;
			}
		}
		if(cate_id==0){
			System.out.println("삭제할 카테고리가 없습니다.");
			cateSelect();
		}
		return cate_id;
	}
	
	/**
	 * 카테고리 삭제를 위한 메서드
	 * @author 소형
	 */
	private void cateDelete() {
		CategoryVO cv = new CategoryVO();
		
		int cate_id = cateSelect();
		cv = cateSearch(cate_id);
		if (cv == null) {
			return;
		}
		
		if (service.cateDelete(cv)) {
			System.out.println("카테고리를 삭제하였습니다.");
		} else {
			System.out.println("카테고리 삭제에 실패하였습니다.");
		}
		
	}

	/**
	 * 카테고리추가 메서드
	 * @author 소형
	 */
	private void cateInsert() {
		showBar("카테고리 추가");
		cateShow();
		CategoryVO cv = new CategoryVO();
		cv.setCate_name(inputCateName());
		if(service.cateInsert(cv)){
			System.out.println("카테고리를 추가했습니다.");
		}
		
	}

	private void itemShow() {
		showBar("아이템 조회");
		List<ItemVO> aditemshop = service.itemShop();
		int num = 0;
		System.out.println("--------------- 아 이 템-----------------");
		for(int i = 0; i<aditemshop.size(); i++){	
			num++;
			System.out.println("\tNo." + num+" "+aditemshop.get(i).getItem_name() + "▶" +aditemshop.get(i).getItem_price());
			System.out.println("\t" + aditemshop.get(i).getItem_content());
			System.out.println();
		}
		System.out.println("----------------------------------------");
	}

	/**
	 * 아이템수정 메서드
	 */
	private void itemUpdate() {
		showBar("아이템수정");
		List<ItemVO> aditemshop = service.itemShop();
		int num = 0;
		System.out.println("--------------- 아 이 템-----------------");
		for(int i = 0; i<aditemshop.size(); i++){	
			num++;
			System.out.println("\tNo." + num+" "+aditemshop.get(i).getItem_name() + "▶" +aditemshop.get(i).getItem_price());
			System.out.println("\t" + aditemshop.get(i).getItem_content());
			System.out.println();
		}
		System.out.println("----------------------------------------");
		System.out.println("어떤 아이템을 수정하시겠습니까?? : ");
		in = inputInt();
		for(int i =0; i<service.itemShop().size(); i++){
			service.itemShop().get(i).setItem_id(i);
		}
		int itemPrice = 0;
		for(int i = 0; i<service.itemShop().size(); i++){
			if(service.itemShop().get(i).getItem_id()==in-1){
				System.out.print("이름 : ");
				String itemName = sc.nextLine();
				System.out.print("가격 : ");
				while(true){
					try{
						itemPrice = sc.nextInt();
						sc.nextLine();
						if (itemPrice < 0) {
							System.out.println("0 이상을 입력해주세요");
							continue;
						}
						break;
					}catch(Exception e){
						System.out.println("다시입력하세요.");
						sc = new Scanner(System.in);
						continue;
					}
				}
				System.out.print("아이템 설명 : ");
				String itemContent = sc.nextLine();
				service.itemShop().get(i).setItem_name(itemName);
				service.itemShop().get(i).setItem_price(itemPrice);
				service.itemShop().get(i).setItem_content(itemContent);
			}
		}
	}

	/**
	 * 아이템삭제 메서드
	 */
	private void itemDelete() {
		showBar("아이템삭제");
		List<ItemVO> aditemshop = service.itemShop();
		System.out.println("--------------- 아 이 템-----------------");
		for(int i = 0; i<service.itemShop().size();i++){
			service.itemShop().get(i).setItem_id(i+1);
		}
		for(int i = 0; i<service.itemShop().size(); i++){	
			System.out.println("\tNo." + service.itemShop().get(i).getItem_id()+" "+service.itemShop().get(i).getItem_name() + "▶" +service.itemShop().get(i).getItem_price());
			System.out.println("\t" + service.itemShop().get(i).getItem_content());
			System.out.println();
		}
		System.out.println("----------------------------------------");
		System.out.println("삭제할 아이템을 선택해주세요 : ");
		in = inputInt();
		for(int i = 0; i<service.itemShop().size(); i++){
			if(service.itemShop().get(i).getItem_id()==in){
				service.itemShop().remove(i);
			}
		}
	}


	private void member() {
		while (!input.toLowerCase().equals("main")) {
			showBar("회원메인");
			System.out.println();
			System.out.println("┏--------------- 배 너 -----------------┓");
			for (int i = 0; i < service.bannerShow().size(); i++) {
				System.out.println("\t"
						+ service.bannerShow().get(i).getBanner_content());
			}
			System.out.println("┗-------------------------------------┛");
			System.out.println();
			System.out.println("1. 마이페이지");
			System.out.println("2. 물품거래게시판");
			System.out.println("3. 아이템샵 ");
			System.out.println("4. 메세지함");
			System.out.println("나가기(Q/q)");
			System.out.println();
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				myPage();
				break;
			case "2":
				noticeboard();
				break;
			case "3":
				itemShop();
				break;
			case "4":
				memMessage();
			default:
			}
		}
	}
	/**
	 * 메세지함 메서드
	 * @author 시용
	 */
	private void memMessage() {
		showBar("메세지함");
		System.out.println("1. 받은 메세지함");
		System.out.println("2. 보낸 메세지함");
		System.out.println("3. 메세지 작성");
		System.out.print("입력 : ");
		input = sc.nextLine();
		switch(input){
			case "1":
				receiveMessage(loginMember);
				break;
			case "2":
				sendMessage(loginMember);
				break;
			case "3":
				send(loginMember);
				break;
			default :
		}
	}
	/**
	 * 메세지보내기메서드
	 * @author 시용
	 * @param mv 
	 */
	private void send(MemberVO mv) {
		MessageVO mg = new MessageVO();
		System.out.print("제목 : ");
		String messageTitle = sc.nextLine();
		System.out.print("내용 : ");
		String messageContent = sc.nextLine();
		System.out.print("받을 사람 : ");
		String receiveCheck = sc.nextLine();
		String receiveMem = "";
		for(int i = 0; i<service.receiveCheck().size(); i++){
			if(service.receiveCheck().get(i).getMem_id().equals(receiveCheck)){
				receiveMem = receiveCheck;
				break;
			}
		}
		if(receiveMem.equals("")){
			System.out.println("없는 사용자 입니다.");
			return;
		}
		mg.setTitle(messageTitle);
		mg.setConcent(messageContent);
		mg.setSend_id(mv.getMem_id());
		mg.setReceive_id(receiveMem);
		service.sendMessage(mg);
	}
	/**
	 * 보낸매세지함보기
	 * @param mv
	 * @author 시용
	 */
	private void sendMessage(MemberVO mv) {
		showBar("보낸메세지함");
		int num = 1;
		System.out.println("------------------------------------------------------");
		for(int i = 0;  i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				System.out.println("No" + num + "\t" + service.memMessage().get(i).getTitle() + "\t\t" + "받은사람 [" + service.memMessage().get(i).getReceive_id()  + "]");
				num++;
			}
		}
		System.out.println("------------------------------------------------------");
		sendFunciton();

	}
	/**
	 * 보낸메세지함 기능 메서드
	 */
	private void sendFunciton(){
		while (!input.toLowerCase().equals("main")) {
			System.out.println("1.상세보기");
			System.out.println("2.메세지삭제");
			System.out.println("나가기(Q/q)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch(input){
				case "1":
					sendMessageDetail(loginMember);
					break;
				case "2":
					sendMessageRemove(loginMember);
					break;
				default :
			}
		}	
	}
	/**
	 * 받은메세지함 기능 메서드
	 */
	private void receiveFunciton(){
		while (!input.toLowerCase().equals("main")) {
			System.out.println("1.상세보기");
			System.out.println("2.메세지삭제");
			System.out.println("나가기(Q/q)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch(input){
				case "1":
					receiveMessageDetail(loginMember);
					break;
				case "2":
					receiveMessageRemove(loginMember);
					break;
				default :
			}
		}	
	}
	private void receiveMessageRemove(MemberVO mv) {
		int num =  0;
		for(int i = 0; i<service.memMessage().size();i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				service.memMessage().get(i).setMessage_id(num++);
			}
		}
		int num2 = 1;
		System.out.println("------------------------------------------------------");
		for(int i =0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				System.out.println("No" + num2 +"\t" + service.memMessage().get(i).getTitle() + "\t\t" + "보낸사람 [" + service.memMessage().get(i).getSend_id()+"]");
				num2++;
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("어떤 메세지를 삭제하시겠습니까.?");
		while(true){
			try{
				in = sc.nextInt();
				sc.nextLine();
				if (in <= 0) {
					System.out.println("0 초과를 입력해주세요");
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("다시입력하세요.");
				sc = new Scanner(System.in);
				continue;
			}
		}
		for(int i = 0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				service.memMessage().remove(i);
				System.out.println("메세지를 삭제했습니다.");
				break;
			}
		}

	}
	private void receiveMessageDetail(MemberVO mv) {
		int num =  0;
		for(int i = 0; i<service.memMessage().size();i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				service.memMessage().get(i).setMessage_id(num++);
			}
		}
		int num2 = 1;
		System.out.println("------------------------------------------------------");
		for(int i =0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				System.out.println("No" + num2 +"\t" + service.memMessage().get(i).getTitle() + "\t\t" + "보낸사람 [" + service.memMessage().get(i).getSend_id()+"]");
				num2++;
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("어떤 메세지를 상세보시겠습니까.");
		in = inputInt();
		System.out.println("-------------------상세보기-------------------");
		for(int i = 0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())&&service.memMessage().get(i).getMessage_id()==in-1){
				System.out.println("제목 : " + service.memMessage().get(i).getTitle() +"\t\t보낸사람 [" + service.memMessage().get(i).getSend_id()+"]");
				System.out.println("내용 : " + service.memMessage().get(i).getConcent());
				break;
			}
		}
		System.out.println("-------------------------------------------");
	}
	/**
	 * 상세보기
	 * @param mv
	 */
	private void sendMessageDetail(MemberVO mv) {
		int num =  0;
		for(int i = 0; i<service.memMessage().size();i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				service.memMessage().get(i).setMessage_id(num++);
			}
		}
		int num2 = 1;
		System.out.println("------------------------------------------------------");
		for(int i =0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				System.out.println("No" + num2 +"\t" + service.memMessage().get(i).getTitle() + "\t\t" + "받은사람 [" + service.memMessage().get(i).getReceive_id()+"]");
				num2++;
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("어떤 메세지의 상세내용을 보시겠습니까??");
		in = inputInt();
		System.out.println("-------------------상세보기-------------------");
		for(int i = 0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())&&service.memMessage().get(i).getMessage_id()==in-1){
				
				System.out.println("제목 : " + service.memMessage().get(i).getTitle() +"\t\t받는사람 [" + service.memMessage().get(i).getReceive_id()+"]");
				System.out.println("내용 : " + service.memMessage().get(i).getConcent());
				break;
			}
		}
		System.out.println("-------------------------------------------");
	}
	private void sendMessageRemove(MemberVO mv) {
		int num =  0;
		for(int i = 0; i<service.memMessage().size();i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				service.memMessage().get(i).setMessage_id(num++);
			}
		}
		int num2 = 1;
		System.out.println("------------------------------------------------------");
		for(int i =0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				System.out.println("No" + num2 +"\t" + service.memMessage().get(i).getTitle() + "\t\t" + "받은사람 [" + service.memMessage().get(i).getReceive_id()+"]");
				num2++;
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("어떤 메세지를 삭제하시겠습니까.?");
		while(true){
			try{
				in = sc.nextInt();
				sc.nextLine();
				if (in <= 0) {
					System.out.println("0 초과를 입력해주세요");
					continue;
				}
				break;
			}catch(Exception e){
				System.out.println("다시입력하세요.");
				sc = new Scanner(System.in);
				continue;
			}
		}
		for(int i = 0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getSend_id().equals(mv.getMem_id())){
				service.memMessage().remove(i);
				System.out.println("메세지를 삭제했습니다.");
				break;
			}
		}
		
	}

	/**
	 * 받은메세지함보기
	 * @param mv
	 */
	private void receiveMessage(MemberVO mv) {
		showBar("받은메세지함");
		int num = 1;
		System.out.println("------------------------------------------------------");
		for(int i =0; i<service.memMessage().size(); i++){
			if(service.memMessage().get(i).getReceive_id().equals(mv.getMem_id())){
				System.out.println("No" + num +"\t" + service.memMessage().get(i).getTitle() + "\t\t" + "보낸사람 [" + service.memMessage().get(i).getSend_id()+"]");
				num++;
			}
		}
		System.out.println("------------------------------------------------------");
		receiveFunciton();
	}
	
	
	
	
	/**
	 * 아이템샵 메서드
	 */
	private void itemShop() {
		while (!input.toLowerCase().equals("main")) {
			showBar("아이템샵");
			System.out.println("1.아이템구매");
			System.out.println("2.아이템환불");
			System.out.println("나가기(Q/q)");
			System.out.println("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				itemBuy();
				break;
			case "2":
				itemRefund(loginMember);
				break;
			default:

			}
		}
	}

	/**
	 * 아이템샵 메서드
	 */
	private void itemBuy(){
		List<ItemVO> itemshop = service.itemShop();
		showBar("아이템구매");
		System.out.println("--------------- 아 이 템-----------------");
		for(int i = 0; i<itemshop.size(); i++){	
			System.out.println("\tNo" + (itemshop.get(i).getItem_id()+1) +itemshop.get(i).getItem_name() + "▶" +itemshop.get(i).getItem_price());
			System.out.println("\t" + itemshop.get(i).getItem_content());
			System.out.println();
		}
		System.out.println("----------------------------------------");
		itemBuy2(loginMember);
	}
	/**
	 * 아이템 구매 메서드
	 */
	private void itemBuy2(MemberVO mv) {
		List<ItemVO> itemshop = service.itemShop();
		List<MyItemView> myItem = service.myItemList(mv);
		MyItemView miv = new MyItemView();
		System.out.println("무엇을 구매하시겠습니까?");
		in = inputInt();
		for (int i = 0; i < itemshop.size(); i++) {
			if (itemshop.get(i).getItem_id() == in-1) {
				if (mv.getMem_cash() < itemshop.get(i).getItem_price()) {
					System.out.println("돈이 부족합니다.");
					return;
				}
				String itemName = itemshop.get(i).getItem_name();
				int itemPrice = itemshop.get(i).getItem_price();
				int myCash = mv.getMem_cash();
				miv.setItem_name(itemName);
				miv.setItem_price(itemPrice);
				mv.setMem_cash(myCash - itemshop.get(i).getItem_price());
				miv.setMem_id(mv.getMem_id());
				service.myItemAdd(miv);
				System.out.println("이용해주셔서 감사합니다.");
			}
		}
	}

	/**
	 * 아이템환불 메서드
	 */
	private void itemRefund(MemberVO mv) {
		showBar("아이템환불");
		List<MyItemView> myItem = service.myItemList(mv);
		for (int i = 0; i < myItem.size(); i++) {
			System.out.println(myItem.get(i).getItem_id()+". " + myItem.get(i).getItem_name());
		}
		if(myItem.size()==0){
			System.out.println("환불하실 아이템이 없습니다.");
			return;
		}
		System.out.println("환불하실 아이템을 선택해주세요.");
		in = inputInt();
		int cash = mv.getMem_cash();
		int c = 1;
		for(int i = 0; i<myItem.size(); i++){
			if(in==myItem.get(i).getItem_id()){
				for(int j = 0; j<service.itemRefund().size(); j++){
					if(service.itemRefund().get(i).getMem_id().equals(mv.getMem_id())){
						service.itemRefund().get(i).setItem_id(c++);
					}
					if(service.itemRefund().get(i).getMem_id().equals(mv.getMem_id())&&
							service.itemRefund().get(i).getItem_id()==in){
						mv.setMem_cash(cash+service.itemRefund().get(i).getItem_price());
						service.itemRefund().remove(i);
						System.out.println("아이템 환불이 완료됬습니다.");
						break;
					}
				}
				break;
			}
		}
	}



	/**
	 * 마이페이지 메서드
	 */
	private void myPage() {
		while (!input.toLowerCase().equals("main")) {
			showBar("마이페이지");
			System.out.println("1.내정보조회");
			System.out.println("2.내정보수정");
			System.out.println("3.캐시충전");
			System.out.println("4.내아이템");
			System.out.println("5.구매내역");
			System.out.println("6.판매내역");
			System.out.println("7.회원탈퇴");
			System.out.println("나가기(Q/q)");
			System.out.println("시작페이지(Main)");
			System.out.print("입력 : ");
			input = sc.nextLine();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			switch (input) {
			case "1":
				myInfomation(loginMember);
				break;
			case "2":
				myInfomationUpdateConfirm(loginMember);
				break;
			case "3":
				addCash(loginMember);
				break;
			case "4":
				myItem(loginMember);
				break;
			case "5":
				buyList(loginMember);
				break;
			case "6":
				cellList(loginMember);
				break;
			case "7":
				memberSecession(loginMember);
				break;
			default:

			}
		}
	}
	/**
	 * 내정보 조회하는 메서드
	 * @author 시용
	 * @param loginMember2
	 */
	private void myInfomation(MemberVO mv) {
		showBar("내정보조회");
		System.out.println("ID : " + mv.getMem_id());
		System.out.println("이름 : " + mv.getMem_name());
		System.out.println("생일 : " + mv.getMem_birth());
		System.out.println("핸드폰 번호 : " + mv.getMem_phone());
		System.out.println("나의 캐시 : " + mv.getMem_cash());
	}

	/**
	 * 내정보수정 확인 메서드
	 * 
	 * @author 김시용
	 */
	private void myInfomationUpdateConfirm(MemberVO mv) {
		showBar("내정보수정");
		System.out.print("정보를 변경하기 위한 비번 확인 : ");
		String mem_pw = sc.nextLine();
		if (mv.getMem_pw().equals(mem_pw)) {
			String newMemPw = inputPw();
			mv.setMem_pw(newMemPw);
			String newMemName = inputName();
			mv.setMem_name(newMemName);
			String newMemBrith = inputBirth();
			mv.setMem_birth(newMemBrith);
			String newMemPhone = inputPhone();
			mv.setMem_phone(newMemPhone);
			System.out.println("회원정보 수정 완료!!!@!!!");
		} else {
			System.out.println("비번이 틀렸습니다. 다시 입력!");
			myInfomationUpdateConfirm(mv);
		}
	}
	
	/**
	 * 캐시충전 메서드
	 */
	private void addCash(MemberVO mv) {
		showBar("캐시충전");
		System.out.println("금액을 입력해주세요.");
		System.out.println("1. 50000원");
		System.out.println("2. 10000원");
		System.out.println("3. 5000원");
		System.out.println("4. 1000원");
		System.out.print("입력 : ");
		input = sc.nextLine();
		int cash = mv.getMem_cash();
		switch (input) {
		case "1":
			mv.setMem_cash(cash + 50000);
			System.out.println("현재 나의 캐시 : " + mv.getMem_cash());
			break;
		case "2":
			mv.setMem_cash(cash + 10000);
			System.out.println("현재 나의 캐시 : " + mv.getMem_cash());
			break;
		case "3":
			mv.setMem_cash(cash + 5000);
			System.out.println("현재 나의 캐시 : " + mv.getMem_cash());
			break;
		case "4":
			mv.setMem_cash(cash + 1000);
			System.out.println("현재 나의 캐시 : " + mv.getMem_cash());
			break;
		default:
			System.out.println("다시 입력해주세요.");
			addCash(mv);
		}
	}

	/**
	 * 내아이템 목록 메서드
	 */
	private void myItem(MemberVO mv) {
		List<MyItemView> myItem = service.myItemList(mv);
		showBar("내아이템");
		System.out.println();
		int num = 1;
		for (int i = 0; i < myItem.size(); i++) {
			System.out.println(num++ + ". "+myItem.get(i).getItem_name());
		}
	}

	/**
	 * 구매내역 메서드
	 * @author 시용
	 */
	private void buyList(MemberVO mv) {
		showBar("구매내역");
		System.out.println("번호\t" + "물품이름\t" + "금액\t"+ "판매자ID");
		System.out.println("-----------------------------------");
		for(int i = 0; i<service.memBuyList().size(); i++){
			if(service.memBuyList().get(i).getMem_id().equals(mv.getMem_id())){
				System.out.println(i+1 + ". \t"+service.memBuyList().get(i).getMempro_name() + 
						"\t" + service.memBuyList().get(i).getMempro_price() + "\t " 
						+ service.memBuyList().get(i).getMybuy_celler_id());
			}
		}
		System.out.println("-----------------------------------");
	}

	/**
	 * 판매내역 메서드
	 */
	private void cellList(MemberVO mv) {
		showBar("판매내역");
		System.out.println("번호\t" + "물품이름\t" + "금액\t"+ "구매자ID");
		System.out.println("-----------------------------------");
		for(int i = 0; i<service.memCellList().size(); i++){
			if(service.memCellList().get(i).getMem_id().equals(mv.getMem_id())){
				System.out.println(i+1 + ". \t" + service.memCellList().get(i).getMempro_name() + "\t"+
						  service.memCellList().get(i).getMempro_price() + "\t" 
						+ service.memCellList().get(i).getMycell_buyer_id());
			}
		}
		System.out.println("-----------------------------------");
	}

	/**
	 * 회원탈퇴메서드
	 */
	private void memberSecession(MemberVO mv) {
		showBar("회원탈퇴");
		System.out.print("회원탈퇴 하시겠습니까??(Y/N)");
		String secession = sc.nextLine();
		if (secession.equalsIgnoreCase("Y")) {
			System.out.println("회원탈퇴를 성공했습니다.");
			mv.setLimit(false);
			mv.setMem_id("0");
			view();
		} else if (secession.equalsIgnoreCase("N")) {
			myPage();
		} else {
			System.out.println("다시 입력해주세요!");
			memberSecession(mv);
		}
	}
//----------------------------------------------------
	/**
	 * 물품거래게시판 메서드
	 * @author 소형
	 */
	private void noticeboard() {
		CategoryVO cv = null;
		while (!input.toLowerCase().equals("main")) {
			showBar("물품거래게시판");
			cateShow();
			if (input.toLowerCase().equals("q")) {
				return;
			}
			int cate_id = inputCateId();
			cv = cateSearch(cate_id);
			if(cv==null){
				return;
			}
			mem_proByCategory(cv);		
		}
	}
	/**
	 * 해당 카테고리별 물품거래게시글 조회, 선택하는 메서드
	 * @param 해당 카테고리 객체
	 */
	private void mem_proByCategory(CategoryVO cv){

		List<MemberProductVO> memproList = service.showMemProByCate(cv.getCate_id());
		MemberProductVO mpv;
		
		showBar(cv.getCate_name()+"거래 게시글");
		
		System.out.println("----------------------------------------------------");
		System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
		
		int num2 = 1;
		for(int i=0; i<service.boardShow().size();i++){
			if(service.boardShow().get(i).getMem_id().equals("root")){
				System.out.println("★" + num2 + "\t\t" + service.boardShow().get(i).getMempro_title() + "\t\t" +service.boardShow().get(i).getMem_id());
				num2++;
			}
		}
		
		if(memproList.isEmpty()){
			System.out.println("거래 게시글이 없습니다.");
		}
		int num = 1;
		for(int i=0; i<memproList.size();i++){
			if(!memproList.get(i).getMem_id().equals("root")){
				if(memproList.get(i).getMem_id().equals("root")){
					continue;
				}
				mpv = memproList.get(i);
				System.out.println(num + "\t\t" + mpv.getMempro_title() + "\t\t" + mpv.getMem_id());
				num++;
			}
		}
		System.out.println("----------------------------------------------------");
		memproBoard(cv);
		
	}
	
	/**
	 * 카테고리별 물품거래게시판 메인 
	 */
	private void memproBoard(CategoryVO cv) {
		while (!input.toLowerCase().equals("main")) {
			if(loginMember.isAdmin()){
				System.out.println("1. 상세보기");
				System.out.println("2. 게시글 작성");
				System.out.println("3. 게시글 수정");
				System.out.println("4. 게시글 삭제");
				System.out.println("나가기(Q/q)");
				System.out.println();
				System.out.print("입력 : ");
				input = sc.nextLine();
				if (input.toLowerCase().equals("q")) {
					return;
				}
				switch (input) {
				case "1":
					memproDetail(cv);
					break;
				case "2":
					memproWrite(cv);
					break;
				case "3":
					memproUpdate(cv);
					break;
				case "4":
					memproDelete(cv);
					break;
				default:

				}
			}else{
				System.out.println("1. 상세보기");
				System.out.println("2. 게시글 작성");
				System.out.println("3. 게시글 수정");
				System.out.println("4. 게시글 삭제");
				System.out.println("5. 아이템 사용");
				System.out.println("나가기(Q/q)");
				System.out.println();
				System.out.print("입력 : ");
				input = sc.nextLine();
				if (input.toLowerCase().equals("q")) {
					return;
				}
				switch (input) {
				case "1":
					memproDetail(cv);
					break;
				case "2":
					memproWrite(cv);
					break;
				case "3":
					memproUpdate(cv);
					break;
				case "4":
					memproDelete(cv);
					break;
				case "5":
					itemUse(cv);
					break;
				default:
					
				}
			}
		}
	}
	/**
	 * 아이템사용
	 * @param cv
	 */
	private void itemUse(CategoryVO cv) {
		int num = 1;
		System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
		System.out.println("----------------------------------------------------");
		for(int i = 0; i<service.boardShow().size(); i++){
			if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&
					loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())){
				System.out.println(num + "\t\t" + service.boardShow().get(i).getMempro_title() + 
						"\t\t" + service.boardShow().get(i).getMem_id());
				service.boardShow().get(i).setMempro_id(num);
				num++;
			}
		}
		System.out.println("----------------------------------------------------");
		if(num==1){
			System.out.println("아이템을 사용할 게시글이 없습니다.");
			return;
		}
		if(service.myItemList(loginMember).size()==0){
			System.out.println("사용할 아이템이 없습니다.");
			return;
		}
		System.out.print("어떤 아이템을 사용하시겠습니까??");
		myItem(loginMember);
		int use = inputInt();
		if(use>service.myItemList(loginMember).size()){
			return;
		}
		System.out.print("아이템을 사용할 게시글 번호를 입력하세요.");
		in = inputInt();
		if(in>num){
			return;
		}
		if(service.itemRefund().get(in-1).getItem_name().equals("슈퍼리스트")){
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())
					&&in==service.boardShow().get(i).getMempro_id()){
					MemberProductVO mv = service.boardShow().get(i); 
					service.boardShow().remove(i);
					service.boardShow().add(0, mv);
					System.out.println("아이템을 사용했습니다.");
					service.itemRefund().remove(in-1);
					break;
				}
			}
		}else if(service.itemRefund().get(in-1).getItem_name().equals("파워리스트")){
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())
					&&in==service.boardShow().get(i).getMempro_id()){
					MemberProductVO mv = service.boardShow().get(i); 
					service.boardShow().get(i).setMempro_title("★★★★★★"+service.boardShow().get(i).getMempro_title()+"★★★★★★");;
					System.out.println("아이템을 사용했습니다.");
					service.itemRefund().remove(in-1);
					break;
				}
			}
			
		}
	}
	/**
	 * 게시글삭제
	 * @param cv
	 */
	private void memproDelete(CategoryVO cv) {
		int num = 1;
		System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
		System.out.println("----------------------------------------------------");
		for(int i = 0; i<service.boardShow().size(); i++){
			if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&
					loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())){
				System.out.println(num + "\t\t" + service.boardShow().get(i).getMempro_title() + 
						"\t\t" + service.boardShow().get(i).getMem_id());
				service.boardShow().get(i).setMempro_id(num);
				num++;
			}
		}
		System.out.println("----------------------------------------------------");
		if(num==1){
			System.out.println("삭제할 게시글이 없습니다.");
			return;
		}
		System.out.print("삭제할 번호를 입력하세요.");
		in = inputInt();
		for(int i = 0; i<service.boardShow().size(); i++){
			if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())
				&&in==service.boardShow().get(i).getMempro_id()){
				service.boardShow().remove(i);
				System.out.println("삭제되었습니다.");
				break;
			}
		}
	}
	/**
	 * 게시글 수정
	 * @author 소형
	 * @param cv
	 */
	private void memproUpdate(CategoryVO cv) {
		if(loginMember.isAdmin()){
			int num = 1;
			System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
			System.out.println("----------------------------------------------------");
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())){
					System.out.println(num + "\t\t" + service.boardShow().get(i).getMempro_title() + "\t\t" + service.boardShow().get(i).getMem_id());
					service.boardShow().get(i).setMempro_id(num);
					num++;
				}
			}
			System.out.println("----------------------------------------------------");
			if(num==1){
				System.out.println("수정할 게시글이 없습니다.");
				return;
			}
			System.out.print("수정할 번호를 입력하세요.");
			in = inputInt();
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())
						&&in==service.boardShow().get(i).getMempro_id()){
					System.out.print("게시글 제목 : ");
					String title = sc.nextLine();
					System.out.print("게시글 내용 : ");
					String content = sc.nextLine();
					service.boardShow().get(i).setMempro_title(title);
					service.boardShow().get(i).setMempro_content(content);
					System.out.println("수정완료!");
					break;
				}
			}
		}else{
			int num = 1;
			System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
			System.out.println("----------------------------------------------------");
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())){
					System.out.println(num + "\t\t" + service.boardShow().get(i).getMempro_title() + "\t\t" + service.boardShow().get(i).getMem_id());
					service.boardShow().get(i).setMempro_id(num);
					num++;
				}
			}
			System.out.println("----------------------------------------------------");
			if(num==1){
				System.out.println("수정할 게시글이 없습니다.");
				return;
			}
			System.out.print("수정할 번호를 입력하세요.");
			in = inputInt();
			for(int i = 0; i<service.boardShow().size(); i++){
				if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&loginMember.getMem_id().equals(service.boardShow().get(i).getMem_id())
						&&in==service.boardShow().get(i).getMempro_id()){
					System.out.print("게시글 제목 : ");
					String title = sc.nextLine();
					System.out.print("게시글 내용 : ");

					String content = sc.nextLine();
					System.out.print("상품명 : ");
					String proName = sc.nextLine();
					System.out.print("상품가격 : ");
					int proPrice;
					while(true){
						try{
							proPrice = sc.nextInt();
							sc.nextLine();
							if (proPrice< 0) {
								System.out.println("0 이상을 입력해주세요");
								continue;
							}
							break;
						}catch(Exception e){
							System.out.println("다시입력하세요.");
							sc = new Scanner(System.in);
							continue;
						}
					}
					service.boardShow().get(i).setMempro_title(title);
					service.boardShow().get(i).setMempro_content(content);
					service.boardShow().get(i).setMempro_name(proName);
					service.boardShow().get(i).setMempro_price(proPrice);
					System.out.println("수정완료!");
					break;
				}
			}
			
			
			
		}

	}
	
	
	
	private void memproWrite(CategoryVO cv) {
		MemberProductVO mp = new MemberProductVO();
		if(loginMember.isAdmin()){
			System.out.print("게시글 제목 : ");
			String title = sc.nextLine();
			System.out.print("게시글 내용 : ");
			String content = sc.nextLine();
			mp.setMempro_title(title);
			mp.setMempro_content(content);
			mp.setMem_id(loginMember.getMem_id());
			mp.setCate_id(cv.getCate_id());
			if(service.memProAdd(mp)){
				System.out.println("게시글 작성이 완료하였습니다.");
			}else{
				System.out.println("게시글 작성이 실패하였습니다.");
			}
		}else{
			System.out.print("게시글 제목 : ");
			String title = sc.nextLine();
			System.out.print("게시글 내용 : ");
			String content = sc.nextLine();
			System.out.print("상품명 : ");
			String proName = sc.nextLine();
			System.out.print("상품가격 : ");
			int proPrice;
			while(true){
				try{
					proPrice = sc.nextInt();
					sc.nextLine();
					if (proPrice< 0) {
						System.out.println("0 이상을 입력해주세요");
						continue;
					}
					break;
				}catch(Exception e){
					System.out.println("다시입력하세요.");
					sc = new Scanner(System.in);
					continue;
				}
			}
			mp.setMempro_title(title);
			mp.setMempro_content(content);
			mp.setMempro_name(proName);
			mp.setMempro_price(proPrice);
			mp.setMem_id(loginMember.getMem_id());
			mp.setCate_id(cv.getCate_id());
			if(service.memProAdd(mp)){
				System.out.println("게시글 작성이 완료하였습니다.");
			}else{
				System.out.println("게시글 작성이 실패하였습니다.");
			}
		}
		

	}
	/**
	 * 상세보기 볼때 보여지는거
	 */
	private void detailShow(CategoryVO cv){
		List<MemberProductVO> memproList = service.showMemProByCate(cv.getCate_id());
		MemberProductVO mpv;
		
		
		showBar(cv.getCate_name()+"거래 게시글");
		
		System.out.println("----------------------------------------------------");
		
		if(memproList.isEmpty()){
			System.out.println("거래 게시글이 없습니다.");
		}
		System.out.println("게시글 번호" + "\t\t" + "제목" + "\t\t\t" + "작성자ID");
		System.out.println("----------------------------------------------------");
		
		int num2 = 1;
		for(int i=0; i<service.boardShow().size();i++){
			if(service.boardShow().get(i).getMem_id().equals("root")){
				System.out.println(num2 + "\t\t" + service.boardShow().get(i).getMempro_title() + "\t\t" +service.boardShow().get(i).getMem_id());
				num2++;

			}
		}		
		for(int i=0; i<memproList.size();i++){
			if(!(memproList.get(i).getMem_id().equals("root"))){
			mpv = memproList.get(i);
			System.out.println(num2 + "\t\t" + mpv.getMempro_title() + "\t\t" + mpv.getMem_id());
			num2++;
			}
		}
		System.out.println("----------------------------------------------------");
	}
	/**
	 * 상세보기
	 * @param cv
	 */
	private void memproDetail(CategoryVO cv) {
		detailShow(cv);
		int num = 1;
		System.out.println("상세보기 게시글을 선택해주세요.");
		in = inputInt();
		
		for(int i = 0; i<service.boardShow().size(); i++){
			if(service.boardShow().get(i).getMem_id().equals("root")){
				service.boardShow().get(i).setMempro_id(num++);
			}
		}
		
		for(int i =0; i<service.boardShow().size();i++){
			if(cv.getCate_id()==service.boardShow().get(i).getCate_id()&&!service.boardShow().get(i).getMem_id().equals("root")){
				service.boardShow().get(i).setMempro_id(num++);
			}
		}

		
		for(int i = 0; i<service.boardShow().size(); i++){
			if(service.boardShow().get(i).getMempro_id()==in&&service.boardShow().get(i).getMem_id().equals("root")){
				System.out.println("관리자나와랏");
				System.out.println("----------------------------------------------------");
				System.out.println("게시글 제목: "+service.boardShow().get(i).getMempro_title() + "\t게시글작성자: " + service.boardShow().get(i).getMem_id());
				System.out.println("----------------------------------------------------");
				System.out.println("게시글 내용: "+service.boardShow().get(i).getMempro_content());
				System.out.println("----------------------------------------------------");
				break;
			}
			if(in==service.boardShow().get(i).getMempro_id()&&cv.getCate_id()==service.boardShow().get(i).getCate_id()&&!service.boardShow().get(i).getMem_id().equals("root")){
				System.out.println("----------------------------------------------------");
				System.out.println("게시글 제목: "+service.boardShow().get(i).getMempro_title() + "\t게시글작성자: " + service.boardShow().get(i).getMem_id());
				System.out.println("----------------------------------------------------");
				System.out.println("게시글 내용: "+service.boardShow().get(i).getMempro_content());
				System.out.println("판매 물건: "+service.boardShow().get(i).getMempro_name());
				System.out.println("가격: "+service.boardShow().get(i).getMempro_price());
				System.out.println("----------------------------------------------------");
				if(service.boardShow().get(i).getMem_id().equals(loginMember.getMem_id())||loginMember.getMem_id().equals("root")){
					break;
				}
				System.out.print("물건을 구매하시겠습니까?(Y/N)");
				input = sc.nextLine();
				if(input.equalsIgnoreCase("y")){
					if(loginMember.getMem_cash()<service.boardShow().get(i).getMempro_price()){
						System.out.println("보유캐시부족");
						return;
					}
					MyBuyView mv = new MyBuyView();
					mv.setMybuy_celler_id(service.boardShow().get(i).getMem_id());
					mv.setMempro_name(service.boardShow().get(i).getMempro_name());
					mv.setMempro_price(service.boardShow().get(i).getMempro_price());
					mv.setMem_id(loginMember.getMem_id());
					int memPrice = loginMember.getMem_cash();
					loginMember.setMem_cash(memPrice-service.boardShow().get(i).getMempro_price());
					service.memBuyList().add(mv);
					
					
					MyCellView mcv = new MyCellView();
					mcv.setMycell_buyer_id(loginMember.getMem_id());
					mcv.setMempro_name(service.boardShow().get(i).getMempro_name());
					mcv.setMempro_price(service.boardShow().get(i).getMempro_price());
					mcv.setMem_id(service.boardShow().get(i).getMem_id());
					for(int j = 0; j<service.receiveCheck().size(); j++){
						if(service.receiveCheck().get(j).getMem_id().equals(service.boardShow().get(i).getMem_id())){
							int receiveMoney = service.receiveCheck().get(j).getMem_cash();
							service.receiveCheck().get(j).setMem_cash(receiveMoney + service.boardShow().get(i).getMempro_price());
							service.memCellList().add(mcv);
							break;
						}
					}
					service.boardShow().remove(i);
				}else{
					break;
				}
			}
		}
		
	}
		
}
