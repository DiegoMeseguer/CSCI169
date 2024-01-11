public class Food {
    private String name;
    Food() {
        this.name = "food";
    }
    Food(String name) {
        this.name = name;
    }
    public void prepare() {
        System.out.println("Prepare the " + this.name);
    }
    public String getName() {
        return this.name;
    }
}

