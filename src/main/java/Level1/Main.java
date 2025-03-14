package Level1;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Storage.init();

        // kiosk는 여럿 실행될 수도 있다.
        Kiosk kiosk = new Kiosk();
        kiosk.start();

        // 그냥 순차 실행 되나. 스레드 따로 나눠주는게 아니면?
        Storage.close();
    }
}
