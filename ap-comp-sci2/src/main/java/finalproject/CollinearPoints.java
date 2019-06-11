package finalproject;

import java.util.List;
import java.util.ArrayList;

public class CollinearPoints {
    public List<Equations> bruteForce(Points[] points) {
        int counter = 0; 
        List<Equation> equations = new Arraylist<>();
        for(Point i : points) {
            counter++;
            for(Point j : Arrays.copyOfRange(points, counter, points.length)) {
                equations.append(calcSlopeAndYIntercept(i, j));
            }
        }
        for(var i : equations) 
            if(findNum(equations, i) < 4) 
                while(equations.remove(i)) equations.remove(i);
        return equations
    }
    
    private Equation calcSlopeAndYIntercept(Point p1, Point p2) {
        double slope = (p1.y - p2.y) / (p1.x - p2.x);
        double y-intercept = p1.y - p1.x * slope;
        return new Equation(slope, y-intercept);
    }
}
