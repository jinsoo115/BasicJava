package VO;

import java.util.Calendar;

public class MemberProductVO {
	private int mempro_id; // 상품아이디 (기본키)
	private String mempro_title; // 게시글 제목
	private Calendar mempro_date; // 게시글 날짜
	private int mempro_price; // 상품가격
	private String mempro_name; // 상품이름
	private String mempro_content; //상품설명
	private boolean limit = true; //상품 제한여부
	
	private String mem_id;	// 멤버 아이디 (외래키)
	private int cate_id; // 카테고리 아이디 (외래키)
	
	public int getMempro_id() {
		return mempro_id;
	}
	public void setMempro_id(int mempro_id) {
		this.mempro_id = mempro_id;
	}
	public String getMempro_title() {
		return mempro_title;
	}
	public void setMempro_title(String mempro_title) {
		this.mempro_title = mempro_title;
	}
	public Calendar getMempro_date() {
		return mempro_date;
	}
	public void setMempro_date(Calendar mempro_date) {
		this.mempro_date = mempro_date;
	}
	public int getMempro_price() {
		return mempro_price;
	}
	public void setMempro_price(int mempro_price) {
		this.mempro_price = mempro_price;
	}
	public String getMempro_name() {
		return mempro_name;
	}
	public void setMempro_name(String mempro_name) {
		this.mempro_name = mempro_name;
	}
	public String getMempro_content() {
		return mempro_content;
	}
	public void setMempro_content(String mempro_content) {
		this.mempro_content = mempro_content;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public int getCate_id() {
		return cate_id;
	}
	public void setCate_id(int cate_id) {
		this.cate_id = cate_id;
	}

	
}
