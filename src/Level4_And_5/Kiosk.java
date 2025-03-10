package Level4_And_5;

import java.util.Scanner;

public class Kiosk {


    // 일단 Terminal 출력. 나중에는 UI 별개. 클라이언트에서 직접 접근하는 것은 딱 이 클래스로만?
    // 요청: 메뉴 목록 -> Menu.getList()
    // 메뉴에 조건, 정렬 구현
    // 근데 이렇게 하면 다 서버 처리가 되어버리지 않나? 클라이언트에서 처리하는 것도 분리해야겠는데. 단순 정렬.

    // 주문 입력 -> Cart
    // 주문 초기화 -> Cart.clear

    // 여기선 Storage Class 접근을 지양한다.

    // 하나의 Kiosk 객체는 한 명의 클라이언트에 대해서 대응함.

    Cart cart;
    Scanner sc;

    Kiosk(){
        // 초기화
        cart = new Cart();
        sc = new Scanner(System.in);
    }

    public void start(){

        page_main();


    }

    public void page_main(){

        var list = Menu.getList();


        String in;

        while(true){

            System.out.println("[ SHAKESHACK MENU ]");

            for(var m : list.values()){
                System.out.println(m.getName() + " | " + m.getPrice() + " | " + m.getSummary());
            }
            System.out.print("\n Type a name for more information : ");

            in = sc.nextLine();

            try {
                System.out.println("\n"+list.get(in).getDetail());
            } catch (NullPointerException e) {
                System.out.println("Unknown name");
            }

            System.out.println("\nplease enter any key");
            // 입력 대기
            sc.nextLine();
        }

//        System.out.println("1. ShackBurger   | W 6.9 | ");
//        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
//        System.out.println("3. CheeseBurger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
//        System.out.println("4. Hamburger     | W 5.4 | ");
//        System.out.println("0. 종료");
    }

//    public void page_

}
