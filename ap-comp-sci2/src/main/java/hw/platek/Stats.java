package hw.platek;

import java.util.List;
import java.util.ArrayList;

public abstract class Stats {
    // pre: n > 0, lo <= hi
    // post: returns a n element array of random integers
    //       each element is within [lo,hi).
    public int [] randomArray(int n, int lo, int hi) {
        int [] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = lo + (int)(Math.random() * (hi - lo));
        return ans;
        
    }
    // post: prints an array
    public void print(int[] data) {
                for (int x : data)
                System.out.print(x + " ");
                System.out.println();
    }
    // O(NlogN)
    public abstract double median(int[] data);
     // O(NlogN)
    public abstract double median(List<Integer> data);

    //O(NlogN)
    public abstract int mode(int[] data);

    
    //O(NlogN)
    public abstract int mode(List<Integer> data);
    // pre: data != null
    // post: returns a list whose elements are chosen from data
    public List<Integer> toList(int [] data){
        List<Integer> ans = new ArrayList<Integer>();
        for (Integer x : data) ans.add(x);
        return ans;
    }
    
    public void run() {
        int [] data = randomArray(10,1,10);
        List<Integer> dataList = toList(data);

        // array version
        System.out.println("testing with arrays");
        print(data);
        System.out.println("median: " + median(data));
        System.out.println("mode: "  + mode(data));
        print(data);

        // list version
        System.out.println("testing with lists");
        System.out.println(dataList);
        System.out.println("median: " + median(dataList));
        System.out.println("mode: "  + mode(data));
        System.out.println(dataList);
    }
}
