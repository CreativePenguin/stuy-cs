public class RationalClient {

    private static Rational[] testRepeat(int len) {
        int val = new int[len];
        for(int i = 0; i < len; i ++) {
            int randNum = (int) (Math.random() * 100);
            val[i] = new Rational(0, randNum);
        }
        return val;
    }

    private static Rational q4a(Rational a, Rational b, Rational c, Rational d) {
        return a.plus(b.plus(c.plus(d)));
    }

    private static Rational q4b(Rational a, Rational b, Rational c, Rational d) {
        Rational sum = a.times(b.plus(c));
        return sum.minues(d);
    }

    private static Rational q4b(Rational a, Rational b, Rational c, Rational d) {
        Rational sumAB = a.plus(b);
        Rational sumCD = c.plus(d);
        return sumAB.divideBy(sumCD);
    }

    //Compute sum
    private static Rational q5(ArrayList<Rational> list) {
        Rational sum = new Rational();
        for(Rational i : list) {
            sum = sum.plus(i);
        }
        return sum;
    }

    private static Rational e() {
        for(int i = 0; i <= 10; i++) {
            sum = sum.plus(

    private static void main(String[] args) {
        for(Rational i : testZero(3)) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(new Rational(3, -4));
    }

}
