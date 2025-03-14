package Level1;

import java.util.ArrayList;

public class Menu {

    private static ArrayList<MenuItem> list;


    public static void init(){
        Menu.load();
    }

    // 뭐지. 왜 add로 선언하니까 이렇게 나오는거지. IDE가 뭘 본거지? Java는 연산자 오버라이딩 안하는거 아니었나?
    // 단순 IDE 오류? 일단 써보고. 문제 있으면 오류 뜨겠지.
    public static void add(){}

    public static void remove(){}

    public static void save(){};

    public static void load(){};

}
