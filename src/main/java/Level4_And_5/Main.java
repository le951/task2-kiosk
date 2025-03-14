package Level4_And_5;


import Level4_And_5.Menu.Menu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage.init();
        Menu.init();

        Scanner sc = new Scanner(System.in);

        String in;
        while(true) {
            System.out.println("commands : exit / kiosk / menu");
            System.out.print("type command : ");
            in = sc.nextLine();

            if(in.equals("exit")) break;

            switch (in){
                case "kiosk":
                    Kiosk kiosk = new Kiosk();
                    kiosk.start();

                    break;
                case "menu":
                    Menu.cmd();
                    break;
                default:
                    System.out.println(in + " is unknown command.");
            }
            // kiosk는 여럿 실행될 수도 있다.
        }

        // 그냥 순차 실행 되나. 스레드 따로 나눠주는게 아니면?
        Storage.close();
    }
}
