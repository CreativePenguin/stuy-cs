package hw;

import hw.platek.Stats;

public final class Hw9ReduceToString extends Stats {

    private boolean isEven(int n) { return n % 2 == 0; }

    private double avg(int... n1) {
        return sum(n1) / (n1.length + 0.0);
    }

    private int sum(int[] n) {
        if(n.length == 1) return n[0];
        return n[0] + sum(n[1:]);
    }
        
    @Override
    public double median(int[] data) {
        return isEven(data.length) ?
            mergeSort(data[data.length / 2]) :
            mergeSort(avg(data[data.length / 2]),
                      data[data.length / 2 + 1]);
    }

    @Override
    public double median(List<Integer> data) {
        return median(data.toArray());
    }

    @Override
    public int mode(int[] data) {
        
    }

    @Override
    public int mode(List<Integer> data) {
        return mode(data.toArray());
    }

    public static void main(String[] args) {
        Stats stat = new Stats();
        stat.run();
    }
    
}
