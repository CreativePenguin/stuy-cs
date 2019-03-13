package hw;

import hw.platek.Stats;

import java.util.*;

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
        return max(counters);
    }

    public void mergeSort(List<Number> data) {
        mergeSort(data, 0, data.size());
    }

    public void mergeSort(List<Number> data, int idxA, int idxI) {
        int mid = (idxA + idxI) / 2;
        mergeSort(data, idxA, mid);
        mergeSort(data, mid + 1, idxI);
        mergeSort(data, idxA, mid, idxI);
    }

    public void mergeSort(List<Number> data, int idxA, int mid, int idxI) {
        int a = idxA; int b = 0; int c = 0;
        List<Number> beginArray = new ArrayList<>(data.subList(idxA, mid));
        List<Number> endArray = new ArrayList<>(data.subList(mid, idxI));
        while(a < idxI) {
            if(b == beginArray.size() - 1) ;
            if(c == endArray.size() - 1) data.addAll(a, endArray.su)
            int i1 = beginArray.get(b).intValue();
            int i2 = endArray.get(c).intValue();
            data.set(i1, Math.max(i1, i2));
            if(i1 < i2) b++; else c++;
        }
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
