package JinSoo;

import e_oop.ScanUtil;

public class Stock {
	Member[] members;
	int input;
	int input2;
	int count;
	int stockAccount;//주식계좌
	double percent;
	int random;//플러스 마이너스 랜덤 1=플러스 2는 마이너스
	StockList[] stockList;
	Stock(Sign sign){
		this.members = sign.members;
		this.input = 0;
		this.input2 =0;
		this.count = 0; 
		this.percent=0.0;
		this.stockList = new StockList[10];
		stockList[0]=new StockList("samsung",10000);
		stockList[1]=new StockList("kakao", 5000);
	}

	void stockList(int memberNum){

		a : while(true){
			System.out.println("------------------------------------");
			System.out.println("1.samsung\t2.kakao");
			System.out.println("11.전체주식보기\t12.주식변동\t13.보유주식보기\t0.종료");
			System.out.println("------------------------------------");
			System.out.print("실행할 번호 입력>");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				buySell(memberNum);
				break;
			case 2:
				buySell(memberNum);
				break;
			case 11:
				for(int i = 0; i < stockList.length; i++){
					if(stockList[i] != null){
						System.out.println(stockList[i].name+"의 주가는"+stockList[i].price+"원 입니다.");
					}
				}
				break;
			case 12:
				stockChange();
				break;
			case 13:
				myStock(memberNum);
				break;
			case 0:
				break a;
			}
		}
	}
	void buySell(int memberNum){
		System.out.println("1.구매\t2.판매");
		input2 = ScanUtil.nextInt();
		switch (input2) {
		case 1:
			stockBuy(input,memberNum);
			break;
		case 2:
			stockSell(input, memberNum);
			break;
		}
	}
	void myStock(int memberNum){//내주식 확인
		for(int i = 0; i < stockList.length; i++){
			if(stockList[i]!=null){
				System.out.println(stockList[i].name+"의 주식 "+members[memberNum].stockAccount[i] + "현재 주식 가치는 " + members[memberNum].stockAccount[i] * stockList[i].price );
			}
		}
	}
	void stockBuy(int input, int memberNum){//주식 구매
		System.out.println(stockList[input-1].name+"의 1주당 가격은 "+ stockList[input-1].price+ "원입니다.");
		System.out.print("구매하실 주식의 갯수를 적어주세요>");
		count=ScanUtil.nextInt();
		if(members[memberNum].accountMoney>=count * stockList[input-1].price){
			members[memberNum].stockAccount[input-1] += count;
			System.out.println(stockList[input-1].name+"의 주식  "+members[memberNum].stockAccount[input-1]+"주");
			members[memberNum].accountMoney -= count * stockList[input-1].price;
		}else if(members[memberNum].accountMoney<count * stockList[input-1].price){
			System.out.println("보유하신 금액보다 많은 주식을 입력하셨습니다");
		}
		
	}
	void stockSell(int input, int memberNum){//주식 판매
		System.out.println(stockList[input-1].name+"의 1주당 가격은 "+ stockList[input-1].price+ "원입니다.");
		System.out.print("판매하실 주식의 갯수를 적어주세요>");
		count=ScanUtil.nextInt();
		if(count<=members[memberNum].stockAccount[input-1]){
			members[memberNum].stockAccount[input-1] -= count;
			System.out.println(stockList[input-1].name+"의 주식  "+members[memberNum].stockAccount[input-1]+"주");
			members[memberNum].accountMoney += count * stockList[input-1].price;
		}else if(count>members[memberNum].stockAccount[input-1]){
			System.out.println("보유하신 주보다 많이 입력하셨습니다.");
		}
	}

	void stockChange(){//주가 변동 일으키기
		for(int i = 0; i < stockList.length; i++){
			if(stockList[i]!=null){
				random = (int)(Math.random()*2)+1;
				percent=((double)(Math.random()*11)/100);
				if(random==1){
					stockList[i].price = (int)(stockList[i].price + (stockList[i].price*percent));
				}else{
					stockList[i].price = (int)(stockList[i].price - (stockList[i].price*percent));
				}
			}
		}
	}
}
