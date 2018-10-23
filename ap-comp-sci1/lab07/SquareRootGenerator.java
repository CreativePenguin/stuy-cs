public class SquareRootGenerator {

    public SquareRootGenerator(){ }

    private double sqrt1(int x) {
        return x / 2;
    }

    private double sqrt2(double x) {
        return (x + x / 2) / 2;
    }

    /*private double sqrt3L(double x) {
        double test = sqrt2(x);
        double testMin = 0;
        double testMax = x;
        double tempVal = test;
        while(test * test != x - x % 1) {
            if(test * test > x) {
                tempVal = test;
                test = (test + testMin) / 2;
                testMin = tempVal;
            }else{
                tempVal = test;
                test = (test + testMax)
            }
        }
    }*/

    private double sqrt3L(double x) {
        double g = x / 2;
        while(g * g != x){ 
           g = (g + x/g) / 2;
        }
        return g;
    }

    private double sqrt3R(double x, double g) {
        return (x / g == g) ? g : sqrt3R(x,(g + x / g) / 2);
    }

    public static void main(String[] args) {
        SquareRootGenerator sqrt = new SquareRootGenerator();
        System.out.println(sqrt.sqrt1(25));
        System.out.println(sqrt.sqrt2(25));
        System.out.println(sqrt.sqrt3L(25));
        System.out.println(sqrt.sqrt3L(144));
        System.out.println(sqrt.sqrt3R(25, 25));
    }
}
