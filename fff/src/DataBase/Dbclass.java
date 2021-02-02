package DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import VO.*;

public class Dbclass {

	List<MemberVO> memberList = new ArrayList<MemberVO>(); // 회원 리스트

	List<ItemVO> itemList = new ArrayList<ItemVO>(); // 아이템 리스트
	List<MyItemView> MyitemList = new ArrayList<MyItemView>(); // 내 아이템 조회를 위한
																// 리스트

	List<CategoryVO> categoryList = new ArrayList<CategoryVO>(); // 카테고리 리스트
	List<MemberProductVO> memProductList = new ArrayList<MemberProductVO>(); // 회원의
																				// 위한
	List<MyBuyView> buyList = new ArrayList<MyBuyView>(); // 구매내역 리스트
	List<MyCellView> cellList = new ArrayList<MyCellView>(); // 판매내역 리스트

	List<BannerVO> bannerList = new ArrayList<BannerVO>(); // 배너 리스트
	List<MessageVO> messageList = new ArrayList<MessageVO>();// 메세지 리스트
	
	//메세지 내역 초기화
	{
		MessageVO mg = new MessageVO();
		mg.setTitle("신발문의");
		mg.setConcent("좀만 깍아주시면 안되나여??");
		mg.setReceive_id("siyong");
		mg.setSend_id("youlim");
		messageList.add(mg);
		
		MessageVO mg2 = new MessageVO();
		mg2.setTitle("뭐하세여");
		mg2.setConcent("답장좀요");
		mg2.setReceive_id("siyong");
		mg2.setSend_id("sohyung");
		messageList.add(mg2);
		
		MessageVO mg3 = new MessageVO();
		mg3.setTitle("읽어라!!");
		mg3.setConcent("읽어라");
		mg3.setReceive_id("sohyung");
		mg3.setSend_id("siyong");
		messageList.add(mg3);
		
		MessageVO mg4 = new MessageVO();
		mg4.setTitle("내일구매");
		mg4.setConcent("읽어주세요");
		mg4.setReceive_id("youlim");
		mg4.setSend_id("siyong");
		messageList.add(mg4);
	}
	
	// 판매내역 초기화
	{
		MyCellView myCellList = new MyCellView();
		myCellList.setMempro_name("후리스");
		myCellList.setMempro_price(30000);
		myCellList.setMem_id("siyong");
		myCellList.setMycell_buyer_id("sohyung");
		cellList.add(myCellList);
		
		MyCellView myCellList2 = new MyCellView();
		myCellList2.setMempro_name("맨투맨");
		myCellList2.setMempro_price(20000);
		myCellList2.setMem_id("siyong");
		myCellList2.setMycell_buyer_id("youlim");
		cellList.add(myCellList2);
		
	}
	// 구매내역 초기화
	{
		MyBuyView myBuyList = new MyBuyView();
		myBuyList.setMem_id("siyong");
		myBuyList.setMempro_name("아디다스");
		myBuyList.setMempro_price(100000);
		myBuyList.setMybuy_celler_id("youlim");
		buyList.add(myBuyList);
		
		
		MyBuyView myBuyList2 = new MyBuyView();
		myBuyList2.setMem_id("siyong");
		myBuyList2.setMempro_name("마우스");
		myBuyList2.setMempro_price(5000);
		myBuyList2.setMybuy_celler_id("sohyung");
		buyList.add(myBuyList2);
	}

	// 내 아이템 리스트 초기화
	/*{
		MyItemView iv = new MyItemView();
		iv.setItem_name("슈퍼리스트");
		iv.setMyItem_amount(1);
		iv.setMem_id("siyong");
		MyitemList.add(iv);

		MyItemView iv2 = new MyItemView();
		iv2.setItem_name("슈퍼리스트");
		iv2.setMyItem_amount(1);
		iv2.setMem_id("hyunwoo");
		MyitemList.add(iv2);

		MyItemView iv3 = new MyItemView();
		iv3.setItem_name("슈퍼리스트");
		iv3.setMyItem_amount(1);
		iv3.setMem_id("sohyung");
		MyitemList.add(iv3);
	}*/
	// 게시판 카테고리 별 상품 초기화
	{
		MemberProductVO mp = new MemberProductVO();
		mp.setMempro_title("아이폰 팔아요!!@!!");
		mp.setMempro_content("1년 사용했어요.");
		mp.setMempro_name("아이폰");
		mp.setMempro_price(300000);
		mp.setMem_id("siyong");
		mp.setCate_id(0);
		memProductList.add(mp);

		MemberProductVO mp2 = new MemberProductVO();
		mp2.setMempro_title("아이다스 신발 팔아욧!");
		mp2.setMempro_content("6개월 사용했어요.");
		mp2.setMempro_name("아디다스신발");
		mp2.setMempro_price(100000);
		mp2.setMem_id("hyunwoo");
		mp2.setCate_id(1);
		memProductList.add(mp2);

		MemberProductVO mp3 = new MemberProductVO();
		mp3.setMempro_title("식기도구 팔아요");
		mp3.setMempro_content("3개월 사용했어요.");
		mp3.setMempro_name("국자");
		mp3.setMempro_price(5000);
		mp3.setMem_id("sohyung");
		mp3.setCate_id(2);
		memProductList.add(mp3);

		MemberProductVO mp4 = new MemberProductVO();
		mp4.setMempro_title("쇼파팔아욧!!@!!");
		mp4.setMempro_content("1개월 사용했어요.");
		mp4.setMempro_name("쇼파");
		mp4.setMempro_price(500000);
		mp4.setMem_id("siyong");
		mp4.setCate_id(3);
		memProductList.add(mp4);

		MemberProductVO mp5 = new MemberProductVO();
		mp5.setMempro_title("베스트셀러 팔아용!");
		mp5.setMempro_content("3일 사용했어요.");
		mp5.setMempro_name("책");
		mp5.setMempro_price(30000);
		mp5.setMem_id("youlim");
		mp5.setCate_id(4);
		memProductList.add(mp5);
		
		MemberProductVO mp6 = new MemberProductVO();
		mp6.setMempro_title("참고서 팔아용!");
		mp6.setMempro_content("3일 사용했어요.");
		mp6.setMempro_name("책");
		mp6.setMempro_price(300000000);
		mp6.setMem_id("youlim");
		mp6.setCate_id(4);
		memProductList.add(mp6);
		
		MemberProductVO mp7 = new MemberProductVO();
		mp7.setMempro_title("[공지]사기치지마세요");
		mp7.setMempro_content("사기치다 걸리면 손모가지");
		mp7.setMem_id("root");
		memProductList.add(mp7);
		
	}

	// 광고 목록 초기화
	{
		BannerVO bv = new BannerVO();
		bv.setBanner_name("나이키");
		bv.setBanner_content("신발은 나이키~!@#");
		bannerList.add(bv);
		
		BannerVO bv2 = new BannerVO();
		bv2.setBanner_name("삼성");
		bv2.setBanner_content("핸드폰은 삼성!@#");
		bannerList.add(bv2);
		
		BannerVO bv3 = new BannerVO();
		bv3.setBanner_name("개발원");
		bv3.setBanner_content("IT는 역시 대덕인재개발원~!@#");
		bannerList.add(bv3);
	}

	// 카테고리 목록 초기화
	{
		CategoryVO cv = new CategoryVO();
		cv.setCate_name("전자제품");
		categoryList.add(cv);

		CategoryVO cv2 = new CategoryVO();
		cv2.setCate_name("의류");
		categoryList.add(cv2);

		CategoryVO cv3 = new CategoryVO();
		cv3.setCate_name("생활용품");
		categoryList.add(cv3);

		CategoryVO cv4 = new CategoryVO();
		cv4.setCate_name("가구");
		categoryList.add(cv4);

		CategoryVO cv5 = new CategoryVO();
		cv5.setCate_name("도서");
		categoryList.add(cv5);
	}
	// 아이템 목록 초기화
	{
		ItemVO iv = new ItemVO();
		iv.setItem_name("슈퍼리스트");
		iv.setItem_price(1000);
		iv.setItem_content("게시판의 최상단으로 올려줍니다.");
		itemList.add(iv);

		ItemVO iv2 = new ItemVO();
		iv2.setItem_name("파워리스트");
		iv2.setItem_price(1000);
		iv2.setItem_content("게시글을 강조 해줍니다.");
		itemList.add(iv2);
	}
	// 관리자 계정 초기화
	{
		MemberVO admin = new MemberVO();
		admin.setMem_id("root");
		admin.setMem_pw("root");
		admin.setMem_name("관리자");
		admin.setMem_birth("1995-03-15");
		admin.setMem_cash(9999);
		admin.setMem_phone("010-1234-1234");
		admin.setAdmin(true);
		memberList.add(admin);

		MemberVO member = new MemberVO();
		member.setMem_id("siyong");
		member.setMem_pw("siyong");
		member.setMem_name("김시용");
		member.setMem_birth("1995-04-10");
		member.setMem_cash(30000);
		member.setMem_phone("010-1234-1234");
		member.setLimit(true);
		memberList.add(member);

		MemberVO member2 = new MemberVO();
		member2.setMem_id("sohyung");
		member2.setMem_pw("sohyung");
		member2.setMem_name("김소형");
		member2.setMem_birth("1995-03-15");
		member2.setMem_cash(50000);
		member2.setMem_phone("010-1234-1234");
		member2.setLimit(true);
		memberList.add(member2);

		MemberVO member3 = new MemberVO();
		member3.setMem_id("hyunwoo");
		member3.setMem_pw("hyunwoo");
		member3.setMem_name("장현우");
		member3.setMem_birth("1995-05-15");
		member3.setMem_cash(50000);
		member3.setMem_phone("010-1234-1234");
		member3.setLimit(true);
		memberList.add(member3);

		MemberVO member4 = new MemberVO();
		member4.setMem_id("youlim");
		member4.setMem_pw("youlim");
		member4.setMem_name("이유림");
		member4.setMem_birth("1995-11-15");
		member4.setMem_cash(50000);
		member4.setMem_phone("010-1234-1234");
		member4.setLimit(true);
		memberList.add(member4);
	}

	/**
	 * 넘어온 값을 멤버리스트와 비교하는 메서드
	 * 
	 * @param login
	 * @return 로그인한 사람의 객체
	 */
	public MemberVO logIn(Map<String, String> login) {
		MemberVO mv = null;
		String mem_id = login.get("mem_id");
		String mem_pw = login.get("mem_pw");
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMem_id().equals(mem_id)
					&& memberList.get(i).getMem_pw().equals(mem_pw)) {
				mv = memberList.get(i);
				break;
			}
		}
		return mv;
	}

	/**
	 * 회원가입을 위해 넘어온 멤버타입 객체를 멤버리스트에 넣는 메서드
	 * 
	 * @param mv
	 * @return null
	 */
	public void memberInsert(MemberVO mv) {
		memberList.add(mv);
	}

	/**
	 * 아이디 중복체크 검사하는 메서드
	 * 
	 * @param id
	 * @return check가 중복되면 true 중복되지 않으면 false
	 */
	public boolean iDcheck(String id) {
		boolean check = false;
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMem_id().equals(id)) {
				check = true;
				return true;
			} else {
				check = false;
			}
		}
		return check;

	}

	/**
	 * 상단 배너
	 * @return BnnerVo타입의 배너리스트
	 */

	public List<BannerVO> bannerShow() {
		return bannerList;
	}

	/**
	 *  나의 아이템 조회 메서드
	 *  @return 나의 새로운 장바구니
	 *  원래 바구니에서 내꺼만 골라서 새로운 바구니에 담음
	 */
	public List<MyItemView> myItemShow(MemberVO mv) {
		List<MyItemView> newMyitemList = new ArrayList<MyItemView>();
		int i = 1;
		for (int j = 0; j < MyitemList.size(); j++) {
			if (mv.getMem_id().equals(MyitemList.get(j).getMem_id())) {
				MyitemList.get(j).setItem_id(i++);
				newMyitemList.add(MyitemList.get(j));
			}
		}

		return newMyitemList;
	}
	/**
	 * 아이템 샵 목록 리스트
	 * @김시용
	 * @return itemVO타입의 itemList
	 */
	public List<ItemVO> itemShop() {
		return itemList;
	}

	/**
	 * 아이템 사면 내 아이템으로 가지기
	 * @return null
	 */
	public void myItemAdd(MyItemView miv) {
		MyitemList.add(miv);
	}

	/**
	 * 회원을 조회하는 메서드
	 * @return 멤버타입의 회원 리스트를 반환
	 * 
	 */
	public List<MemberVO> showMv() {
		List<MemberVO> mList = new ArrayList<MemberVO>();

		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).isLimit()) {
				mList.add(memberList.get(i));
			}
		}
		return mList;
	}
	/**
	 * 아이템을 환불하는 메서드
	 * @return 아이템리스트 반환
	 */
	public List<MyItemView> itemRefund(){
		return MyitemList;
	}
	
	
	
	/**
	 * 회원을 삭제하는 메서드
	 * @param 회원 아이디
	 * @return true면 회원을 제거하고 true반환 false면 잘못 입력한
	 * 경우 false 반환 
	 */
	public boolean deleteMv(String mem_id) {
		for (int i = 0; i < memberList.size(); i++) {
			if (memberList.get(i).getMem_id().equals(mem_id)
					&& memberList.get(i).isLimit()) {
				memberList.get(i).setLimit(false);
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * @author 유림
	 * @param banner_id
	 * @return 삭제되었으면 isLimit false, 삭제가 안되었으면 true반환
	 */
	public boolean deleteCv(int banner_id) {
		boolean result = false;
		BannerVO cvo2 = null;
		for (BannerVO cvo : bannerList) {
			if (cvo.isLimit() && cvo.getBanner_id() == banner_id) {
				cvo2 = cvo;
				result = true;
			}
		}
		if (result) {
			cvo2.setLimit(false);
		}
		return result;
	}
	
	/**
	 * 광고 추가로 넘기는 메서드
	 * @param bv
	 * @return
	 * @author 유림
	 */
	public void bannerInsert(BannerVO bv){
		bannerList.add(bv);
	}
	
	/**
	 * 전체 카테고리 리스트 조회 메서드
	 * @author 소형
	 * @return 전체 카테고리 리스트
	 */
	public List<CategoryVO> allCateList() {
		List<CategoryVO> limitList = new ArrayList<CategoryVO>();
		for (int i=0; i<categoryList.size(); i++) {
			if (categoryList.get(i).isLimit()) {
				limitList.add(categoryList.get(i));
			}
		}
		return limitList;
	}
	
	/**
	 * 카테고리 이름 중복 여부 확인 메서드
	 * @author 소형
	 * @param 카테고리 이름
	 * @return 카테고리 이름이 중복되면 true, 중복되지 않으면 false
	 */
	public boolean cateNamecheck(String cate_name) {
		boolean check = false;

		for(int i = 0; i<categoryList.size(); i++){
			if(categoryList.get(i).getCate_name().equals(cate_name)){
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * 카테고리 아이디로 카테고리 객체를 검색하는 메서드
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리 아이디에 해당하는 카테고리 객체
	 */
	public CategoryVO cateSearch(int cate_id) {
		CategoryVO cv = null;
		for(int i=0; i<categoryList.size(); i++){
			if(categoryList.get(i).isLimit() && categoryList.get(i).getCate_id() == cate_id){
				cv = categoryList.get(i);
			}
		}
		return cv;
	}
	
	/**
	 * 카테고리 수정을 위한 메서드
	 * @author 소형
	 * @param 수정할 내용을 담고있는 카테고리 객체
	 * @return 수정된 카테고리 이름
	 */
	public String cateUpdate(CategoryVO cv) {
		
		int cate_id = cv.getCate_id();
		String cate_name = cv.getCate_name();
		
		categoryList.get(cate_id).setCate_name(cate_name);
		
		return categoryList.get(cate_id).getCate_name();
	}
	
	/**
	 * 카테고리 삭제를 위한 메서드
	 * @author 소형
	 * @param 삭제할 내용을 담고 있는 카테고리 객체 
	 * @return 
	 */
	public boolean cateDelete(CategoryVO cv) {
		boolean check = false;
		
		for(int i=0; i<categoryList.size(); i++){
			if(categoryList.get(i).getCate_id()==cv.getCate_id() && categoryList.get(cv.getCate_id()).isLimit()){
				categoryList.get(i).setLimit(false);
				check = true;
			}
		}
		return check;
	}
	
	/**
	 * 관리자-카테고리 추가를 위한 메서드
	 * @author 소형
	 * @param 카테고리 아이디를 추가했으면 true, 그렇지 않으면 false
	 */
	public boolean cateInsert(CategoryVO cv) {
		return categoryList.add(cv);		
	}	
	
	/**
	 * 구매 내역 조회를 위한 메서드
	 * @author 시용
	 * @return 구매 내역리스트 넘김
	 */
	public List<MyBuyView> memBuyList(){
		return buyList;
	}
	
	/**
	 * 판매 내역 조회를 위한 메서드
	 * @author 시용
	 * @return 판매 내역리스트 넘김
	 */
	public List<MyCellView> memCellList(){
		return cellList;
	}
	/**
	 * 메세지 내역을 가져오는 메서드
	 * @author 시용
	 * @return 메세지 내역 리스트
	 */
	public List<MessageVO> memMessage(){
		return messageList;
	}
	/**
	 * 메세지 보내기 메서드
	 * @author 시용
	 * @return null
	 */
	public void sendMessage(MessageVO mg){
		messageList.add(mg);
	}
	/**
	 * 메세지 보낼때 받는 사람 check하는 메서드
	 * @author 시용
	 * @return memberList
	 */
	public List<MemberVO> receiveCheck(){
		return memberList;
	}
	
	/**
	 * 전체 상품거래게시글 리스트 조회
	 * @author 소형
	 * @return 전체 상춤거래게시글 리스트
	 */
	public List<MemberProductVO> boardShow(){
		return memProductList;
	}
	
	/**
	 * 카테고리별 상품거래게시글 조회
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리별 상품거래게시글
	 */
	public List<MemberProductVO> showMemProByCate(int cate_id) {
		List<MemberProductVO> list = new ArrayList<MemberProductVO>();
		for(MemberProductVO mpv : memProductList){
			if(mpv.isLimit() && mpv.getCate_id() == cate_id){
				list.add(mpv);
			}
		}
		return list;
	}
	/**
	 * 작성한 게시글 추가
	 * @author 소형
	 * @return 작성한 게시글 추가가 완료되면 true, 아니면 false
	 */
	public boolean memProAdd(MemberProductVO mpv){
		return memProductList.add(mpv);
	}
}
