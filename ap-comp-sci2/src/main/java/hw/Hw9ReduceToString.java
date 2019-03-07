package hw;

import hw.platek.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.max;

public final class Hw9ReduceToString extends Stats {

    private boolean isEven(int n) { return n % 2 == 0; }

    private double avg(int... n1) {
        return sum(n1) / (n1.length + 0.0);
    }

    private int sum(int[] n) {
        if(n.length == 1) return n[0];
        return n[n.length - 1] + sum(Arrays.copyOf(n,n.length - 2));
    }
        
    @Override
    public double median(int[] data) {
        return median(super.toList(data));
    }

    @Override
    public double median(List<Integer> data) {
        List<Integer> sortedList = mergeSort(data);
        return isEven(sortedList.size()) ?
                sortedList.get(sortedList.size() / 2) :
                avg(sortedList.get(sortedList.size() / 2),
                    sortedList.get(sortedList.size() / 2 + 1));
    }

    @Override
    public int mode(int[] data) {
        return mode(super.toList(data));
    }

    @Override
    public int mode(List<Integer> data) {
        List<Integer> li = mergeSort(data);
        List<Integer> counters = new ArrayList<>();
        int i = 0;
        int prev = li.get(0);
        for(int j : li) {
            if(j > prev) i++;
            counters.set(i, j);
        }
        return max(counters);
    }

    public <E> ArrayList<E> mergeSort(List<E> data) {
        return new ArrayList<>();
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        Hw9ReduceToString hw = new Hw9ReduceToString();
        hw.run();
    }
    
}
