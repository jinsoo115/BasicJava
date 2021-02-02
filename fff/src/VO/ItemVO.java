package VO;

public class ItemVO {
	private int item_id; // 아이템 아이디 (기본키)
	private int item_price; //  아이템 가격
	private String item_name; // 아이템 이름 
	private String item_content; // 아이템 설명
	private boolean limit = true; // 아이템 활성화 여부	
	
	private static int item_sq = 0; // 아이템 아이디 자동생성
	{
		item_id = item_sq;
		item_sq++;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}
	public int getItem_price() {
		return item_price;
	}
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public static int getItem_sq() {
		return item_sq;
	}
	public static void setItem_sq(int item_sq) {
		ItemVO.item_sq = item_sq;
	}
	
	

	
	
}
