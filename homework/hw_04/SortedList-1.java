import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

public class SortedList implements Iterable<Integer>{
    private ArrayList<Integer> array;

    SortedList() {
        array = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }
    SortedList(int arr[]) {
        ArrayList<Integer> temp = new ArrayList<Integer>(arr.length);
        for (int i = 0; i < arr.length; i++)
            temp.add(Integer.valueOf(arr[i]));
        array = temp;
    }
    public void sort(){
        quicksort(array, 0, this.array.size() - 1);
    }

    public void insert(Integer element) {
        ArrayList<Integer>  newArray = new ArrayList<Integer>(array.size());

        for(int i = 0; i < array.size(); i++)  {
            newArray.add(array.get(i));
        }

        newArray.add(element);
        quicksort(newArray, 0, newArray.size() - 1);
        array = newArray;
    }
    public int binsearch(int search){
        int n=array.size();
        int first, last, middle;
        first  = 0;
        last   = n - 1;
        middle = (first + last)/2;
        while( first <= last )
        {
            if ( array.get(middle) < search )
                first = middle + 1;
            else if ( array.get(middle) == search )
            {
                return middle;
            }
            else
                last = middle - 1;
            middle = (first + last)/2;
        }
        return -1;
    }

    public  int partition(ArrayList<Integer> input, int p, int r) {
        int pivot = input.get(r);

        while (p < r) {
            while (input.get(p) < pivot) {
                p++;
            }
            while (input.get(r) > pivot) {
                r--;
            }
            if (input.get(p) == input.get(r)) {
                p++;
            } else if (p < r) {
                int tmp = input.get(p);
                input.set(p, input.get(r));
                input.set(r, tmp);
            }
        }
        return r;
    }

    // Recursive Quicksort
    public  void quicksort(ArrayList<Integer> input, int p, int r) {
        if (p < r) {
            int j = partition(input, p, r);
            quicksort(input, p, j - 1);
            quicksort(input, j + 1, r);
        }
    }

    public void printSortedList() {
        System.out.println("The contents of the sorted array are: ");
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
        System.out.println();
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.array.iterator();
    }
}


