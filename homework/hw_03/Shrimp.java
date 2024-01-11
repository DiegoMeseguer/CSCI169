public class Shrimp extends Seafood{
    Shrimp() {
        super("shrimp");
    }
    public void prepare() {
        System.out.println("Peel the " + this.getName());
    }

}

