public class ExponentE {

    public static int factorial(int x) {
        return (x == 1) ? 1 : factorial(x - 1) * x;
    }

    public static double eExp(int exponent) {
        int counter = 1;
        double tempval = 0;
        double val = 1;
        while(counter < 100) {
            tempval = val;
            val += Math.pow(exponent, counter) /
                factorial(counter);
            if(val - tempval < 0.0000000000001) break;
            counter++;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(eExp(1));
        System.out.println(eExp(2));
        //eExp(1);
        //eExp(2);
    }
}
