import java.util.Arrays;
public class HW3P1 {
    static int INPUT_SIZE = 10;
    // Partition Function
    public static int partition(int input[], int p, int r) {
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
    public static void quicksort(int input[], int p, int r) {
        if (p < r) {
            int j = partition(input, p, r);
            quicksort(input, p, j - 1);
            quicksort(input, j + 1, r);
        }
    }
    public static void main(String[] args) {
        int input[] = {500, 700, 800, 100, 300, 200, 900, 400, 1000, 600};

        System.out.println("Input: " + Arrays.toString(input));
        quicksort(input, 0, 9);
        System.out.println("Output: " + Arrays.toString(input));
    }
}
