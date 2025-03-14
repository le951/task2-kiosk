package challenge.UI;

// 사용자에 따른 할인.
// 일반, 직원, 유공자
public enum UserType {
    Normal("Normal", 0 ),
    Staff("Staff", 0.1),
    Merit("Merit", 0.1);

    String type;
    double rate;

    UserType(String type, double rate){
        this.type = type;
        this.rate = rate;
    }


}
