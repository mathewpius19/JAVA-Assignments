import java.util.Scanner;

public class StringSort {
    public static void main(String[] args) {
        StringSort st = new StringSort();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String you wish to sort");
        String str = sc.next();
        char array[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            array[i] = str.charAt(i);
        }
        st.sortString(array);
        str = new String(array);
        System.out.println("Sorted String is " + str);
        sc.close();
    }

    public void sortString(char array[]) {
        char output[] = new char[array.length];
        char count[] = new char[256];
        for (int i = 0; i < 256; i++) {
            count[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            ++count[array[i]];
        }
        for (int i = 1; i < 256; i++) {
            count[i] += count[i - 1];
        }
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            --count[array[i]];
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }
}
