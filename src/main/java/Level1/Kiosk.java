package Level1;

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
        int in = sc.nextInt();

        while(in!=0){
            switch (in){
                case 0:
                    System.out.println("메뉴판을 종료합니다.");
                    return;
                case 1:
                    System.out.println("1. ShackBurger / W 6.9");
                    System.out.println("당 점이 추구하는 맛의 균형.");
                    System.out.println("영양 정보 " +
                            "\n: 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                            "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                            "\n 552kcal");
                    break;
                case 2:
                    System.out.println("2. SmokeShack / W 8.9");
                    System.out.println("바삭한 베이컨과 맵지 않은 체리페퍼.");
                    System.out.println("영양 정보 " +
                            "\n: 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                            "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                            "\n 573kcal");
                    break;
                case 3:
                    System.out.println("3. CheeseBurger / W 6.9");
                    System.out.println("묵직한 맛.");
                    System.out.println("영양 정보 " +
                            "\n: 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                            "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                            "\n 637kcal");
                    break;
                case 4:
                    System.out.println("4. Hamburger / W 5.4");
                    System.out.println("패티의 맛만 한껏 느껴보고 싶다면.");
                    System.out.println("영양 정보 " +
                            "\n: 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                            "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                            "\n 452kcal");
                    break;
                default:
                    System.out.println("입력된 메뉴 " + in + " 는 없는 메뉴입니다.");
            }
            in = sc.nextInt();
        }

    }

    public void page_main(){
        System.out.println("[ SHAKESHACK MENU ]");
        System.out.println("1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        System.out.println("2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        System.out.println("3. CheeseBurger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        System.out.println("4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거");
        System.out.println("0. 종료");
    }

//    public void page_

}
