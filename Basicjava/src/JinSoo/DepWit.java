package JinSoo;

import e_oop.ScanUtil;

public class DepWit {
	Forex forex;
	Member[] members;
	int money;
	int forexMoney;
	double loanInterest;
	int input;
	String country;
	int transferAccount;
	int check;

	DepWit(Sign sign){
		forex = new Forex(sign);
		this.members = sign.members;
		this.money =0;
		this.forexMoney=0;
		this.loanInterest=0.02;
		this.input=0;
		this.transferAccount=0;
		this.check=0;
	}

	int goBack(){//진행및 종료
		System.out.println("1.진행 0.종료 및 되돌아가기");
		System.out.print("실행하실 번호를 입력하세요>");
		return input = ScanUtil.nextInt();
	}

	void account(int memberNum){//계좌확인
		System.out.println("계좌번호: " + members[memberNum].accountNumber);
		System.out.println("입출금계좌: "+ members[memberNum].accountMoney + "원");
		System.out.println("대출계좌:" + (int)members[memberNum].loanAccount + "원");
		System.out.print("달러: " + (int)members[memberNum].usd + "달러");
		System.out.print("\t유로: " + (int)members[memberNum].eur + "유로");
		System.out.println("\t엔화: " + (int)members[memberNum].jpy + "엔");
		System.out.print("위안: " + (int)members[memberNum].cny + "위안");
		System.out.print("\t파운드 :" + (int)members[memberNum].gbp + "파운드");
		System.out.println("\t프랑: " + (int)members[memberNum].chf + "프랑");
	}
	void transfer(int memberNum){//이체
		input= goBack();
		switch (input) {
		case 1:
			System.out.println("보내실 분의 계좌번호를 입력해주세요>");
			transferAccount = ScanUtil.nextInt();
			System.out.println("얼마를 이체하시겠습니까?");
			money = ScanUtil.nextInt();
			if(0 < members[memberNum].accountMoney && money <= members[memberNum].accountMoney){
				for(int i = 0; i < members.length; i++){
					if(members[i]!=null){
						if(members[i].accountNumber==transferAccount){
							members[memberNum].accountMoney -= money;
							members[i].accountMoney += money;
							check =0;
							break;
						}else if(members[i].accountNumber != transferAccount){
							check =1;
						}
					}
				}
			}else if(money > members[memberNum].accountMoney){
				System.out.println("잔액이 부족합니다.");
			}
			if(check==1){
				System.out.println("계좌번호 입력이 잘못되었습니다.");
				check=0;
			}
			break;
		case 0:
			break;
		}
	}

	void deposit(int memberNum){//입금
		input= goBack();
		switch (input) {
		case 1:
			System.out.print("입금할 금액을 입력해주세요>");
			money = ScanUtil.nextInt();
			members[memberNum].accountMoney += money;
			break;
		case 0:
			break;
		}
		account(memberNum);
	}
	void withdraw(int memberNum){//출금
		input=goBack();
		switch (input) {
		case 1:
			System.out.print("출금할 금액을 입력해주세요>");
			money = ScanUtil.nextInt();
			if(0 < members[memberNum].accountMoney && money <= members[memberNum].accountMoney){
				members[memberNum].accountMoney -= money;
			}else if(money > members[memberNum].accountMoney){
				System.out.println("잔액이 부족합니다.");
			}
			break;
		case 0:
			break;
		}
		account(memberNum);
	}

	void loan(int memberNum){//대출
		input= goBack();
		switch (input) {
		case 1:
			System.out.print("얼마를 대출 받으시겠습니까?");
			money = ScanUtil.nextInt();
			members[memberNum].loanAccount += Math.round(money+(money*loanInterest));
			break;
		case 0:
			break;
		}
		account(memberNum);
	}

	void loanRepay(int memberNum){//대출금 상환

		System.out.println("대출금을 상환하시겠습니까?");
		System.out.println("1.계좌이용 2.입금 0.종료");
		System.out.print("실행하실 번호를 입력해주세요>");
		input= ScanUtil.nextInt();
		switch (input) {
		case 1:
			System.out.println("계좌금액: "+members[memberNum].accountMoney);
			System.out.println("대출금액: "+members[memberNum].loanAccount);
			System.out.print("계좌금액에서 상환하실 금액을 적어주세요>");
			money = ScanUtil.nextInt();
			if(0 < members[memberNum].loanAccount && money <= members[memberNum].loanAccount){
				members[memberNum].loanAccount -= money;
				members[memberNum].accountMoney -= money;
				System.out.println(money+"의 금액을 상환하여 " + members[memberNum].loanAccount + "원이 남았습니다.");
			}else if(money > members[memberNum].loanAccount){
				System.out.println("대출금보다 많이 입력하셨습니다.");
			}
			break;
		case 2:
			System.out.print("입금하여 상환하실 금액을 적어주세요>");
			money = ScanUtil.nextInt();
			if(0 < members[memberNum].loanAccount && money <= members[memberNum].loanAccount){
				members[memberNum].loanAccount -= money;
				System.out.println(money+"의 금액을 상환하여 " + members[memberNum].loanAccount + "원이 남았습니다.");
			}else if(money > members[memberNum].loanAccount){
				System.out.println("대출금보다 많이 입력하셨습니다.");
			}
			break;
		case 0:
			break;
		}
		account(memberNum);
	}

	void forex(int memberNum){
		System.out.println("------------------------------------");
		System.out.println("1.달러(미국)\t2.유로(유럽)\t3.엔(일본)");
		System.out.println("4.위안(중국)\t5.파운드(영국)\t6.프랑(스위스)");
		System.out.println("0.종료");
		System.out.println("------------------------------------");
		System.out.print("실행할 번호 입력>");
		input = ScanUtil.nextInt();
		switch (input) {
		case 1://달러
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.usdBuy();
				members[memberNum].usd+=forex.forexBuy(forexMoney, "달러", memberNum);
				account(memberNum);
				break;
			case 2:
				forexMoney=forex.usdSell();
				members[memberNum].usd-=forex.forexSell(forexMoney, "달러", memberNum, members[memberNum].usd);
				account(memberNum);
				break;
			}
			break;
		case 2://유로
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.eurBuy();
				members[memberNum].eur+=forex.forexBuy(forexMoney, "유로", memberNum);
				account(memberNum);
				break;
			case 2:
				break;
			}
			break;
		case 3://엔화
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.jpyBuy();
				members[memberNum].jpy+=forex.forexBuy(forexMoney, "엔", memberNum);
				account(memberNum);
				break;
			case 2:
				forexMoney=forex.jpySell();
				members[memberNum].jpy-=forex.forexSell(forexMoney, "엔", memberNum, members[memberNum].jpy);
				account(memberNum);
				break;
			}
			break;
		case 4://위안
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.cnyBuy();
				members[memberNum].cny+=forex.forexBuy(forexMoney, "위안", memberNum);
				account(memberNum);
				break;
			case 2:
				break;
			}
			break;
		case 5://파운드
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.gbpBuy();
				members[memberNum].gbp+=forex.forexBuy(forexMoney, "파운드", memberNum);
				account(memberNum);
				break;
			case 2:
				break;
			}
			break;
		case 6://프랑
			System.out.println("1.구매\t2.판매");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				forexMoney=forex.chfBuy();
				members[memberNum].chf+=forex.forexBuy(forexMoney, "프랑", memberNum);
				account(memberNum);
				break;
			case 2:
				break;
			}
			break;
		case 0:
			break;
		}
	}
}
