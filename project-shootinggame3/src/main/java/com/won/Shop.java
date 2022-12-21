package com.won;

// store.
class Shop {
	User user;
	Item item;
	Jet jet;
	
	public Shop(User user, Item item, Jet jet) {
		this.user = user;
		this.item = item;
		this.jet = jet;
	}
	
	void buyFlight(Jet flight, User user) {
		while(true) {
			for (int k = 0; k < 10; k++) System.out.println();
			System.out.printf("plane name : %s\n",flight.name);
			System.out.printf("plane price : %d\n",flight.price);
			System.out.printf("description : %s\n",flight.description);
			int choice = ETC.input("would you buy this??", "yes","no");
			
			if(choice == 1) {
				if(flight.price > user.userMoney) {
					System.out.println("[ 잔액이 부족합니다. ]");
					break;
				}
				/*
				 * 동일 기종이 있을시 구매를 막는 메소드.. 마지막에 추가하자.
				 */
//				else if(user.myplane.contains(flight)) {
//					System.out.println("동일 기종을 이미 가지고있습니다.");
//					break;
//				}
				else {
					System.out.printf("%s를 구매하셨습니다.\n",flight.name);
					user.userMoney -= flight.price;
					user.myplane.add(flight);
					break;
				}
			}
			else if(choice == 2) 
				return;
		}
	}
	
	void buyItem(Item item, User user) {
		while(true) {
			for (int k = 0; k < 10; k++) System.out.println();
			System.out.printf("item name : %s\n",item.name);
			System.out.printf("item price : %d\n",item.price);
			System.out.printf("item description : %s\n",item.description);
			int choice = ETC.input("would you buy this??", "yes","no");
			if(choice == 1) {
				if(item.price > user.userMoney) {
					System.out.println("[ 잔액이 부족합니다. ]");
					break;
				}
				else {
					System.out.printf("%s를 구매하셨습니다.\n",item.name);
					user.myitem.add(item);
					user.userMoney -= item.price;
					break;
				}
				
			}
			
			else if(choice == 2)
				return;
		}
	}
	
	// 보여주는 메소드.
	public void show() {
		while(true) {
			for (int k = 0; k < 10; k++) System.out.println();
			System.out.println("[ ---------store--------- ]");
			int choice = ETC.input("choose store?", "item store","plane store","go back");
			switch(choice) {
			case 1: // item.
				item:
				while(true) {
					for (int k = 0; k < 10; k++) System.out.println();
					choice = ETC.input("무엇을 would you buy this??", "HP플러스+10 - 300원","HP플러스+30 - 700원", "store으로 돌아간다.");
					if(choice == 1) {
						Item HP10 = new HPplus10();
						buyItem(HP10, this.user);
					}
					else if(choice == 2) {
						Item HP30 = new HPplus30();
						buyItem(HP30, this.user);
					}
					else if(choice == 3) 
						break;
				} // item 반복문의 끝.
				break; // case1의 끝.

			case 2: // plane.
				while(true) {
					for (int k = 0; k < 10; k++) System.out.println();
					choice = ETC.input("무엇을 would you buy this??", "F4K - 500원","F15K - 1000원","F35K - 2000원","store으로 돌아간다.");
					// 
					if(choice == 1) {
						Jet F4K = new F4K();
						buyFlight(F4K, this.user);
					}
					else if(choice == 2) {
						Jet F15K = new F15K();
						buyFlight(F15K, this.user);
					}
					else if(choice == 3) {
						Jet F35K = new F35K();
						buyFlight(F35K, this.user);
					}
					else if(choice == 4) // plane store을 go back.
						break;
				} // flight 반복문의 끝.
				break; // case 2의 끝.
				
			case 3: // go back.
				return;
			}
		}
	}// show함수 끝.
	
	
}// 클래스 끝.
