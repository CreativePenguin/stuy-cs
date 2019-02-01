public class RtTriangle extends Shape {

    private int width;
    private int height;

    public RtTriangle(int width, int height) {
	super(3);
	this.width = width;
	this.height = height;
    }

    @Override
    public double getArea() {
	return width * height * 0.5;
    }

    @Override
    public double getPerimeter() {
	return width + height +
	    Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
    }

}
