package JinSoo;

import e_oop.ScanUtil;

public class Bank {
	/*
	 * 은행 * 회원가입* 로그인* 계좌확인* 입금* 출금
	 * 대출(대출을 받으면 바로 이자2% 바로 추가)(대출 계좌 따로)* 대출금 갚기
	 * 외환 사기 달러(1달러당 1086~1189),엔화(일본 100엔당 1046~1120),유로(유럽 1유로당 1310~1409),
	 * 파운드(영국 1파운드당 1460~1580),위안(짱깨 1위안당 166~175),프랑(스위스 1프랑당 1212~1306)
	 * 외환 팔기? 계좌이체? 주식? 
	 */
	Sign sign;
	DepWit depWit;
	Stock stock;
	int signNum;
	Bank(){
		sign = new Sign();
		depWit = new DepWit(sign);
		stock = new Stock(sign);
	}
	public static void main(String[] args) {
		new Bank().Start();
	}	
	void Start(){
		int memberNum=0;
		
		while(true){
			if(!sign.login){
				System.out.println("------------------------------------");
				System.out.println("1.회원가입\t2.로그인\t0.종료");
				System.out.println("------------------------------------");
				System.out.print("실행할 번호 입력>");
				int input = ScanUtil.nextInt();
				if(1 != input && 0 != input){
					if(sign.members[0] == null){
						System.out.println("아이디가 없습니다.");
						continue;
					}
				}
				switch (input) {
				case 1://회원가입
					sign.signIn();
					break;
				case 2://로그인
					memberNum = sign.login();
					break;
				case 9://계좌확인용
					sign.showSign();
					break;
				case 0://종료
					System.out.print("종료 하셨습니다");
					System.exit(0);
				}
			}
			if(sign.login){
				System.out.println("------------------------------------");
				System.out.println("1.계좌확인\t2.입금\t3.출금\t4.이체");
				System.out.println("5.대출\t6.대출상환\t7.외화거래\t8.주식");
				System.out.println("11.로그아웃\t0.종료");
				System.out.println("------------------------------------");
				System.out.print("실행할 번호 입력>");
				int input = ScanUtil.nextInt();
				switch (input) {
				case 1://계좌확인
					depWit.account(memberNum);
					break;
				case 2://입금
					depWit.deposit(memberNum);
					break;
				case 3://출금
					depWit.withdraw(memberNum);
					break;
				case 4://이체
					depWit.transfer(memberNum);
					break;
				case 5://대출
					depWit.loan(memberNum);
					break;
				case 6://대출상환
					depWit.loanRepay(memberNum);
					break;
				case 7://외화거래
					depWit.forex(memberNum);
					break;
				case 8://주식
					stock.stockList(memberNum);
					break;
				case 9://계정 확인용
					sign.showSign();
					break;
				case 11://로그아웃
					sign.logout();
					break;
				case 0://종료
					System.out.print("종료 하셨습니다");
					System.exit(0);
				}
			}
		}
	}
}
