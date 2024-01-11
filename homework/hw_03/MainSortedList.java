import java.util.Scanner;
public class MainSortedList
{
    public static void main(String args[])
    {
        int c, n, search, array[];
        Scanner in = new Scanner(System.in);
        System.out.print("Enter number of elements: ");
        n = in.nextInt();
        array = new int[n];
        System.out.println("Enter " + n + " integers in ascending order");
        for (c = 0; c < n; c++)
            array[c] = in.nextInt();
        SortedList s = new SortedList(array);
        System.out.println("Enter value to find");
        search = in.nextInt();
        in.close();
        int spot = s.binsearch(search);
        if(spot>=0)
            System.out.println(search + " found at location " + spot + ".");
        else
            System.out.println(search + " is not present in the list.\n");

        //test default constructor
        SortedList test = new SortedList();
        int found = test.binsearch(7);
        System.out.println(found); // Should print 6

        //Test the insert function that uses quicksort to maintain ordered array
        int newArr[] = new int[]{3, 5, 6, 19, 50};
        SortedList test2 = new SortedList(newArr);
        test2.insert(18);
        test2.printSortedList();
    }

}