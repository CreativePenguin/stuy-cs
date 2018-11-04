public class DigitSum {

    private int digitSum(int n) {
        return (n - 10 < 0) ? n : digitSum(n / 10) + n % 10;
    }

    private int digitalRoot(int n) {
        return (digitSum(n) - 10 < 0) ? digitSum(n) :
            digitalRoot(digitSum(n));
    }

}
