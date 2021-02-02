package VO;

import java.util.ArrayList;
import java.util.List;

public class MemberVO {
	private String mem_id; //  회원 아이디 (기본키)
	private String mem_pw; // 회원 패스워드
	private String mem_name; // 회원 이름
	private String mem_phone; //  회원 핸드폰번호
	private String mem_birth;  // 회원 생년월일
	private int mem_cash; // 회원 캐시
	
	private boolean limit = true; //  회원 접근여부
	private boolean admin; // 관리자 권한 여부
	

	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_phone() {
		return mem_phone;
	}
	public void setMem_phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	public String getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}


	public int getMem_cash() {
		return mem_cash;
	}
	public void setMem_cash(int mem_cash) {
		this.mem_cash = mem_cash;
	}
	public boolean isLimit() {
		return limit;
	}
	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}
