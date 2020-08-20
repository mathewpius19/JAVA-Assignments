import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Anagram an = new Anagram();
        String str1, str2;
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the String and Anagram");
        str1 = in.next();
        str2 = in.next();
        String result = an.isAnagram(str1, str2);
        System.out.println(result);
        in.close();
    }

    public String isAnagram(String str1, String str2) {
        int count1 = 0;
        String result;
        if (str1.length() != str2.length()) {
            result = "Its not an Anagram";
            return result;
        }
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    count1++;
                    break;
                } else {
                    if (j == str2.length() - 1) {
                        count1 = 0;
                        break;
                    } else {
                        continue;
                    }
                }
            }
        }
        if (count1 == str1.length()) {
            result = "It is an Anagram";
            return result;
        } else {
            result = "It's not an Anagram";
            return result;
        }

    }

}