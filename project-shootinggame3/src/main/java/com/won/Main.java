package com.won;

public class Main {
    public static void main(String[] args) {

        // 도입부 ( 새 게임 or 불러오기 ) 그리고 계정 객체화.
        User user1;
        user1 = ETC.Login();

        // 클래스 인스턴스화.
        storage storage = new storage(user1);
        Jet Jet = new Jet();
        Item Item = new Item();
        Shop Shop = new Shop(user1,Item,Jet);
        Status Status = new Status(user1);
        Battle Battle = new Battle(user1);
//		Music 배경음악 = new Music("SOURCE/music.wav");
//		Thread 배경음악th = new Thread(배경음악);
//		배경음악th.start();

        // 메뉴
        while(true) {
            for (int k = 0; k < 10; k++) System.out.println();
            int choice = ETC.input("M  E  N  U", "game information","status","storage","market","play","quit","cheat code");
            switch(choice) {
                case 1: // 게임 description.
                    ETC.gameDescription();
                    break;
                case 2: // 상태창.
                    Status.show();
                    break;
                case 3: // storage ( storage )
                    storage.show();
                    break;
                case 4: // store.
                    Shop.show();
                    break;
                case 5: // 전투.
//				배경음악.pause();
                    Battle.show();
                    break;
//                    
//                case 6: // 게임저장.
//                    ETC.save(user1);
//                    break;
//             
                case 6: // 게임 종료.
//				배경음악.stop();
                    System.out.println(" [ 게임을 종료합니다. ]");
                    System.exit(0);
                    
                case 7: // 치트키.
                    System.out.println("[ cheat code activated. ]");
                    user1.currentplane.HP+=10000;
                    user1.userMoney += 10000;
                    break;
            }
        }

    } // main 함수 끝.
}
