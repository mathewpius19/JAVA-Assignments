
class sum {
    static int summer() {
        double maxVal = (double) Integer.MAX_VALUE;
        int s = 0;// sum
        int result = 0;
        int maxInt = (int) maxVal;
        for (int i = 1; i < maxInt; i++) {
            s += Math.pow(i, 2);
            if (s >= maxVal) {
                result = i - 1;
                break;
            }
        }
        return result;
    }

    public static void main(String args[]) {
        int result = summer();
        System.out.println(result);
    }
}