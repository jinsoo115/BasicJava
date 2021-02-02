package JinSoo;

public class Member {
	
	String id; //아이디
	String password; //비밀번호
	int accountNumber; //계좌번호
	int accountMoney;//계좌금액
	int loanAccount;//대출계좌금액
	int memberNum;//로그인 넘버
	int usd;//달러
	int eur;//유로
	int jpy;//엔화
	int cny;//위안
	int gbp;//파운드
	int chf;//프랑
	int[] stockAccount;//주식계좌
	Stock stock;
	Member(String id, String password, int accountNumber, int memberNum) {
		this.id=id;
		this.password=password;
		this.accountNumber=accountNumber;	
		this.accountMoney = 0;//계좌금액
		this.loanAccount = 0;//대출계좌금액
		this.memberNum = memberNum;//로그인 넘버
		this.usd=0;//달러
		this.eur=0;//유로
		this.jpy=0;//엔화
		this.cny=0;//위안
		this.gbp=0;//파운드
		this.chf=0;//프랑
		stockAccount= new int[10];
	}
	void show(){
		System.out.println(id);
		System.out.println(password);
		System.out.println(accountNumber);
	}
	String memberInfo(){
		String info = "아이디: " + id;
		info += "비밀번호: " + password;
		info += "계좌번호: " + accountNumber;
		info += "계좌금액: " + accountMoney;
		info += "멤버 넘버: " + memberNum;
 		return info;
		
	}
		
}
