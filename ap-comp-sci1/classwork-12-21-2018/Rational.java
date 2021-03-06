public final class Rational {

    private final int NUM;
    private final int DEN;

    public Rational(int NUM, int DEN) {
        if(DEN == 0) throw new RuntimeException("DIVISION BY ZERO");
        this.NUM = NUM / gcd(NUM, DEN);
        this.DEN = DEN / gcd(NUM, DEN);
    }

    public Rational(int NUM){
        this(NUM, 1);
    }

    public Rational() {
        this(0, 1);
    }

    private int gcd(int num, int den) {
        return gcd(den, num % den);
    }

    @Override
    public String toString() {
        return NUM + "/" + DEN;
    }

    public Rational plus(Rational other) {
        return new Rational(NUM * other.DEN + other.NUM * DEN, DEN * other.DEN);
    }

    public Rational minus(Rational other) {
        return new Rational(NUM * other.DEN - other.NUM * DEN, DEN * other.DEN);
    }

    public Rational times(Rational other) {
        return new Rational(NUM * other.NUM, DEN * other.DEN);
    }

    public Rational dividesBy(Rational other) {
        return new Rational(NUM * other.DEN, DEN * other.NUM);
    }

}
