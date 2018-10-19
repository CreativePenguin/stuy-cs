//Contains ans 1 - 3

public class FactorialR {
    private int factorial(int a) {
        return (a == 1) ? 1 : 
            (a < 1) ? 0 : 
            factorial(a-1) * a;
    }

    /* Factorial(4) | n = 4
     * println(Factorial(4)) | x = 24
     * main(String[]) | args = []
    */

    // The largest value of n in factorial is 16

    public static void main(String[] args) {
        System.out.println(factorial(1));
        System.out.println(factorial(4));
        System.out.println(factorial(16));
    }
}
