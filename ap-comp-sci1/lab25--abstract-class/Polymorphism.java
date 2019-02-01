import java.util.List;
import java.util.ArrayList;

public class Polymorphism {
    
    public static void main(String[] args) {
        Rectangle quad = new Rectangle(2, 3);
        RtTriangle tri = new RtTriangle(2, 3);
        List<Shape> list = new ArrayList<>();
        list.add(quad); list.add(tri);
        for(Shape i : list) {
            if(i instanceof Resizable) {
                i.resize(0.5);
                System.out.println(i.getArea());
                System.out.println(i.getPerimeter());
            }
        }
    }
    
}
