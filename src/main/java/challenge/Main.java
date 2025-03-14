package challenge;


import challenge.Menu.Menu;
import challenge.UI.Kiosk;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage.init();
        Menu.init();

        Scanner sc = new Scanner(System.in);

        Kiosk kiosk = new Kiosk();
        kiosk.start();

//        String in;
//        while(true) {
//            System.out.println("commands : exit / kiosk / menu");
//            System.out.print("type command : ");
//            in = sc.nextLine();
//
//
//
//            if(in.equals("exit")) break;
//
//            switch (in){
//                case "kiosk":
//                    kiosk.start();
//                    break;
//                case "menu":
//                    Menu.cmd();
//                    kiosk = new kiosk();
//                    break;
//                default:
//                    System.out.println(in + " is unknown command.");
//            }
//            // kiosk는 여럿 실행될 수도 있다.
//        }

        // 그냥 순차 실행 되나. 스레드 따로 나눠주는게 아니면?
        Storage.close();
    }
}
