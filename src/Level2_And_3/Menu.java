package Level2_And_3;

import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    // map<key,item>
    // : map<name,item> ?
    // : map<id,item> ?
    private static HashMap<String, MenuItem> list = new HashMap<>();

    public static void init(){
        Menu.load();
    }

    // 뭐지. 왜 add로 선언하니까 이렇게 나오는거지. IDE가 뭘 본거지? Java는 연산자 오버라이딩 안하는거 아니었나?
    // 단순 IDE 오류? 일단 써보고. 문제 있으면 오류 뜨겠지.
    public static void add(String name, String summary, String detail, int price){
        if(list.containsKey(name)) throw new RuntimeException("same name");
        list.put(name, new MenuItem(name, summary, detail, price));
    }

    public static MenuItem add(String name){
        var m = new MenuItem();
        m.setName(name);
        list.put(name, m);
        return m;
    }

    public static void remove(String name){
        if (list.containsKey(name)) list.remove(name);
        else System.out.println("unknown name");
    }

    // HashMap 말고 ArrayList로 주는게 나을까. 어차피 비활성 메뉴 등 걸러야 하는데.
    public static HashMap<String,MenuItem> getList(){
        return list;
    }

    public static void cmd(){

        Scanner sc = new Scanner(System.in);
        String in;

        while(true){
            System.out.println("Menu system." +
                    "\n Commands : exit, create, remove, list");
            in = sc.nextLine();

            switch(in){
                case "exit":
                    return;
                case "create":
                    System.out.println("요리 이름");
                    MenuItem m;
                    try{
                        m = add(sc.nextLine());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        break;
                    } // catch (Throwable e) {}
                    // Scanner 입력 오류 나면 뭐 나오지.
                    // 아래도 스캐너 오류 판별해서 remove(m.name) 해줘야 하나?

                    System.out.println("간략한 설명");
                    m.setSummary(sc.nextLine());

                    // nextLine으로 받으니까 줄바꿈이 안되네. 입력에서 조절이 가능한가? 아니면 다른 메소드? 그도 아니면 그냥 버퍼리더?
                    System.out.println("자세한 설명");
                    m.setDetail(sc.nextLine());

                    System.out.println("가격 (정수 / 단위 원)");
                    m.setPrice(sc.nextInt());
                    break;

                case "remove":
                    System.out.println("지울 이름");
                    remove(sc.nextLine());
                    break;

                case "list":
                    // case가 다르고 무조건 break 나는데 MenuItem m으로 선언하면 IDE는 무조건 m이 이미 있다고 하네.
                    for(MenuItem menu : list.values()){
                        // StringBuilder 쓰면 문자 간격 맞추는 기능이 있을까?
                        // 없으면 자릿수 판별해서 맞춰줘야 하나?
                        // 자릿수도 폰트 크기에 따라 안맞을 수 있는데?
                        System.out.println(menu.getName() + " | " + menu.getPrice() + " | " + menu.getSummary() +
                                "\n" + menu.getDetail() + "\n") ;
                    }
                    break;

                default:

            }

        }

    }

    public static void save(){};

    public static void load(){
        list.put("ShackBurger",new MenuItem(
                "ShackBurger",
                "토마토, 양상추, 쉑소스가 토핑된 치즈버거",
                "당 점이 추구하는 맛의 균형." +
                        "\n 영양 정보 " +
                        "\n : 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                        "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                        "\n 552kcal",
                6900
        ));

        list.put("SmokeShack",new MenuItem(
                "SmokeShack",
                "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
                "바삭한 베이컨과 맵지 않은 체리페퍼." +
                        "\n 영양 정보 " +
                        "\n : 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                        "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                        "\n 573kcal",
                8900
        ));
        list.put("CheeseBurger",new MenuItem(
                "CheeseBurger",
                "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
                "묵직한 맛." +
                        "\n 영양 정보 " +
                        "\n : 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                        "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                        "\n 637kcal",
                6900
        ));
        list.put("Hamburger",new MenuItem(
                "Hamburger",
                "비프패티를 기반으로 야채가 들어간 기본버거",
                "패티의 맛만 한껏 느껴보고 싶다면." +
                        "\n 영양 정보 " +
                        "\n : 밀가루(원산지:미국) / 소고기(원산지:혼합) / 양상추(원산지:국산)" +
                        "\n 단백질 : ? / 탄수화물 : ? / 포화지방 : ? / ..." +
                        "\n 452kcal",
                5400
        ));

    };
}
