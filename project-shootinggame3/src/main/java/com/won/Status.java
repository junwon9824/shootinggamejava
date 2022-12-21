package com.won;

// 상태창.
class Status {
	User user;
	public Status(User user) {
		this.user = user;
		
	}
	
	// 상태창에 대한 정보를 보여주는 메소드. ( UI )
	public void show() {
		for (int k = 0; k < 10; k++) System.out.println();
		// 상단 부분.
		System.out.print("┌");
		for(int i = 0; i < 40; i++)System.out.print("─");
		System.out.println("┐");
		System.out.printf("  money : %d원.\n",this.user.userMoney);
		
		System.out.println("  ------------- "+this.user.name+"'s current plane ------------  \n");
		if(user.currentplane == null) {
			System.out.print("  current plane이 없습니다.\n");
		}
		else {
			System.out.printf("  plane name : %s\n",user.currentplane.name);
			System.out.printf("  HP : %d\n",user.currentplane.HP);
			System.out.printf("  bullet power : %d\n",user.currentplane.bulletPower);
			System.out.printf("  skill : %s\n",user.currentplane.description);
			System.out.println("  ------------- item in my pocket------------  ");
			System.out.print("  장착 item : ");user.showUsedItem();
		}
		
		
		System.out.println("  --------------------------------------  ");
		// 하단 부분.
		System.out.print("└");
		for(int i = 0; i < 40; i++)System.out.print("─");
		System.out.println("┘");
		int choice = ETC.exit();
		if(choice == 0) {return;}
		
	}
	
	
}
