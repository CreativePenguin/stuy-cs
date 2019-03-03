package hw;

public class Hw9 {

    public static int[] merge(int[] a, int[] b) {
        final int N1 = a.length;
        final int N2 = b.length;
        final int N = N1 + N2;
        int[] ans = new int[N];
        int i = 0, j = 0, k = 0;
        while(k < N) {
            if(i >= N1) { cat(ans, k, b, j); break; }
            if(j >= N2) { cat(ans, k, a, i); break; }
            if(a[i] < b[j]) ans[k++] = a[i++];
            else ans[k++] = b[j++];
        }
        System.out.printf("i:%s, j:%s, k:%s%n", i, j, k);
        return ans;
    }

    private static void cat(int[] ans, int i1, int[] other, int i2) {
        int j = i1;
        for(int i = i2; i < other.length; i++) {
            ans[j++] = other[i];
        }
    }

    public static int log(int n) {
        if(n <= 1) return 0;
        return 1 + log(n / 2);
    }

    //O(N)

    public static void main(String[] args) {
        int[] l1 = {2, 6, 7}; int[] l2 = {1, 3, 8, 9};
        for(int i : merge(l1, l2))
            System.out.print(i + " ");
        System.out.println();
        System.out.println("hi " + log(5));
    }

}
