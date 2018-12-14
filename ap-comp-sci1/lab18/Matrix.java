public class Matrix {

    private int[][] multMat(int[][] a, int[][] b) {
        int[][] c = new int[a.length][a[0].length];
        int[] ax = new int[2];
        int[] by = new int[2];
        for(int i = 0; i < c.length; i++) {
            for(int j = 0; i < c[0].length; i++) {
                c[i][j] = calcAx(a[i]) + calcBy;
            }
        }
        return c;
    }
            
    private int calcAx(int[] a) {
        int val = 0;
        for(int i : a) {
            val += a;
        }
        return val;
    }

}
