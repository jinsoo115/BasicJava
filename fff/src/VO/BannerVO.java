package VO;

public class BannerVO {
	private int banner_id; // 배너 아이디
	private String banner_name; // 배너 제목
	private String banner_content; // 배너 내용
	private boolean limit = true;  // 배너 활성화 여부
	private static int banner_sq = 0; // 배너 아이디 자동생성
	{
		banner_id = banner_sq;
		banner_sq++;
	}
	public int getBanner_id() {
		return banner_id;
	}
	public void setBanner_id(int banner_id) {
		this.banner_id = banner_id;
	}
	public String getBanner_name() {
		return banner_name;
	}
	public void setBanner_name(String banner_name) {
		this.banner_name = banner_name;
	}
	public String getBanner_content() {
		return banner_content;
	}
	public void setBanner_content(String banner_content) {
		this.banner_content = banner_content;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public static int getBanner_sq() {
		return banner_sq;
	}
	public static void setBanner_sq(int banner_sq) {
		BannerVO.banner_sq = banner_sq;
	}
	
}
