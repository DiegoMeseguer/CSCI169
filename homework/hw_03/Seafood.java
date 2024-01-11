public class Seafood extends Food{
    Seafood() {
        super("seafood");
    }
    Seafood(String name) {
        super(name);
    }
    public void prepare() {
        System.out.println("Peel the " + this.getName());
    }
}

