public class TitusBodeLaw {

    public static double b(double n) {
        int val = 3;

        if(n == 1) return 1;
        for(int i = 2; i < n; i++) {
            val *=  2;
        }
        return val;
    }

    public static double bR(double i) {
        if(i == 1) return 1;
        if(i == 2) return 3;
        return bR(i - 1) * 2;
    }

    public static double d(double i) {
        return (4.0 + b(i)) / 10.0;
    }
    
    public static void main(String[] args) {
        System.out.println(bR(1));
        System.out.println(bR(3));
        System.out.println(bR(6));
    }

}
