import java.util.ArrayList;
// Immutable ADT Rational represents a rational number (n/d).
// - it is a final class which prevents any class from subclassing it.

public final class Rational{

    // instance varriables (fields) CONSTANTS
    private final int NUM; // numerator
    private final int DEN; // denominator

    // Constructors
    // Default Constructor
    public Rational(){
	this(0,1);       // must be the first statemet 
    }
    // Constructor
    public Rational(int n){
	this(n,1);
    }
    // Constructor
    public Rational(int n, int d){
	if (d == 0) throw new RuntimeException("DIVISION BY ZERO");
	if (n == 0) {
	    // this() ;   // call to this must be the first statement
	    NUM = 0;
	    DEN = 1;
	}
	else{
	    // n is not zero
	    int sign = Math.abs(n)/n * Math.abs(d) / d;
	    n = Math.abs(n);
	    d = Math.abs(d);
	    NUM = sign *  n / gcd(n,d);
	    DEN =  d / gcd(n,d);
	}
    }

    
    public Rational plus (Rational rhs){
	return new Rational(NUM*rhs.DEN + rhs.NUM * DEN, DEN * rhs.DEN);
    }

    public Rational minus (Rational rhs){
	return new Rational(NUM*rhs.DEN - rhs.NUM * DEN, DEN * rhs.DEN);
    }

    public Rational times(Rational rhs){
	return new Rational(NUM*rhs.NUM, DEN * rhs.DEN);
    }

    public Rational divideBy(Rational rhs){
	return new Rational(NUM*rhs.DEN, DEN * rhs.NUM);
    }

    private Rational invert() {
        return new Rational(DEN, NUM);
    }

    private Rational negate() {
        return new Rational(NUM * -1, DEN);
    }

    public Double toDouble(){
	return new Double(NUM * 1.0 / DEN);
    }

    // Standard Implementation of Euclid's Algorithm
    private int gcd(int x ,  int y){
	int r  = x % y;
	while (r != 0){
	    x = y;
	    y = r;
	    r = x % y;
	}
	return y;
    }

    @Override
    public String toString(){
	return NUM + "/" + DEN;
    }

    @Override
    public boolean equals(Object that) {
        if(!(that instanceof Rational)) return false;
        Rational thatR = (Rational) that;
        return thatR.toString().equals(this);
    }

    @Override
    public int hashCode() {
        return NUM * 31 / DEN;
    }
    
    // main is used for testing should be removed when class is fully 
    // implemented.
    public static void main(String [] args){
	Rational x = new Rational(5,15);
	Rational y = new Rational(20,-4);
	// Testing basic arithmetic
	System.out.println(x + " + " + y + " = " + x.plus(y));
	System.out.println(x + " - " + y + " = " + x.minus(y));
	System.out.println(x + " * " + y + " = " + x.times(y));
	System.out.println(x + " / " + y + " = " + x.divideBy(y));
	// Generates a list of 5 rational numbers
	ArrayList<Rational> rats = new ArrayList<Rational>();
	for (int i = 0 ; i < 5 ; i++){
	    int n = -5 + (int) (Math.random() * 10);
	    int d = 1 + (int) (Math.random() * 10);
	    rats.add(new Rational(n,d));
	}
	System.out.println("rats: " + rats);
	
	
    }
}
 
