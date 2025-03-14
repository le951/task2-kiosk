package challenge.UI;

import challenge.Menu.Menu;
import challenge.Menu.MenuItem;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;

public class Kiosk {

    // 요구사항
    // 주문 선택
    // 수량 변경
    // 가격 확인 (주문) / 초기화

    // 메뉴 목록 : Menu.getList() / Menu.getCategory()
    // JSON으로 시작할 때 받아서 변수에 저장
    // 화면에 구성하여 출력
    // Cart Class가 필요할까?
    // Kiosk에선 표시. 선택. 계산은 Cart 클래스에서


    // 주문 입력 -> Cart
    // 주문 초기화 -> Cart.clear

    // 하나의 Kiosk 객체는 한 명의 클라이언트에 대해서 대응함.

    ObjectMapper mapper = new ObjectMapper();

    static HashMap<String, Item> list = null;
    static HashMap<String, ArrayList<String>> category = null;

    private Cart cart;
    private Scanner sc = new Scanner(System.in);


    public Kiosk() {
        // 초기화
        cart = new Cart();

        update();
    }

    public void update() {

        // 발전시키면 메뉴 Hash값 같은걸 해놓고 서버와 대조해서 변화가 있는지 체크하려나.
        // 아니면 최종 업데이트 시간을 기록한다거나.
        // 같으면 cache된 값으로, 아니면 새로고침.
        // 일단 생략. Kiosk 실행 때만.

        try {
            list = mapper.readValue(Menu.getList(), new TypeReference<>() {
            });
            category = mapper.readValue(Menu.getCategory(), new TypeReference<>() {
            });

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public void start() {

        String in;

        while (true) {

            System.out.println("\n command: exit, all, category, cart");
            System.out.print("Type a command : ");

            in = sc.nextLine();


            switch (in) {
                case "exit":
//                    return;
                    cart.clear();
                    break;
                case "category":
                    page_category();
                    break;
                case "all":
                    page_all();
                    break;
                case "cart":
                    page_cart();
                default:
                    System.out.println("unknown command");

            }
        }
    }

    private void page_all() {

        String in;

        while (true) {

            System.out.println("[ SHAKESHACK MENU ]");

            // 정렬 안됨. 그냥 여기서 저장할 때 category별로 다 로딩해둘까.
            for (var m : list.values()) {
                System.out.println(m.getName() + " | " + m.getPrice() + " | " + m.getSummary() + " | " + m.getCategory());
            }


            System.out.println("\n command: exit, (menu name)");
            System.out.print("Type a menu name for more information or order : ");
            in = sc.nextLine();

            System.out.println();

            switch (in) {
                case "exit":
                    return;
                // sc 관련은 다 try로 묶어주긴 해야하는데. 오류 났다고 꺼버릴 수는 없으니까.
                // 오류 출력하고 이전 단계로 돌아가게끔. 일단 뺄까.
                default:
                    page_product(in);
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

    private void page_category() {


        System.out.println(String.join(", ", category.keySet()));

        System.out.println("\n command: exit");
        System.out.print("Type a category name for more information : ");

    }

    private void page_product(String name) {
        if (list.containsKey(name)) {
            System.out.println("1. in a cart" +
                    "\n2. more info" +
                    "\nother. cancel");

            switch (sc.nextInt()) {
                case 1:
                    System.out.println("type quantity");
                    if (sc.hasNextInt()) cart.add(list.get(name), sc.nextInt());
                    else {
                        System.out.println("Input error. Backward.");
                        sc.nextLine();
                    }
                    break;
                case 2:
                    System.out.println(list.get(name).getDetail());
                    break;
                default:
                    return;
            }
        } else System.out.println("Unknown name");
    }

    private void page_cart() {
        String in;

        while (true) {

            System.out.println("\n command: exit, list, replace, remove, discount, order");
            System.out.print("Type a command : ");

            in = sc.nextLine();

            switch (in) {
                case "exit":
                    return;
                case "list":
                    cart.show();
                    break;
                case "replace":
                    // 상품 목록을 보여주고, 번호로 선택하는게 확실하겠지.
                    // 다 이걸로 바꿔볼까.
                    System.out.println();
                    break;
                case "remove":

                    break;
                case "discount":
                    System.out.println("Enter Discount Type (Normal : 0 / Staff : 10% / Merit : 10%)");
                    in = sc.nextLine();
                    break;
                case "order":
                    page_cart();
                default:
                    System.out.println("unknown command");

            }
        }

    }

}
