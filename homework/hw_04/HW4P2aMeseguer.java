import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
public class HW4P2aMeseguer {

    public static void printFruitList(ArrayList<Fruit> lista) {
        int length  = lista.size();
        for(int i = 0; i < length; i++) {
            System.out.print(lista.get(i).getName() + " - ");
            lista.get(i).ripeTime();
        }
    }
    public static void main(String[] args) {

        Date fecha01 = new Date(200000);
        Date fecha02 = new Date(5000);
        Date fecha03 = new Date(90000);
        Date fecha04 = new Date(7000000);

        System.out.print("==== Before sorting ====");
        ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>();
        fruitArrayList.add(new Fruit("fruta01", new Date()));
        fruitArrayList.add(new Fruit("fruta02", fecha01));
        fruitArrayList.add(new Fruit("fruta03", fecha02));
        fruitArrayList.add(new Apple(fecha03));
        fruitArrayList.add(new Apple(fecha04));
        fruitArrayList.add(new Orange());

        printFruitList(fruitArrayList);

        System.out.println("==== After sorting ====");
        Collections.sort(fruitArrayList);

        printFruitList(fruitArrayList);


//        Date fecha = new Date(2000000);
//        Fruit test = new Fruit();
//        test.ripeTime();
//        Fruit test2 = new Fruit("Paulina", fecha);
//        test2.ripeTime();
//        Apple manzana = new Apple();
//        Date fechaNaranja = new Date(50000);
//        Orange naranja = new Orange(fechaNaranja);
//
//        int result;
//
//        Date fecha1 = new Date(200000);
//        Date fecha2 = new Date();
//        System.out.println(fecha1);
//        System.out.println(fecha2);
//        result = fecha1.compareTo(fecha2); // I expect less tha 0
//        System.out.println(result);
//        int result1;
//        result1 = test2.compareTo(test2);
//        System.out.println(result1);
//
//        int result2;
//        result2 = manzana.compareTo(naranja);
//        System.out.println(result2);

    }
}

