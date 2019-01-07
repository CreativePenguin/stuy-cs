import java.util.List;
import java.util.ArrayList;

public class PointClient {

    public static List<Point> randomPoints(int n, int from, int to) {
        List<Point> val = new ArrayList<>();
        for(int i : new int[n]) {
            int x = randInt(from, to);
            int y = randInt(from, to);
            val.add(new Point(x, y));
        }
        return val;
    }

    private static int randInt(int from, int to) {
        double val =  Math.random() * (to - from) + from;
        return (int) val;
    }

    public static void translate(List<Point> pointList) {
        for(Point i : pointList) {
            i.translate(1, -1);
        }
    }

    public static int calcDist(Point a, Point b) {
        int ax = a.getX(); int ay = a.getY();
        int bx = b.getX(); int by = b.getY();
        return Math.sqrt(ax * ax + ay * ay);
    }

    public static void main(String[] args) {
        List<Point> a = randomPoints(5, 0, 10);
        System.out.println(a);
        List<Point> b = new ArrayList<>();
        Point m_point = new Point();
        for(int i : new int[5]) {
            b.add(m_point);
        }
        System.out.println(b);
        m_point.translate(5, -1);
        System.out.println(b);
    }

    /**
     * Due to the nature of equal objects just being references, changing one
     * changes them all
     */

}
        
                                           
