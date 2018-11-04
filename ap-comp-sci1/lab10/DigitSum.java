public class DigitSum {

    private int digitSum(int n) {
        return (n - 10 < 0) ? n : digitSum(n / 10) + n % 10;
    }

}
