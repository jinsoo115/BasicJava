package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import VO.BannerVO;
import VO.CategoryVO;
import VO.ItemVO;
import VO.MemberProductVO;
import VO.MemberVO;
import VO.MessageVO;
import VO.MyBuyView;
import VO.MyCellView;
import VO.MyItemView;

public interface Service {
	/**
	 * 로그인을 위한 메서드
	 * @param login
	 * @return 로그인한 사람의 객체
	 */
	MemberVO logIn(Map<String, String> login);
	/**
	 * 회원가입을 위한 메서드
	 * @param mv
	 * @return null
	 */
	void memberInsert(MemberVO mv);
	
	/**
	 * 아이디 중복체크 검사하는 메서드 
	 * @param id
	 * @return check가 중복되면 true 중복되지 않으면 false
	 */
	boolean iDcheck(String id);
	

	
	
	
	/**
	 * 광고조회
	 * 광고 전체 리스트를 불러오는 메서드
	 * @author 유림
	 * @return null
	 * @param  null
	 */
	List<BannerVO> bannerShow();
	/**
	 * 광고 추가
	 * 광고 정보를 위한 메서드
	 * 광고 상제조회
	 * @return  null
	 * @param null
	 * @author 유림
	 */
	void addCv(BannerVO bv);
	/**
	 * 광고 삭제 메서드
	 * 
	 * @author 유림
	 * @param 광고를 삭제하기 위해 광고의 id를 이용
	 * @return 해당 광고리스트에서 광고객체가 삭제되었는지 성공/실패 반환
	 */
	boolean bannerDelete(int banner_id);
	
	
	
	
	
	
	
	/**
	 *  나의 아이템 조회 메서드
	 *  @return 나의 새로운 장바구니
	 *  원래 바구니에서 내꺼만 골라서 새로운 바구니에 담음
	 */
	List<MyItemView> myItemList(MemberVO mv);
	/**
	 * 아이템 샵 목록 리스트
	 * @김시용
	 * @return itemVO타입의 itemList
	 */
	List<ItemVO> itemShop();
	/**
	 * 아이템 사면 내 아이템으로 가지기
	 * @return null
	 */
	void myItemAdd(MyItemView miv);
	
	/**관리자
	 * 회원을 조회하는 메서드
	 * @return 멤버타입의 회원 리스트를 반환
	 */
	ArrayList<MemberVO> viewList();
	/**
	 * 아이템을 환불을 위한 메서드
	 * @return ItemList
	 */
	List<MyItemView> itemRefund();
    /**
     * 회원 삭제 메서드
     * @param 회원아이디
     * @현우
     */
    boolean deleteMv(String mem_id);
	
	/**
	 * 전체 카테고리를 조회하는 메서드
	 * @author 소형
	 * @return 전체 카테고리 리스트
	 */
	List<CategoryVO> allCateList();
	
	/**
	 * 관리자-카테고리 아이디로 카테고리 객체를 검색하는 메서드
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리 아이디에 해당하는 카테고리 객체
	 */
	CategoryVO cateSearch(int cate_id);
	
	
	/**
	 * 관리자-카테고리 수정을 위한 메서드
	 * @author 소형
	 * @param 수정할 내용을 담고있는 카테고리 객체
	 * @return 수정된 카테고리 이름
	 */
	String cateUpdate(CategoryVO cv);
	
	/**
	 * 관리자-카테고리 이름 중복 여부 확인 메서드
	 * @author 소형
	 * @param 카테고리 이름
	 * @return 카테고리 이름이 중복되면 true, 중복되지 않으면 false
	 */
	boolean cateNamecheck(String cate_name);
	
	/**
	 * 관리자-카테고리 삭제를 위한 메서드 
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리 아이디를 삭제 가능하면 true, 가능하지 않으면 false
	 */
	boolean cateDelete(CategoryVO cv);
	
	/**
	 * 관리자-카테고리 추가를 위한 메서드
	 * @author 소형
	 * @param 추가할 카테고리 객체
	 * @return 카테고리 아이디를 추가 했으면 true, 추가하지 못하면 false
	 */
	boolean cateInsert(CategoryVO cv);
	
	
	/**
	 * 회원 구매내역 리스트 호출 함수
	 * @param null
	 * @return 회원 구매내역 리스트
	 * @author 시용
	 */
	List<MyBuyView> memBuyList();
	/**
	 * 회원 판매내역 리스트 호출 함수
	 * @param null
	 * @return 회원 판매내역 리스트
	 * @author 시용
	 */
	
	List<MyCellView> memCellList();
	/**
	 * 메세지 내역을 호출하는 함수
	 * @param null
	 * @return 메세지 내역 리스트
	 * @author 시용
	 */
	List<MessageVO> memMessage();
	/**
	 * 메세지 보내기 함수
	 * @author 시용
	 * @param 메세지객체
	 */
	void sendMessage(MessageVO mg);
	
	/**
	 * 메세지 보낼때 받는 사람 check하는 메서드
	 * @author 시용
	 * @return memberList
	 */
	List<MemberVO> receiveCheck();
	
//--------------------------------------------------------------------	
	
	/**
	 * 카테고리별 상품거래게시글 조회
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리별 상품거래게시글
	 */
	List<MemberProductVO> showMemProByCate(int cate_id);
	
	/**
	 * 전체 상품거래게시글 리스트 조회
	 * @author 소형
	 * @return 전체 상춤거래게시글 리스트
	 */
	List<MemberProductVO> boardShow();
	
	
	/**
	 * 작성한 게시글 추가
	 * @author 소형
	 * @return 작성한 게시글 추가가 완료되면 true, 아니면 false
	 */
	boolean memProAdd(MemberProductVO mpv);
	
	
	
	
	
	
	
	
	
	
//
//	
//	/**
//	 * 관리자-아이템 조회를 위한 메서드
//	 * @author 시용이가만들어놈 시용이가 붙여넣기
//	 * @return 전체 아이템 목록 
//	 */
//	//List<ItemVO> itemShow();
//	
//	/**
//	 * 관리자-아이템 수정을 위한 메서드
//	 * @author 시용
//	 * @param 아이템 아이디
//	 * @return 수정할 아이템 객체
//	 */
//	ItemVO itemUpdate(int item_id);
//	
//	/**
//	 * 관리자-아이템 삭제를 위한 메서드
//	 * @author 시용
//	 * @param 아이템 아이디
//	 * @return 삭제할 아이템 객체
//	 */
//	ItemVO itemDelete(int item_id);
//	
//	
//	//----------------------관리자-게시글조회---------------------------//
//    /**
//     * 전체 게시글 조회를 위한 메서드
//     * @author 
//     * @return 상품거래게시글 리스트
//     */
//    ArrayList<MemberProductVO> memproShow();
//
//	/**
//	 * 게시글 검색을 위한 메서드(게시글 안으로 들어가기)
//	 * @author 
//	 * @param 게시글 아이디 
//	 * @return 선택한 게시글 내용과 정보 확인을 위한 해당 게시글 객체
//	 */
//	MemberProductVO memproSearch(int mempro_id);
//    
//    /**
//     * 게시글 작성을 위한 메서드
//     * @author 
//     * @param 게시글 객체
//     * @return 게시글 추가가 되면 true, 안 되면 false  
//     */
//    boolean memprodAdd(MemberProductVO mpv);
//    
//    /**
//	 * 게시글 삭제를 위한 메서드
//	 * @author 
//	 * @param 게시글 아이디
//	 * @return 게시글 삭제가 되면 true, 안 되면 false
//	 */
//	boolean memproDelete(int mempro_id);
//	
//	/**
//	 * 상품 구매, 게시글 수정, 삭제 권한 체크를 위한 메서드
//	 * (상품구매 : 로그인한 회원과 게시글을 올린 회원의 ID가 다를 때 구매 가능 / 관리자는 상품 구매 불가 ==> 반환 값이 false일 때 가능)
//	 * (게시글 수정 : 로그인한 회원과 게시글을 올린 회원의 ID가 같을 때 수정 가능 ==> 반환 값이 true일 때 가능)
//	 * (게시글 삭제 : 로그인한 회원과 게시글을 올린 회원의 ID가 같을 때 삭제 가능 ==> 반환 값이 true일 때 가능)
//	 * @author 
//	 * @param params mempro_id, mem_admin, current_id
//	 * @return 로그인한 ID와 게시글을 올린 ID가 같을 때 true, 아니면 false
//	 */
//	boolean memproCheckAutho(Map<String, Object> params);
    
  


	
	
	
	
	
	
	
	
	
	
	
}
