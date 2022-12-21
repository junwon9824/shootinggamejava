package com.won;

import java.io.*;
import java.util.Scanner;

class ETC {

	static Scanner sc = new Scanner(System.in);

	// 여러가지 상황에서 유저의 선택을 받아야 할때 쓰는 질문메소드. ( 정enemy 변수 )
	static int input(String question, String... strings) {

		Music buttonsound = new Music("src/main/SOURCE/버튼음.wav"); // 효과음 설정.
		Scanner sc = new Scanner(System.in);

		
		try {
			System.out.println("[ " + question + " ]");
			for (int i = 0; i < strings.length; i++) {
				System.out.println((i + 1) + ". " + strings[i]);
			}

			int choice = sc.nextInt();
			buttonsound.playOnetime(1); // 버튼 누를때마다 효과음 실행.

			if (choice > 0 && choice <= strings.length)
				return choice;

			else {
				System.out.println("[error!] wrong input. try again.");
				return input(question, strings);
			}

		}

		catch (Exception e) {
			System.out.println("[error!] wrong input. try again.");
			return input(question, strings);
		}

	}

	// 한글자 한글자 출력하는 스레드 메소드.
	static void printOneByOne(String story, int speed) {
		for (int i = 0; i < story.length(); i++) {
			System.out.print(story.charAt(i));
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// 상태창에서 back 버튼을 만들기 위한 메소드.
	static int exit() {

		Scanner sc = new Scanner(System.in);

		try {
			System.out.println("  0. back");
			int choice = sc.nextInt();
			if (choice != 0) {
				System.out.println("[error!] wrong input. try again.");
				return exit();
			}
			else {
				return choice;
			}
		} catch (Exception e) {
			System.out.println("[error!] wrong input. try again.");
			return exit();
		}
	}
//
//	// 게임 저장 메소드.
//	static void save(User user) {
//		File file = new File("save.dat");
//
//		try {
//			FileOutputStream fout = new FileOutputStream(file);
//			ObjectOutputStream oout = new ObjectOutputStream(fout);
//			oout.writeObject(user);
//			System.out.println("저장되었습니다.");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	// 로딩화면 메소드.
	static void printLoading() {

		char[] box = new char[50];
		// char배열을 사용해서 로딩 박스 채우기.
		for (int i = 0; i < 50; i++) {
			box[i] = '□';
		}
		for (int i = 0; i < 5; i++) {

			for (int k = 0; k < 10; k++)
				System.out.println(); // 계속해서 엔터치기. ( 콘솔창 내용 지우기 역할 )

			// 상단 부분.
			System.out.print("┌");
			for (int q = 0; q < 60; q++)
				System.out.print("─");
			System.out.println("┐");

			System.out.println("\n                welcome to World War\n");
			System.out.print("       ");

			System.out.println(" --------------- Loading . . . . --------------- ");

			// 로딩 박스 출력.
			System.out.print("       ");
			for (int j = 0; j < 5; j++) {
				System.out.print(box[j]);
			}

			System.out.println();

			// 하단 부분.
			System.out.println();
			System.out.print("└");
			for (int w = 0; w < 10; w++)
				System.out.print("─");
			System.out.print("┘");

			box[i] = '■'; // 로딩박스 채우기.

			// 진짜 로딩되는 것처럼 보이기 위해 간격두기위한 sleep.
			try {
				Thread.sleep(50);
				System.out.println();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (int k = 0; k < 10; k++)
			System.out.println(); // 계속해서 엔터치기. ( 콘솔창 내용 지우기 역할 )

	}

	// 로그인창 메소드. ( 첫 화면 )
	static User Login() {
		
		Scanner sc = new Scanner(System.in);
		int choice = ETC.input(" World War", "new game");
		if (choice == 1) { // 새 게임.
			System.out.println("[ please write your name ]");
			System.out.print(" ◆ account : ");
			String userName = sc.next();
			User user1 = new User(userName);
			ETC.printLoading();
			story story = new story();
			return user1;

		}

//					else if (choice == 2) { // 불러오기.
//			User user1;
//			File file = new File("save.dat");
//			try {
//				FileInputStream fin = new FileInputStream(file);
//				ObjectInputStream oin = new ObjectInputStream(fin);
//				user1 = (User) oin.readObject();
//				ETC.printLoading();
//				return user1;
//			} catch (Exception e) {
//				System.out.println("저장된 계정이 없습니다.");
//				return Login();
//			}
//		} 
//		
////		
//		else if (choice == 2) { // 게임 종료.
//			System.exit(0);
//		}

		return null;
	}

	// 게임 description 메소드.
	static void gameDescription() {
		for (int k = 0; k < 60; k++)
			System.out.println();
		// 상단 부분.
		System.out.print("┌");
		for (int i = 0; i < 56; i++)
			System.out.print("─");
		System.out.println("┐");

//		// 내용 부분
//		System.out.println("\n -------------------------------------------------------- \n");
//		System.out.println("        _____   _______    ____    _____   __     __");
//		System.out.println("       / ____| |__   __|  / __ \\  |  __ \\  \\ \\   / /");
//		System.out.println("      | (___      | |    | |  | | | |__) |  \\ \\_/ /");
//		System.out.println("       \\___ \\     | |    | |  | | |  _  /    \\   /");
//		System.out.println("       ____) |    | |    | |__| | | | \\ \\     | |");
//		System.out.println("      |_____/     |_|     \\____/  |_|  \\_\\    |_|\n");
//		System.out.println("\n -------------------------------------------------------- \n");
//		System.out.println();

		System.out.println("\n one day the enemies appeared and we should fight against them!!! \n");

		
		System.out.println(" -------------------------------------------------------- \n");
		System.out.println("                 _  __  ______  __     __");
		System.out.println("                | |/ / |  ____| \\ \\   / /");
		System.out.println("                | ' /  | |__     \\ \\_/ / ");
		System.out.println("                |  <   |  __|     \\   /  ");
		System.out.println("                | . \\  | |____     | |   ");
		System.out.println("                |_|\\_\\ |______|    |_|   ");
		System.out.println("\n\n -------------------------------------------------------- \n");
		System.out.println("          ◆ move : left ← / right → / up ↑ / down ↓\n");
		System.out.println("          ◆ missile shoot : Space ( 스페이스 바 )\n");
		System.out.println("          ◆ use item : Ctrl ( 컨트롤 )\n");
		System.out.println("          ◆ skill : Z ( Z키 )\n");

		// 하단 부분.
		System.out.print("\n└");
		for (int i = 0; i < 56; i++)
			System.out.print("─");
		System.out.println("┘");

		// back 버튼.
		int choice = ETC.exit();
		if (choice == 0) {
			return;
		}
	}
} // ETC 클래스 끝.
