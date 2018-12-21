import java.util.Scanner;
//import java.util.List;
//import java.util.ArrayList;

/**
 * @author Winston Peng and Kevin Cai
 * For this code, the user will need to input 3 different floats
 * The program will then use the same function to calc the sum of 2
 * numbers and the sum of 3 numbers
 */

public class MultiParamSum {

    
    private static double sum(double... addends) {
        double val = 0;
        for(double i : addends) {
            val += i;
        }
        return val;
    }

    /*
    private static void run() {
        Scanner src = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        while(true) {
            try {
                System.out.print("Enter a number or type \"exit\": ");
                String input = src.nextLine();
                if(input.equals("exit")) break;
                list.add(Double.parseDouble(input));
            } catch(NumberFormatException ex) {
                System.out.println("Not a vaild input");
            }
        }
    }
    */

    private static void run() {
        Scanner src = new Scanner(System.in);
        try {
            System.out.print("1. Input an float: ");
            double input1 = src.nextDouble(); src.nextLine();
            System.out.print("2. Input an float: ");
            double input2 = src.nextDouble(); src.nextLine();
            System.out.print("3. Input an float: ");
            double input3 = src.nextDouble(); src.nextLine();
            System.out.println("Sum of the first two inputs: " + sum(input1, input2));
            System.out.println("Sum of all three inputs: " + sum(input1, input2, input3));
        } catch(NumberFormatException ex) {
            System.out.println("Not a valid input");
            run();
        }
    }

    public static void main(String[] args) {
        run();
    }
}
