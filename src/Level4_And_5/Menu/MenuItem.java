package Level4_And_5.Menu;

import java.util.ArrayList;

public class MenuItem {
    private int price;
    private String name;
    private String summary;
    private String detail;
    private String category;
    private boolean available = true;



    MenuItem(String name, String summary, String detail, String category, int price) {

        this.name = name;
        this.summary = summary;
        this.detail = detail;

        this.category = category;
        // Menu.list에 추가
        if(!Menu.category.containsKey(category)) Menu.category.put(category, new ArrayList<>());
        Menu.category.get(category).add(this);

        this.price = price;

        Menu.list.put(name,this);
    }

    // 제한자 default. MenuItem 접근은 Kiosk / Menu Class 까지만.
    // 클라이언트는 Kiosk와 소통할테고.
    // getInfo를 여기에 public으로 만드는게 좋을까
    // 아니면 Menu에서 JSON 같은걸로 만들어 출력하는게 좋을까.

    // get을 해놓긴 했는데 애매하긴 하네.
    // 놔둘 필요도 적지만 굳이 지울 필요도 적나.
    // 컴파일러 믿어? 컴퓨터 성능을 믿어?
    int getPrice() {
        return price;
    }

    String getDetail() {
        return detail;
    }

    String getName() {
        return name;
    }

    String getSummary() {
        return summary;
    }

    String getCategory() { return category; }

    boolean isAvailable() {
        return available;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    void setName(String name) {
        if(this.name == name) return;

        if(Menu.list.containsKey(name)) throw new RuntimeException("already used name");

        Menu.list.put(name, this);
        Menu.list.remove(this.name);
        this.name = name;
    }

    void setSummary(String summary) {
        this.summary = summary;
    }

    void setAvailable(boolean available) { this.available = available; }

    void setCategory(String category) {
        // 이전 카테고리
        Menu.category.get(this.category).remove(this);
        if(Menu.category.get(this.category).isEmpty()) Menu.category.remove(this.category);

        // 이동할 카테고리
        if(!Menu.category.containsKey(category)) Menu.category.put(category, new ArrayList<>());
        Menu.category.get(category).add(this);

        this.category = category;
    }



}