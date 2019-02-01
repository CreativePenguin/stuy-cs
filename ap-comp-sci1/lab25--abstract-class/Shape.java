public abstract class Shape implements Resizable {

    protected int numSides;

    public Shape(int numSides) {
	this.numSides = numSides;
    }

    public int getNumSides() {
	return numSides;
    }

    abstract double getArea();
    abstract double getPerimeter();
    public abstract void resize(double x);
}
