package challenge.UI;

public class Item {
    private int price;
    private String name;
    private String summary;
    private String detail;
    private String category;
    private boolean available = true;

    Item(){
    }

    Item(String name, String summary, String detail, String category, int price){
        this.price = price;
        this.name = name;
        this.summary = summary;
        this.detail = detail;
        this.category = category;
    }


    public void setSummary(String summary) {
        this.summary = summary;
//        System.out.println("setSummary");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSummary() {
        return summary;
    }

    public String getName() {
        return name;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
