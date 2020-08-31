import java.util.Scanner;

public class HailstoneSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number");
        try {
            int n = sc.nextInt();
            if (n <= 0) {
                throw new ArithmeticException("");
            } else {
                System.out.println("Hailstone Sequence of " + n + " is");
                while (n != 1) {
                    if (n % 2 == 0) {
                        n = n / 2;
                    } else {
                        n = (n * 3) + 1;
                    }
                    System.out.println(n);
                }
            }
        } catch (Exception e) {
            System.out.println("Value entered is not an Integer or Integer is a negative value or zero");
        }

        sc.close();

    }
}