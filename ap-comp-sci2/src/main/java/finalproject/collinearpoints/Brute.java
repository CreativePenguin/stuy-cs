package finalproject.collinearpoints;

import java.util.ArrayList;
import java.util.List;

import finalproject.util.Equation;
import finalproject.util.Point;


public class Brute {
    
    private static Brute instance;
    
    private Brute() {}
    
    public Brute getInstance() {
        return instance == null ? new Brute() : instance;
    }
    
    public List<Equation> findCollinearPoints(List<Point> points) {
        int counter = 0; 
        List<Equation> equations = new ArrayList<>();
        for(Point i : points) {
            counter++;
            for(Point j : points.subList(counter, points.size())) {
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
    
    private <E> boolean numInListExceeds(List<E> li, E val, int num) {
        int valCounter = 0;
        for(E i : li) {
            if(i.equals(val)) valCounter++;
        }
        return valCounter >= num;
    }

}
