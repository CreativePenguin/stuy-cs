public class Permutations {
    
    public static int permutations(int n, int k) {
        int val = 1;
        for(int i = k - n + 1; i <= k; i++) {
            val *= i;
        }
        return val;
    }

    public static void main(String[] args) {
        System.out.println(permutations(2,52));
        System.out.println(permutations(3,16));
    }
}
