import java.util.Scanner;

public class CountingSort {
    public static void main(String[] args) {
        CountingSort cs = new CountingSort();
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter the size of array");
        n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter a value between 0 and 20");
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        cs.countingSort(array);
        System.out.println("Sorted array is ");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void countingSort(int array[]) {
        int length = array.length;
        int[] output = new int[length];
        int[] count = new int[20];
        for (int i = 0; i < 20; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < length; i++) {
            ++count[array[i]];
        }
        for (int i = 1; i < 20; i++) {
            count[i] += count[i - 1];
        }
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            --count[array[i]];
        }
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }
}