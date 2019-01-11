public class Children {

    private final int TRIALS;

    public Children() {
        this(100);
    }

    public Children(int trials) {
        TRIALS = trials;
    }

    private int[] calcChildren() {
        int[] trialsResults = new int(TRIALS);
        for(int i = 0; i < TRIALS; i++) {
            int attempts = 1;
            while(Math.random() < 0.5) attempts++;
            trialsResults[i] = attempts;
        }
        return trialsResults;
    }

    private int mode(int[] list) {
        int[] val = new int(maxVal(list));
        for(int i : list) {
            val[i]++;
        }
        return maxVal(list);
    }

    private int maxVal(int[] list) {
        int maxVal = 0;
        for(int i : list) {
            if(i > maxVal) maxVal = i;
        }
        return maxVal;
    }

}
