package VO;

public class MyBuyView {
	private int mybuy_id;	// 구매내역 아이디(기본키)

	private String mybuy_celler_id;		// 판매자 아이디
	
	private int mempro_id;		// 상품아이디 (외래키)
	private String mempro_name;	// 상품 이름
	private int mempro_price;	// 상품 가격
	
	private String mem_id;			// 조회자 아이디(외래키)
	
	private static int mybuy_sq = 0;
	{
		mybuy_id = mybuy_sq;
		mybuy_sq++;
	}
	public int getMybuy_id() {
		return mybuy_id;
	}
	public void setMybuy_id(int mybuy_id) {
		this.mybuy_id = mybuy_id;
	}
	public String getMybuy_celler_id() {
		return mybuy_celler_id;
	}
	public void setMybuy_celler_id(String mybuy_celler_id) {
		this.mybuy_celler_id = mybuy_celler_id;
	}
	public int getMempro_id() {
		return mempro_id;
	}
	public void setMempro_id(int mempro_id) {
		this.mempro_id = mempro_id;
	}

	public String getMempro_name() {
		return mempro_name;
	}
	public void setMempro_name(String mempro_name) {
		this.mempro_name = mempro_name;
	}
	public int getMempro_price() {
		return mempro_price;
	}
	public void setMempro_price(int mempro_price) {
		this.mempro_price = mempro_price;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public static int getMybuy_sq() {
		return mybuy_sq;
	}
	public static void setMybuy_sq(int mybuy_sq) {
		MyBuyView.mybuy_sq = mybuy_sq;
	}
	


}
