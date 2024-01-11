import java.util.Date;
public class Fruit extends Food implements Comparable<Fruit> {
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

    @Override
    public int compareTo(Fruit o) {
        if (this.ripe.compareTo(o.ripe) == 0) {
            return 0;
        }
        else if (this.ripe.compareTo(o.ripe) < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }
}


