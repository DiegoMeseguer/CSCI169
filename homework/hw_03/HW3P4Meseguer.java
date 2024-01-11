import java.util.ArrayList;
import java.lang.Integer;
import java.util.Date;

public class HW3P4Meseguer {

    public static ArrayList<Object> foo(ArrayList<String> lista) {
        int counter = 0;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == "Food" || lista.get(i) == "Orange" || lista.get(i) == "Apple" || lista.get(i) == "Fruit") {
                counter += 1;
            }
        }
        ArrayList<Object> result = new ArrayList<Object>();

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == "Food" && (lista.get(i + 1) != "Fruit" || lista.get(i + 1) != "Food" || lista.get(i + 1) != "Apple"
                    || lista.get(i + 1) != "Orange")) {
                result.add(new Food(lista.get(i + 1)));
            } else {
                result.add(new Food());
            }
            if (lista.get(i) == "Fruit" && (lista.get(i + 1) != "Fruit" || lista.get(i + 1) != "Food" || lista.get(i + 1) != "Apple"
                    || lista.get(i + 1) != "Orange")) {
                Date temp = new Date(Integer.parseInt(lista.get(i + 2)));
                result.add(new Fruit(lista.get(i + 1), temp));
            } else {
                result.add(new Fruit());
            }

        }

        return result;
    }
    public static void main(String[] args) {
        ArrayList<String> test = new ArrayList<String>();
        test.add("Food");
        test.add("Orange");
        test.add("Fruit");
        test.add("Papaya");
        test.add("3932728");
        test.add("Apple");
        test.add("now");
        test.add("Food");
        test.add("sandwich");

        System.out.println(test);

        ArrayList<Object> test1 = foo(test);
        System.out.println(test1);
    }
}
