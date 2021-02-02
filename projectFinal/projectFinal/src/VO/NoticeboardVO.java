package VO;

import java.util.Calendar;


////////안쓰는거//////////////
public class NoticeboardVO {
	private int nb_id; // 게시글 아이디

	private boolean limit = true; // 게시글 활성화 여부
	
	private String mem_id; //  회원 아이디
	
	

	public int getNb_id() {
		return nb_id;
	}

	public void setNb_id(int nb_id) {
		this.nb_id = nb_id;
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

}
