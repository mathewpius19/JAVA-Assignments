public class countingThread extends Thread {
    public static void main(String[] args) {

        countingThread t = new countingThread();
        t.start();

    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                if (i % 10 == 0) {
                    System.out.println("Some String" + i);
                }

            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

}