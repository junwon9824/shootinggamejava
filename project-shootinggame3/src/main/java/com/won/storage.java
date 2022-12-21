package com.won;

// storage.
class storage {
	User user;

	public storage(User user) {
		this.user = user;
	}

	// storage에 대한 정보를 보여주는 메소드 ( UI )
	public void show() {
		storage: while (true) {
			for (int k = 0; k < 10; k++)
				System.out.println();
			// 상단 부분.
			System.out.print("┌");
			for (int i = 0; i < 40; i++)
				System.out.print("─");
			System.out.println("┐");

			System.out.printf("  money : %d원.\n", this.user.userMoney);

			System.out.printf("  ---------------- storage ----------------  \n", this.user.name);
			// my item 표시.
			System.out.print(" my item : ");
			user.showItem();
			System.out.print("  my planes : ");
			user.showFlight();

			System.out.println("  --------------- plane stauts -------------  ");
			System.out.printf("  current plane : ");
			user.showUsedFlight();
			System.out.printf("  장착한 item : ");
			user.showUsedItem();

			System.out.println("  -----------------------------------  ");

			int choice = ETC.input("what would you do?", "plane replace", "take item", "back");
			switch (choice) {
			case 1: // plane replace.
				for (int k = 0; k < 10; k++)
					System.out.println();
				// 보유중인 plane name 불러오기.
				System.out.print("보유하신 기종 : ");
				user.showFlight();

				// 선택지 만들기위한 배열.
				String[] flightsName = new String[user.myplane.size()];
				for (int i = 0; i < user.myplane.size(); i++) {
					flightsName[i] = user.myplane.get(i).name;
				}

				// 보유중인 plane이 없을때 다시 storage로 back.
				if (user.myplane.isEmpty()) {
					System.out.println("replace할 plane이 없습니다.");
					continue storage;
				}

				// 바꿀 plane name 선택.
				choice = ETC.input("어떤 기종으로 바꾸시겠습니까?", flightsName);
				// 처음 plane를 사용할 때의 if.
				if (user.currentplane == null) {
					user.currentplane = user.myplane.get(choice - 1);
					user.myplane.remove(choice - 1);
					System.out.printf("%s 전투기를 발진합니다.\n", user.currentplane.name);
				}
				
				// 장착중인 plane이 있고, 보유중인 plane에서 replace를 할 때의 if.
				else {
					Jet flightTemp;
					flightTemp = user.currentplane;
					user.currentplane = user.myplane.get(choice - 1);
					user.myplane.remove(choice - 1);
					user.myplane.add(flightTemp);
				}
				break;

				
			case 2: // take item.
				for (int k = 0; k < 10; k++)
					System.out.println();
				// 보유중인 item 불러오기.
				System.out.print("\n보유 item : ");
				user.showItem();

				// 선택지를 만들기위한 배열.
				String[] itemsName = new String[user.myitem.size()];
				for (int i = 0; i < user.myitem.size(); i++) {
					itemsName[i] = user.myitem.get(i).name;
				}

				// 보유중인 item이 없을때 다시 storage로 back.
				if (user.myitem.isEmpty()) {
					System.out.println("장착할 item이 없습니다.");
					continue storage;
				}

				// 장착할 item 선택.
				choice = ETC.input("어떤 item을 장착하시겠습니까?", itemsName);
				// 처음 item을 장착할 때의 if.
				if (user.currentitem == null) {
					user.currentitem = user.myitem.get(choice - 1);
					user.myitem.remove(choice - 1);
					System.out.printf("%s item을 장착했습니다.\n", user.currentitem.name);
				}
				// 장착한 item이 있고, 보유중인 item도 있을 때 replace를 하는 if.
				else {
					Item itemTemp;
					itemTemp = user.currentitem;
					user.currentitem = user.myitem.get(choice - 1);
					user.myitem.remove(choice - 1);
					user.myitem.add(itemTemp);
				}

				break;

			case 3: // back.
				return;
			}
		}

	}// show 메소드 끝.
}
