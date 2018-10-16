public class CountDigits {

    private static int countDigits(int n) {
        return (Math.abs(n) > 0) ? countDigits(n /= 10) + 1 : 0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(n + " has " + countDigits(n) + " digit(s)");
    }

}
