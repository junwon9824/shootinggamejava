package com.won;

class Battle {
	User user;

	public Battle(User user) {
		this.user = user;
	}

	public void printStageClear() {

		System.out.println("   _____ _______       _____ ______    _____ _      ______          _____  ");
		System.out.println("  / ____|__   __|/\\   / ____|  ____|  / ____| |    |  ____|   /\\   |  __ \\ ");
		System.out.println(" | (___    | |  /  \\ | |  __| |__    | |    | |    | |__     /  \\  | |__) |");
		System.out.println("  \\___ \\   | | / /\\ \\| | |_ |  __|   | |    | |    |  __|   / /\\ \\ |  _  / ");
		System.out.println("  ____) |  | |/ ____ \\ |__| | |____  | |____| |____| |____ / ____ \\| | \\ \\ ");
		System.out.println(" |_____/   |_/_/    \\_\\_____|______|  \\_____|______|______/_/    \\_\\_|  \\_\\");

	}

	public void printStageFailed() {

	}

	public void show() {

		for (int k = 0; k < 60; k++)
			System.out.println();
		System.out.print("┌");

		for (int i = 0; i < 40; i++)
			System.out.print("─");

		System.out.println("┐");

		System.out.println("  ----------------- stages ----------------  \n");

		System.out.print("  ◆ STAGE 1  -  ");
		if (this.user.stage1 == false)
			System.out.print("◯");

		else if (this.user.stage1 == true)
			System.out.print("●");

		System.out.print("\n\n  ◆ STAGE 2  -  ");
		if (this.user.stage2 == false)
			System.out.print("◯");
		else if (this.user.stage2 == true)
			System.out.print("●");

		System.out.print("\n\n  ◆ STAGE 3  -  ");
		if (this.user.stage3 == false)
			System.out.print("◯");

		else if (this.user.stage3 == true)
			System.out.print("●");

		System.out.println();
		System.out.println();
		System.out.print("  ◯ : not cleared yet /  ● : cleared");

		System.out.println();
		System.out.println();

		// 하단 부분.
		System.out.print("└");
		for (int i = 0; i < 40; i++)
			System.out.print("─");
		System.out.println("┘");

		while (true) {
			int choice = ETC.input("select stage.", "STAGE 1", "STAGE 2", "STAGE 3", "back");

			if (choice == 1 || choice == 2 || choice == 3) {

				if (this.user.stage1 == false && choice == 2) {
					System.out.println("[ clear stage 1 first]");
					continue;
				}

				if ((this.user.stage2 == false || this.user.stage1 == false) && choice == 3) {
					System.out.println("[ clear stage 2 first. ]");
					continue;
				}

				ETC.printLoading();

				Player player = new Player(this.user);
				GameObject th = new GameObject(player, choice, this.user);

				Thread gameth = new Thread(th);
				gameth.start();

				for (int k = 0; k < 10; k++)
					System.out.println();

				if (choice == 1) {
					System.out.println(" ------------------------------------------------------- ");
					System.out.println("   _____   _______               _____   ______    __");
					System.out.println("  / ____| |__   __|     /\\      / ____| |  ____|  /_ |");
					System.out.println(" | (___      | |       /  \\    | |  __  | |__      | |");
					System.out.println("  \\___ \\     | |      / /\\ \\   | | |_ | |  __|     | |");
					System.out.println("  ____) |    | |     / ____ \\  | |__| | | |____    | |");
					System.out.println(" |_____/     |_|    /_/    \\_\\  \\_____| |______|   |_|\n");
					System.out.println(" ------------------------------------------------------- ");
				} else if (choice == 2) {
					System.out.println(" ------------------------------------------------------- ");
					System.out.println("   _____   _______               _____   ______    ___");
					System.out.println("  / ____| |__   __|     /\\      / ____| |  ____|  |__ \\");
					System.out.println(" | (___      | |       /  \\    | |  __  | |__        ) |");
					System.out.println("  \\___ \\     | |      / /\\ \\   | | |_ | |  __|      / /");
					System.out.println("  ____) |    | |     / ____ \\  | |__| | | |____    / /_");
					System.out.println(" |_____/     |_|    /_/    \\_\\  \\_____| |______|  |____|\n");
					System.out.println(" ------------------------------------------------------- ");
				}

				else if (choice == 3) {
					System.out.println(" ------------------------------------------------------- ");
					System.out.println("   _____   _______               _____   ______   ____");
					System.out.println("  / ____| |__   __|     /\\      / ____| |  ____| |___ \\");
					System.out.println(" | (___      | |       /  \\    | |  __  | |__      __) |");
					System.out.println("  \\___ \\     | |      / /\\ \\   | | |_ | |  __|    |__ <");
					System.out.println("  ____) |    | |     / ____ \\  | |__| | | |____   ___) |");
					System.out.println(" |_____/     |_|    /_/    \\_\\  \\_____| |______| |____/");
					System.out.println(" ------------------------------------------------------- ");
				}

				// 게임 진행시 메인스레드 일시정지.
				try {
					gameth.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				ETC.printLoading();
				return;

			}

			else if (choice == 4) {
				return;
			}
		}

	}

}
