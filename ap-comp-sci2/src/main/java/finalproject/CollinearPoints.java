package finalproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import finalproject.util.Equation;
import finalproject.util.Point;

public class CollinearPoints {
    public List<Equation> bruteForce(Point[] points) {
        int counter = 0; 
        List<Equation> equations = new ArrayList<>();
        for(Point i : points) {
            counter++;
            for(Point j : Arrays.copyOfRange(points, counter, points.length)) {
                equations.add(calcSlopeAndYIntercept(i, j));
            }
        }
        for(var i : equations) 
            if(numInListExceeds(equations, i, 4))
                while(equations.remove(i)) equations.remove(i);
        return equations;
    }
    
    private Equation calcSlopeAndYIntercept(Point p1, Point p2) {
        double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        double yintercept = p1.getY() - p1.getX() * slope;
        return new Equation(slope, yintercept);
    }
    
}
