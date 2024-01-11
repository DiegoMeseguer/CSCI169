import java.util.Date;

public class Apple extends Fruit{
    Apple() {
        super("apple", new Date());
    }
    Apple(Date date) {
        super("apple", date);
    }
    public void prepare() {
        System.out.println("Core the " + this.getName());
    }
}

