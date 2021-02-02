package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

public class Imservice implements Service {
	private Dbclass db = new Dbclass();
	/**
	 * 로그인을 위한 메서드
	 * @param login
	 * @return 로그인 한 사람의 객체
	 */
	@Override
	public MemberVO logIn(Map<String, String> login) {
		MemberVO result = db.logIn(login);
		return result;
	}
	/**
	 * 회원가입을 위한 메서드
	 * @param mv
	 * @return null
	 */
	@Override
	public void memberInsert(MemberVO mv) {
		db.memberInsert(mv);
	}
	/**
	 * 아이디 중복체크 검사하는 메서드
	 * @param id
	 * @return 아이디가 중복되면 
	 */
	@Override
	public boolean iDcheck(String id) {
		return db.iDcheck(id);
	}
	
	/**
	 * 상단 배너
	 * @return BnnerVo타입의 배너리스트
	 */
	@Override
	public List<BannerVO> bannerShow() {
		return db.bannerShow();
	}
	/**
	 *  나의 아이템 조회 메서드
	 *  @return 나의 새로운 장바구니
	 *  원래 바구니에서 내꺼만 골라서 새로운 바구니에 담음
	 */
	@Override
	public List<MyItemView> myItemList(MemberVO mv) {
		return db.myItemShow(mv);
	}
	/**
	 * 아이템 샵 목록 리스트
	 * @김시용
	 * @return itemVO타입의 itemList
	 */
	@Override
	public List<ItemVO> itemShop() {
		return db.itemShop();
	}
	/**
	 * 아이템 사면 내 아이템으로 가지기
	 * @return null
	 */
	public void myItemAdd(MyItemView miv){
		db.myItemAdd(miv);
	}
	
	/**
	 * 회원을 조회하는 메서드
	 * @return 멤버타입의 회원 리스트를 반환
	 */
	 @Override
	 public ArrayList<MemberVO> viewList() {
	     return (ArrayList<MemberVO>) db.showMv();
	 }
	@Override
	/**
	 * 아이템을 환불하는 메서드
	 * @return 아이템리스트 반환
	 */
	public List<MyItemView> itemRefund() {
		return db.itemRefund();
	}
	/**
	 * 멤버삭제 메서드
	 * @param 회원아이디
	 * @return 
	 */
	@Override
	public boolean deleteMv(String mem_id) {
		return db.deleteMv(mem_id);
	}
	
	/**
	 * 광고 정보를 넘기는 메서드
	 * @param bv
	 * @author 유림
	 */
	@Override
	public void addCv(BannerVO bv) {
		db.bannerInsert(bv);
		
	}
	/**
	 * 배너 삭제
	 */
	@Override
	public boolean bannerDelete(int banner_id) {
		return db.deleteCv(banner_id);
	}
	/**
	 * 전체 카테고리를 조회하는 메서드
	 * @author 소형
	 * @return 전체 카테고리 리스트
	 */
	@Override
	public List<CategoryVO> allCateList() {
		return db.allCateList();
	}
	
	/**
	 * 카테고리 아이디로 카테고리 객체를 검색하는 메서드
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리 아이디에 해당하는 카테고리 객체
	 */
	public CategoryVO cateSearch(int cate_id){
		return db.cateSearch(cate_id);
	}
	
	/**
	 * 카테고리 수정을 위한 메서드
	 * @author 소형
	 * @param 수정할 내용을 담고있는 카테고리 객체
	 * @return 수정된 카테고리 이름
	 */
	public String cateUpdate(CategoryVO cv){
		return db.cateUpdate(cv);
	}

	/**
	 * 카테고리 이름 중복 여부 확인 메서드
	 * @author 소형
	 * @param 카테고리 이름
	 * @return 카테고리 이름이 중복되면 true, 중복되지 않으면 false
	 */
	public boolean cateNamecheck(String cate_name){
		return db.cateNamecheck(cate_name);
	}
	
	/**
	 * 카테고리 삭제를 위한 메서드
	 * @author 소형
	 * @param 삭제할 카테고리 객체
	 * @return 
	 */
	public boolean cateDelete(CategoryVO cv){
		return db.cateDelete(cv);
	}
	
	/**
	 * 관리자-카테고리 추가를 위한 메서드
	 * 
	 * @param cate_name
	 * @return 카테고리 아이디를 추가 했으면 true, 추가하지 못하면 false
	 */
	public boolean cateInsert(CategoryVO cv){
		return db.cateInsert(cv);
	}
	
	/**
	 * 회원 구매내역을 위한 메서드
	 * @author 시용
	 * @return 구매내역리스트 반환
	 */
	@Override
	public List<MyBuyView> memBuyList() {
		return db.memBuyList();
	}
	/**
	 * 회원 구매내역을 위한 메서드
	 * @author 시용
	 * @return 구매내역리스트 반환
	 */
	@Override
	public List<MyCellView> memCellList() {
		return db.memCellList();
	}
	//----------------------------------------------------------------
	@Override
	public List<MessageVO> memMessage() {
		return db.memMessage();
	}
	/**
	 * 메세지 보내기 함수
	 * @author 시용
	 * @param 메세지객체
	 */
	@Override
	public void sendMessage(MessageVO mg) {
		db.sendMessage(mg);
	}
	@Override
	public List<MemberVO> receiveCheck() {
		return db.receiveCheck();
	}

	/**
	 * 전체 상품거래게시글 리스트 조회
	 * @author 소형
	 * @return 전체 상춤거래게시글 리스트
	 */
	public List<MemberProductVO> boardShow(){
		return db.boardShow();
	}
	@Override
	/**
	 * 카테고리별 상품거래게시글 조회
	 * @author 소형
	 * @param 카테고리 아이디
	 * @return 카테고리별 상품거래게시글
	 */
	public List<MemberProductVO> showMemProByCate(int cate_id){
		return db.showMemProByCate(cate_id);
	}
	
	/**
	 * 작성한 게시글 추가
	 * @author 소형
	 * @return 작성한 게시글 추가가 완료되면 true, 아니면 false
	 */
	public boolean memProAdd(MemberProductVO mpv){
		return db.memProAdd(mpv);
	}
}
