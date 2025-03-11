package Level4_And_5.Menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Menu {

    // 이 경우 list.get(String) 을 넣으면 동등성인가. Object 받는다 되어있어 햇갈리네.
    // Object의 Equal 기능을 쓰는건가? String.isEqual("");
    static HashMap<String, MenuItem> list = new HashMap<>();
    static HashMap<String, ArrayList<MenuItem>> category = new HashMap<>();
//    Category에 포함된 메뉴가 0일 때 자동 삭제할건가? -> Map
//    Category 생성을 별도로 할텐가? -> Set
    // 검색 캐시도 하는 겸 Map으로 하자 그냥.
    // ArrayList vs LinkedList vs HashMap
    // category가 빈번하진 않으니 ArrayList로 가자.

    // 이렇게 list와 category에 담으면 동일 객체를 담는 것이 맞나? new 해주는거 아니면 맞지? heap에 들어가고.

    public static void init(){
        Menu.load();
    }

    // 뭐지. 왜 add로 선언하니까 이렇게 나오는거지. IDE가 뭘 본거지? Java는 연산자 오버라이딩 안하는거 아니었나?
    // 단순 IDE 오류? 일단 써보고. 문제 있으면 오류 뜨겠지.
    public static void add(String name, String summary, String detail, String category, int price){
        if(list.containsKey(name)) throw new RuntimeException("same name");
        new MenuItem(name, summary, detail, category, price);
    }

    public static void add(String name){
        add(name, "default summary", "default detail", "default category", 2147483647);
    }


    // 유효성 검사는 MenuItem에서 하자. 이게 확실하고 좋네.
    // 그러면 Menu Class는 무슨 의미가 있을까. 어차피 MenuItem으로 바로 이어지는데?
    // 단순 분리? list 검색? (JSON-Class)클라이언트 연결 및 전환? 인터페이스? 클라이언트 권한 검사?
    // 나중에는 분리할게 더 생기긴 할 것 같네.
    public static void rename(String old_name, String new_name){
        list.get(old_name).setName(new_name);
    }

    public static void revise(String name, String summary, String detail, String category, int price){
        var m = Menu.list.get(name);

//        if(m.getSummary() !=null || !m.getSummary().equals(summary)) m.setSummary(summary);
//        if(m.getDetail() !=null || !m.getDetail().equals(detail)) m.setDetail(detail);
//        if(m.getCategory() !=null || !m.getCategory().equals(category)) m.setCategory(category);
        m.setSummary(summary);
        m.setDetail(detail);
        m.setCategory(category);
        m.setPrice(price);
    }



    public static void remove(String name){
        if (!list.containsKey(name)) {
            System.out.println("unknown name");
            return;
        }
        var c = category.get(list.get(name).getCategory());
        c.remove(list.get(name));
        if(c.isEmpty()) category.remove(list.get(name).getCategory());
        list.remove(name);

        // 여기까지만 하면 GC가 알아서 메모리 치워주나?
    }

    // HashMap 말고 ArrayList로 주는게 나을까. 어차피 비활성 메뉴 등 걸러야 하는데.
    public static HashMap<String, MenuItem> getList(){
        return list;
    }

    // Menu Class에서 이름만 필수값, 나머지는 기본값으로라도 Item을 생성하고
    // 생성한 Item에 대해 편집기능을 Menu Class 내에 만들어 실행
    // MenuItem Class에 대해 접근자 제한... 은 어떻게 해주지. 해줘야 하나?

    public static void cmd(){

        Scanner sc = new Scanner(System.in);
        String in;

        while(true){
            System.out.println("\nMenu system." +
                    "\n Commands : exit, create, remove, list, category, rename");
            in = sc.nextLine();
            String[] s = new String[4];

            switch(in){
                case "exit":
                    return;
                case "create":
                    System.out.println("요리 이름");

                    s[0] = sc.nextLine();
                    try{
                        add(s[0]);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                        break;
                    } // catch (Throwable e) {}
                    // Scanner 입력 오류 나면 뭐 나오지.
                    // 아래도 스캐너 오류 판별해서 remove(m.name) 해줘야 하나?

                    // 그냥 공백으로 Enter 해버리면 default 값도 아닌 이상한게 나오는겨

                    System.out.println("간략한 설명");
                    s[1] = sc.nextLine();

                    System.out.println("자세한 설명");
                    s[2] = sc.nextLine();

                    // nextLine으로 받으니까 줄바꿈이 안되네. 입력에서 조절이 가능한가? 아니면 다른 메소드? 그도 아니면 그냥 버퍼리더?
                    System.out.println("카테고리");
                    s[3] = sc.nextLine();

                    // 금액 쉼표 찍기
                    System.out.println("가격 (정수 / 단위 원)");

                    revise(s[0], s[1], s[2], s[3], sc.nextInt());

                    sc.nextLine();
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
                        // 자릿수도 폰트 크기에 따라 안맞을 수 있는데? 아. 터미널은 맞게끔 되어있나?
                        System.out.println(menu.getName() + " | " + menu.getPrice() + " | " + menu.getSummary() +
                                "\n" + menu.getDetail() +
                                "\ncategory : " + menu.getCategory() + "\n");
                    }
                    break;
                case "category":
                    for(String st : category.keySet()){
                        System.out.println(st);
                    }
                    break;

                case "rename":
                    System.out.println("type before");
                    s[0] = sc.nextLine();
                    System.out.println("type after");
                    rename(s[0],sc.nextLine());
                    break;

                default:
                    System.out.println("unknown command");

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
                "burger",
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
                "burger",
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
                "burger",
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
                "burger",
                5400
        ));

    };
}
