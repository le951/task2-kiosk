package challenge.UI;

import java.util.ArrayList;
import java.util.HashMap;

public class Cart {
    // 이건 프론트엔드라고 봐야하나.
    // 아니. 서버에서도 결제할 때 가격 체크는 하긴 해야지.
    // 딱 Kiosk면 프론트로만 봐도 OK고, 홈페이지 같은거면 서버에도 기능이 있어야겠네.
    //

    // 필요 기능
    // 선택한 상품 저장
    // 수량 저장
    // 수량 편집
    // 가격 확인
    // 할인 적용


    // 당장은 Kiosk Class에서만 호출인가?
    // default

    private HashMap<Item, Integer> items = new HashMap<>();

    // 매 연산마다 수동으로 빼고 더할까, total_update 같은거 만들어서 items 다 돌릴까.
    private int total = 0;
    private UserType discount_type = UserType.Norman;

    Cart() {

    }

    void add(Item item, int quantity) {
        items.put(item, quantity);
        total += item.getPrice()*quantity;
    }

    void replace(Item item, int quantity) {
        if (items.containsKey(item)) {
            if (items.get(item) > quantity){
                items.replace(item, items.get(item) - quantity);

            }
            else items.remove(item);
        }
    }

    void remove(Item item) {
        items.remove(item);
    }

    void show() {

    }

    void discount(UserType t) {
        discount_type = t;
    }

    void clear() {
        items.clear();
        total = 0;
        discount_type = UserType.Norman;
    }

}
