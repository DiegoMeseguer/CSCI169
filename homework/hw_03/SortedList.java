import java.util.Arrays;
public class SortedList{
    private int array[];

    SortedList() {
        array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    }
    SortedList(int arr[]) {
        array = arr;
    }
    public void sort(){
        quicksort(array, 0, this.array.length - 1);
    }

    public void insert(int element) {
        int newArray[] = new int[array.length + 1];
        for(int i = 0; i < array.length; i++)  {
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        quicksort(newArray, 0, newArray.length - 1);
        array = newArray;
    }
    public int binsearch(int search){
        int n=array.length;
        int first, last, middle;
        first  = 0;
        last   = n - 1;
        middle = (first + last)/2;
        while( first <= last )
        {
            if ( array[middle] < search )
                first = middle + 1;
            else if ( array[middle] == search )
            {
                return middle;
            }
            else
                last = middle - 1;
            middle = (first + last)/2;
        }
        return -1;
    }

    public  int partition(int input[], int p, int r) {
        int pivot = input[r];

        while (p < r) {
            while (input[p] < pivot) {
                p++;
            }
            while (input[r] > pivot) {
                r--;
            }
            if (input[p] == input[r]) {
                p++;
            } else if (p < r) {
                int tmp = input[p];
                input[p] = input[r];
                input[r] = tmp;
            }
        }
        return r;
    }

    // Recursive Quicksort
    public  void quicksort(int input[], int p, int r) {
        if (p < r) {
            int j = partition(input, p, r);
            quicksort(input, p, j - 1);
            quicksort(input, j + 1, r);
        }
    }

    public void printSortedList() {
        System.out.println("The contents of the sorted array are: ");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }




}