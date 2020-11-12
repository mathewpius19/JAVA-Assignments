public class largestNumberOfDivisors extends Thread {

    int startValue;
    static int maxDivCount = 0, num = 0;

    largestNumberOfDivisors(int startValue) {
        this.startValue = startValue;
    }

    public static void main(String[] args) {
        largestNumberOfDivisors t1 = new largestNumberOfDivisors(1);
        largestNumberOfDivisors t3 = new largestNumberOfDivisors(1000);
        largestNumberOfDivisors t2 = new largestNumberOfDivisors(2000);
        largestNumberOfDivisors t4 = new largestNumberOfDivisors(3000);
        largestNumberOfDivisors t5 = new largestNumberOfDivisors(4000);
        largestNumberOfDivisors t6 = new largestNumberOfDivisors(5000);
        largestNumberOfDivisors t7 = new largestNumberOfDivisors(6000);
        largestNumberOfDivisors t8 = new largestNumberOfDivisors(7000);
        largestNumberOfDivisors t9 = new largestNumberOfDivisors(8000);
        largestNumberOfDivisors t10 = new largestNumberOfDivisors(9000);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
        t9.start();
        t10.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
            t6.join();
            t7.join();
            t8.join();
            t9.join();
            t10.join();
        } catch (Exception e) {
        }
        System.out.println("Number is " + num + " and max number of divisors are " + maxDivCount);
    }

    public void run() {
        int div = 0;
        for (int i = this.startValue; i <= this.startValue + 1000; i++) {
            div = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    div += 1;
                }

            }
            if (div > maxDivCount) {
                synchronized (this) {
                    maxDivCount = div;
                    num = i;
                }
            }
        }
    }
}
