package JinSoo;

public class StockList {

	String name;//삼성주식 갯수
	int price;//삼성주식 1주당 가격
	double percent;
	StockList(String name, int price) {
		this.name=name;
		this.price=price;
		this.percent=0.0;
	}
}
