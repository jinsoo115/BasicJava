package f_game;

import e_oop.ScanUtil;

public class MyGame {

	Character c;
	Item[] items;
	MyGame() {
		
		c = new Character("가렌", 100, 50, 20, 10);

		items = new Item[10];
		items[0] = new Item("무한의대검", 0, 0, 10, 0);
		items[1] = new Item("가시갑옷", 0, 0, 0, 10);

	}

	public static void main(String[] args) {
		new MyGame().start();
	}

	void start(){
		int input = 0;
		while(true){
			System.out.println("1.내정보\t2.사냥\t3.종료");
			input = ScanUtil.nextInt();
			
			switch (input) {
			case 1:
				c.showInfo();
				break;
			case 2:
				hunt();
				break;
			case 3:
				System.out.println("종료되었습니다.");
				System.exit(0);
				break;
			}
		}
	}
	
	void hunt(){
		Monster m = new Monster("고블린", 20, 10, 15, 10, new Item[]{items[0], items[1]});
		System.out.println(m.name + "를 만났습니다. 전투를 시작합니다.");
		
		int input = 0;
		battle : while(true){
			System.out.println("1.공격\t2.도망");
			input = ScanUtil.nextInt();
			switch (input) {
			case 1:
				c.attcak(m);
				if(m.hp <= 0){
					System.out.println(m.name + "을 처치하였습니다.");
					c.getExp(150);
					c.getItem(m.itemDrop());
					break battle;
				}
				m.attcak(c);
				break;
				
			case 2:
				break battle;
			}
		}
	}
}