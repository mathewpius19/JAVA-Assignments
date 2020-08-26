import java.util.Scanner;

public class StringCompare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the 2 strings you want to compare");
        String str1 = sc.next(), str2 = sc.next();
        int result = 0;
        StringCompare st = new StringCompare();
        result = st.compareString(str1, str2);
        System.out.println("Result of Comparison is " + result);
        sc.close();
    }

    public int compareString(String str1, String str2) {
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if ((int) str1.charAt(i) == (int) str2.charAt(i)) {
                continue;
            } else {
                return (int) str1.charAt(i) - (int) str2.charAt(i);
            }
        }
        if (str1.length() < str2.length()) {
            return str1.length() - str2.length();
        } else if (str1.length() > str2.length()) {
            return str1.length() - str2.length();
        } else {
            return 0;
        }
    }
}