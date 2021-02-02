package JinSoo;

import e_oop.ScanUtil;

public class Forex {	
	Member[] members;
	String yOrn;
	int money;
	int usd,MAX_USD,MIN_USD;//달러
	int eur,MAX_EUR,MIN_EUR;//유로
	int jpy,MAX_JPY,MIN_JPY;//엔화
	int cny,MAX_CNY,MIN_CNY;//위안
	int gbp,MAX_GBP,MIN_GBP;//파운드
	int chf,MAX_CHF,MIN_CHF;//프랑
	int sell;

	Forex(Sign sign) {
		this.members = sign.members;
		this.yOrn="";
		this.money=0;
		this.usd=0;//달러
		this.eur=0;//유로
		this.jpy=0;//엔화
		this.cny=0;//위안
		this.gbp=0;//파운드
		this.chf=0;//프랑
		this.MAX_USD=1189;//달러
		this.MIN_USD=1086;
		this.MAX_EUR=1409;//유로
		this.MIN_EUR=1310;
		this.MAX_JPY=1120;//엔화
		this.MIN_JPY=1046;
		this.MAX_CNY=175;//위안
		this.MIN_CNY=166;
		this.MAX_GBP=1580;//파운드
		this.MIN_GBP=1460;
		this.MAX_CHF=1306;//프랑
		this.MIN_CHF=1212;
		this.sell = 50;

	}
	int usdBuy(){
		usd=(int)(Math.random()*(MAX_USD-MIN_USD+1))+MIN_USD;
		System.out.println("현재 1달러에 "+ usd);
		return usd;
	}
	int usdSell(){
		usd=(int)(Math.random()*(MAX_USD-MIN_USD+1))+MIN_USD;
		System.out.println("현재 1달러에 "+ (usd-sell));
		return usd-100;
	}
	int eurBuy(){
		eur=(int)(Math.random()*(MAX_EUR-MIN_EUR+1))+MIN_EUR;
		System.out.println("현재 1유로에 "+ eur);
		return eur;
	}
	int eurSell(){
		eur=(int)(Math.random()*(MAX_EUR-MIN_EUR+1))+MIN_EUR;
		System.out.println("현재 1달러에 "+ (eur-sell));
		return eur-100;
	}
	int jpyBuy(){
		jpy=(int)(Math.random()*(MAX_JPY-MIN_JPY+1))+MIN_JPY;
		System.out.println("현재 100엔에 "+jpy);
		return jpy;
	}
	int jpySell(){
		jpy=(int)(Math.random()*(MAX_JPY-MIN_JPY+1))+MIN_JPY;
		System.out.println("현재 100엔에 "+(jpy-sell));
		return jpy-100;
	}
	int cnyBuy(){
		cny=(int)(Math.random()*(MAX_CNY-MIN_CNY+1))+MIN_CNY;
		System.out.println("현재 1위안에 "+cny);
		return cny;
	}
	int cnySell(){
		cny=(int)(Math.random()*(MAX_CNY-MIN_CNY+1))+MIN_CNY;
		System.out.println("현재 1위안에 "+(cny-sell));
		return cny-100;
	}
	int gbpBuy(){
		gbp=(int)(Math.random()*(MAX_GBP-MIN_GBP+1))+MIN_GBP;
		System.out.println("현재 1파운드에 "+gbp);
		return gbp;
	}
	int gbpSell(){
		gbp=(int)(Math.random()*(MAX_GBP-MIN_GBP+1))+MIN_GBP;
		System.out.println("현재 1파운드에 "+(gbp-sell));
		return gbp-100;
	}
	int chfBuy(){
		chf=(int)(Math.random()*(MAX_CHF-MIN_CHF+1))+MIN_CHF;
		System.out.println("현재 1프랑에 "+chf);
		return chf;
	}
	int chfSell(){
		chf=(int)(Math.random()*(MAX_CHF-MIN_CHF+1))+MIN_CHF;
		System.out.println("현재 1프랑에 "+(chf-sell));
		return chf-100;
	}

	int forexBuy(int forexMoney, String forexCountry, int memberNum){//외환 구매
		do{
			System.out.print("구매하시겠습니까?(y||n)");
			yOrn = ScanUtil.nextLine();
			if(yOrn.equals("Y")||yOrn.equals("y")){
				System.out.println("몇"+forexCountry+"를 구매하시겠습니까?(계좌금액에서 차감됩니다.)");
				money=ScanUtil.nextInt();
				if(forexCountry.equals("엔")){//엔화구매
					System.out.print(money+forexCountry+"를 구매하시려면"+((money/100)*forexMoney)+"의 금액이 필요합니다.");
					money /=100;
					System.out.print("진행하시겠습니까?(y||n)");
					yOrn = ScanUtil.nextLine();
					if(yOrn.equals("Y")||yOrn.equals("y")){
						if(0 < members[memberNum].accountMoney && money*forexMoney <= members[memberNum].accountMoney ){
							members[memberNum].accountMoney -= money*forexMoney;
							System.out.println(money+forexCountry+"를 구입하셨습니다.");
							return money*100;
						}else if(money*forexMoney > members[memberNum].accountMoney){
							System.out.println("잔액이 부족합니다.");
							return 0;
						}
					}else{
						return 0;
					}
				}else{//나머지 구매
					System.out.print(money+forexCountry+"를 구매하시려면"+(money*forexMoney)+"의 금액이 필요합니다.");
					System.out.print("진행하시겠습니까?(y||n)");
					yOrn = ScanUtil.nextLine();
					if(yOrn.equals("Y")||yOrn.equals("y")){
						if(0 < members[memberNum].accountMoney && money*forexMoney <= members[memberNum].accountMoney ){
							members[memberNum].accountMoney -= money*forexMoney;
							System.out.println(money+forexCountry+"를 구입하셨습니다.");
							return money;
						}else if(money*forexMoney > members[memberNum].accountMoney){
							System.out.println("잔액이 부족합니다.");
							return 0;
						}
					}else{
						return 0;
					}
				}
			}else{
				return 0;
			}
		}while(!yOrn.equals("Y")||!yOrn.equals("y"));

		return 0;
	}
	
	int forexSell(int forexMoney, String forexCountry, int memberNum, int fm){//외환판매
		do{
			System.out.print("판매하시겠습니까?(y||n)");
			yOrn = ScanUtil.nextLine();
			if(yOrn.equals("Y")||yOrn.equals("y")){
				System.out.println("몇"+forexCountry+"를 판매하시겠습니까?(외환금액에서 차감됩니다.)");
				money=ScanUtil.nextInt();
				
				if(forexCountry.equals("엔")){//엔화 판매
					System.out.print(money+forexCountry+"를 판매하시면"+((money/100)*forexMoney)+"의 금액에 판매하실수 있습니다..");
					money /= 100;
					System.out.print("진행하시겠습니까?(y||n)");
					yOrn = ScanUtil.nextLine();
					if(yOrn.equals("Y")||yOrn.equals("y")){
						if(0 < fm && money <= fm){
							members[memberNum].accountMoney += money*forexMoney;
							System.out.println(money+forexCountry+"를 판매하셨습니다.");
							return money*100;
						}else if(fm <= 0 || fm < money){
							System.out.println("잔액이 부족합니다.");
							return 0;
						}
					}else{
						return 0;
					}
				}else{//나머지 판매
					System.out.print(money+forexCountry+"를 판매하시면"+(money*forexMoney)+"의 금액에 판매하실수 있습니다.");
					System.out.print("진행하시겠습니까?(y||n)");
					yOrn = ScanUtil.nextLine();
					if(yOrn.equals("Y")||yOrn.equals("y")){
						if(0 < fm && money <= fm){
							members[memberNum].accountMoney += money*forexMoney;
							System.out.println(money+forexCountry+"를 판매하셨습니다.");
							return money;
						}else if(fm <= 0 || fm < money){
							System.out.println("잔액이 부족합니다.");
							return 0;
						}
					}else{
						return 0;
					}
				}
			}else{
				return 0;
			}
		}while(!yOrn.equals("Y")||!yOrn.equals("y"));

		return 0;
	}
	
	

}
