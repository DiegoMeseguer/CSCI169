import java.util.Date;

public class Orange extends Fruit{
    Orange() {
        super("orange", new Date());
    }
    Orange(Date date) {
        super("orange", date);
    }
    public void prepare() {
        System.out.println("Peel the " + this.getName());
    }
}

