package VO;

public class CategoryVO {
	private int cate_id; // 카테고리 아이디 (기본키)
	private String cate_name; // 카테고리 이름
	private boolean limit = true; //카테고리 활성화 여부
	
	
	static int cate_sq = 0; // 카테고리 아이디 자동 생성
	{
		cate_id = cate_sq;
		cate_sq++;
	}
	
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public static int getCate_sq() {
		return cate_sq;
	}
	public static void setCate_sq(int cate_sq) {
		CategoryVO.cate_sq = cate_sq;
	}
	
}
