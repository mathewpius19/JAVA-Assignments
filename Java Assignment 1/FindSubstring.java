import java.util.Scanner;

public class FindSubstring {

    public static void main(String[] args) {
        int count1 = 0, count2 = 0;
        String str;
        String substring;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the string and substring");
        str = in.next();
        substring = in.next();
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < substring.length(); j++) {
                if (str.charAt(i) == substring.charAt(j)) {
                    count1++;
                    break;
                } else {
                    if (j == substring.length() - 1) {
                        count1 = 0;
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (count1 == substring.length()) {
                count1 = 0;
                count2++;
            }
        }
        System.out.println("Number of occurances of Substring is " + count2);
        in.close();
    }

}