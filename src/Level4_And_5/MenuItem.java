package Level4_And_5;

public class MenuItem {
    private int price;
    private String name;
    private String summary;
    private String detail;
    private boolean available = true;



//    private static ArrayList<MenuItem> list;
//
// 여기다 하기 vs Menu Class에서 하기. Menu가 맞겠지.
//    public static ArrayList<MenuItem> getAll(){
//        return list;
//    }

    public MenuItem(){}

    public MenuItem(String name, String summary, String detail, int price){
//        list.create(this);
        this.name = name;
        this.summary = summary;
        this.detail = detail;
        this.price = price;
    }

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

    public boolean isAvailable() {
        return available;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


}