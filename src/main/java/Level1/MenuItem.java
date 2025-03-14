package Level1;

import java.util.ArrayList;

public class MenuItem {
    private int price;
    private String name;
    private String summary;


//    private static ArrayList<MenuItem> list;
//
// 여기다 하기 vs Menu Class에서 하기. Menu가 맞겠지.
//    public static ArrayList<MenuItem> getAll(){
//        return list;
//    }

    public MenuItem(String name, String summary, int price){
//        list.create(this);
        this.name = name;
        this.summary = summary;
        this.price = price;
    }

}