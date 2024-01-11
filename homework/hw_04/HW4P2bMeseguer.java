public class HW4P2bMeseguer {

    public static void main(String args[])
    {
        int arr[] = new int[]{3, 5, 6, 19, 50};
        SortedList myIterable = new SortedList(arr);
        myIterable.insert(12);
        myIterable.insert(30);

        // use the foreach loop to print out contents
        for(Integer x : myIterable) {
            System.out.print(x + " ");
        }
    }




}
