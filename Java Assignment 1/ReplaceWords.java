import java.io.*;
import java.util.*;

public class ReplaceWords {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the paragraph");
        String para = in.nextLine();

        final Vector<String> v1 = new Vector<String>();
        v1.add("Happy");
        v1.add("Hello");
        v1.add("World");
        ReplaceWords rep = new ReplaceWords();
        String ans = rep.replaceWords(para, v1);
        System.out.println("Replaced Para is: \n" + ans);
        in.close();
    }

    public String replaceWords(String para, Vector<String> v1) {
        String replacedString = "";
        for (String s : v1) {
            replacedString = replaceString(s);
            para = para.replaceAll(s, replacedString);
        }
        return para;
    }

    public String replaceString(String str) {
        String replaced;
        char first = str.charAt(0);
        replaced = String.valueOf(first);
        for (int i = 0; i < str.length() - 1; i++) {
            replaced = replaced + "*";
        }
        return replaced;
    }
}