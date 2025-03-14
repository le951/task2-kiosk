package challenge.Menu;

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
        if (!Menu.category.containsKey(category)) Menu.category.put(category, new ArrayList<String>());
        Menu.category.get(category).add(name);

        this.price = price;

        Menu.list.put(name, this);
    }

    // 제한자 default. MenuItem 접근은 Kiosk / Menu Class 까지만.
    // 클라이언트는 Kiosk와 소통할테고.
    // getInfo를 여기에 public으로 만드는게 좋을까
    // 아니면 Menu에서 JSON 같은걸로 만들어 출력하는게 좋을까.

    // Menu까지 여기서 엮어놓는게 맞나?
    // 파일을 엄중하게 분리한다면 Menu.list / Menu.category 관련된 것들은 다 Menu.java 내에서 처리하는게 맞는데.
    // 근데 이게 더 편하지 않나?

    // default로 하면 Jackson에서 오류 뜨네.
    // Jackson으로 불러오려면 결국 MenuItem 클래스를 쓰거나, 비슷한 클래스를 만들거나 해야하나.
    // 클라이언트 분리라는 명목 하에선 충실하네. Kiosk 구현이라는 명목 하에선 별로고.
    //
    public int getPrice() {
        return price;
    }

    public String getDetail() {
        return detail;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public String getCategory() {
        return category;
    }

//    @Override
//    public String toString() {
//        return "{" +
//                "price : " + price +
//                ", name : \"" + name + '\"' +
//                ", summary : \"" + summary + '\"' +
//                ", detail : \"" + detail + '\"' +
//                ", category : \"" + category + '\"' +
//                ", available : " + available +
//                '}';
//    }

    public boolean isAvailable() {
        return available;
    }

    void setPrice(int price) {
        this.price = price;
    }

    void setDetail(String detail) {
        this.detail = detail;
    }

    void setName(String name) {
        if (this.name.equals(name)) return;

        if (Menu.list.containsKey(name)) throw new RuntimeException("already used name");

        Menu.list.put(name, this);
        Menu.list.remove(this.name);
        this.name = name;
    }

    void setSummary(String summary) {
        this.summary = summary;
    }

    void setAvailable(boolean available) {
        this.available = available;
    }

    void setCategory(String category) {
        // 이전 카테고리
        Menu.category.get(this.category).remove(name);
        if (Menu.category.get(this.category).isEmpty()) Menu.category.remove(this.category);

        // 이동할 카테고리
        if (!Menu.category.containsKey(category)) Menu.category.put(category, new ArrayList<String>());
        Menu.category.get(category).add(name);

        this.category = category;
    }

}