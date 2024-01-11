import java.util.Date;
public class Fruit extends Food {
    private Date ripe;
    Fruit() {
        super("fruit");
        Date date = new Date();
        this.ripe = date;
    }
    Fruit(String name, Date date) {
        super(name);
        this.ripe = date;
    }
    public void ripeTime() {
        System.out.println("You can eat it on: " + this.ripe);
    }
}

