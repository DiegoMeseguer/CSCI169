public class Prawn extends Seafood{
    Prawn() {
        super("prawn");
    }

    public void prepare() {
        System.out.println("Peel the " + this.getName());
    }

}

