public class Client {

    public static void main(String[] args) {
	Shape tri = new RtTriangle(3, 4);
	System.out.println(tri.getArea());
	System.out.println(tri.getPerimeter());
	System.out.println(tri.getNumSides());

	Rectangle quad = new Rectangle(3, 3);
	System.out.println(quad.getArea());
	System.out.println(quad.getPerimeter());
        quad.resize(2);
	System.out.println(quad.getArea());
	System.out.println(quad.getPerimeter());
    }

}
