package VO;

public class MyItemView {
	private int myItem_id; // 아이템 구매내역 아이디(기본키)
	private boolean limit = true;  // 아이템 활성화 여부
	
	private int item_id; // 아이템 아이디(외래키)
	private String item_name; // 아이템 이름
	private int item_price; // 아이템 가격
	private int myItem_amount; // 아이템 수량	
	private String mem_id;			// 조회자 아이디(외래키)
	
	public int getMyItem_id() {
		return myItem_id;
	}
	public void setMyItem_id(int myItem_id) {
		this.myItem_id = myItem_id;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public int getItem_id() {
		return item_id;
	}
	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public int getItem_price() {
		return item_price;
	}
	
	public void setItem_price(int item_price) {
		this.item_price = item_price;
	}
	public int getMyItem_amount() {
		return myItem_amount;
	}
	public void setMyItem_amount(int myItem_amount) {
		this.myItem_amount = myItem_amount;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	

}
