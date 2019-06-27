package finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static String readFile(File file, Function<String, String> function) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder ans = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                ans.append(function.apply(line));
            }
            return ans.toString();
        }
    }

    /**
     * Will test function on String user input
     * @param instructions beginning string printed before accepting scanner input
     * @param function function executed on user input
     * @param isInvalidString should return true for conditions where string will error
     */
    public static void readUserInput(String instructions, Function<String, String> function, Predicate<String> isInvalidString) {
        Scanner src = new Scanner(System.in);
        String input;
        while(true) {
            System.out.println(instructions);
            if(!isInvalidString.test(input = src.nextLine())) break;
            System.out.println("Error, invalid input");
        }
        System.out.println(function.apply(input));
    }

    public static void main(String... args) {
    }
}
