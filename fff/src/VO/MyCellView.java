package VO;

public class MyCellView {
	private int mycell_id;	// 판매내역 아이디(기본키)

	private String mycell_buyer_id;		// 구매자 아이디
	
	private int mempro_id;		// 상품아이디 (외래키)
	private String mempro_name;	// 상품 이름
	private int mempro_price;	// 상품 가격
	
	private String mem_id;			// 조회자 아이디(외래키)
	
	private static int mycell_sq = 0;
	{
		mycell_id = mycell_sq;
		mycell_sq++;
	}
	public int getMycell_id() {
		return mycell_id;
	}
	public void setMycell_id(int mycell_id) {
		this.mycell_id = mycell_id;
	}
	public String getMycell_buyer_id() {
		return mycell_buyer_id;
	}
	public void setMycell_buyer_id(String mycell_buyer_id) {
		this.mycell_buyer_id = mycell_buyer_id;
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
	public static int getMycell_sq() {
		return mycell_sq;
	}
	public static void setMycell_sq(int mycell_sq) {
		MyCellView.mycell_sq = mycell_sq;
	}
	

	
	
}