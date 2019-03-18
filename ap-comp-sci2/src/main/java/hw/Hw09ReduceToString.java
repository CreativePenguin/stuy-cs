package hw;

import hw.platek.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Collections;

public final class Hw09ReduceToString extends Stats {

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
        Collections.sort(data);
        return isEven(data.size()) ?
                data.get(data.size() / 2) :
                avg(data.get(data.size() / 2),
                    data.get(data.size() / 2 + 1));
    }

    @Override
    public int mode(int[] data) {
        return mode(super.toList(data));
    }

    @Override
    public int mode(List<Integer> data) {
        Collections.sort(data);
        List<Integer> counters = new ArrayList<>();
        int i = 0;
        int prev = data.get(0);
        for(int j : data) {
            if(j > prev) i++;
            counters.set(i, j);
        }
        return Collections.max(counters);
    }

    public void mergeSort(List<Number> data) {
        mergeSort(data, 0, data.size());
    }

    public void mergeSort(List<Number> data, int l, int h) {
        int m = (l + h) / 2;
        mergeSort(data, l, m);
        mergeSort(data, m + 1, l);
        mergeSort(data, l, m, h);
    }

    public void mergeSort(List<Number> data, int l, int m, int h) {
        int i = 0; int j = 0; int k = 0;
        List<Number> a = new ArrayList<>(data.subList(l, m));
        List<Number> b = new ArrayList<>(data.subList(m + 1, h));
        while(k < h && i < a.size() && j < b.size()) {
            data.set(k++, a.get(i).doubleValue() > b.get(j).doubleValue() ? a.get(i++) : b.get(i++));
        }
        while(k < h) {
            data.set(k++, i > j ? a.get(j++) : b.get(i++));
        }
    }

    @Override
    public void run() {
        super.run();
    }

    public static void main(String[] args) {
        Hw09ReduceToString hw = new Hw09ReduceToString();
        hw.run();
    }
    
}
