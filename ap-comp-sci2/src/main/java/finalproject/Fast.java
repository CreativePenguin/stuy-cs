package finalproject;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import finalproject.util.Equation;
import finalproject.util.Point;
import finalproject.util.Sorts;

public class Fast {
    
    private static Fast instance;
    
    private Fast() {}
    
    public static Fast getInstance() {
        return (instance == null) ? new Fast() : instance;
    }
    
    private double findAngle(Point p1, Point p2) {
        double slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        return Math.atan(slope);
    }
    
    private <T> List<T> setToList(Set<T> set) {
        List<T> ans = new ArrayList<>();
        for(T i : set) ans.add(i);
        return ans;
    }
    
    private List<Point> sortPointsByAngle(List<Point> points, Point p) {
        if(!points.contains(p)) throw new InvalidParameterException();
        Map<Double, Point> anglePerPoint = new HashMap<>();
        for(Point i : points) anglePerPoint.put(findAngle(p, i), i);
        List<Double> angles = setToList(anglePerPoint.keySet());
        Sorts.mergeSort(angles);
        List<Point> ans = new ArrayList<>();
        for(double i : angles) ans.add(anglePerPoint.get(i));
        return ans;
    }
    
    public List<Equation> findCollinearEquations(List<Point> points) {
        int counter = 0;
        for(Point i : points.subList(0, points.size() - 1)) {
            counter++;
            sortPointsByAngle(points.subList(counter, points.size()), i);
        }
        return null;
    }
    
}
