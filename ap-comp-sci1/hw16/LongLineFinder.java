import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

public class LongLineFinder {

    private void run() {
        Scanner src = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = src.nextLine();
    }

    private BufferedReader file(String filename) {
        try {
            BufferedReader val;
            val = new BufferedReader(new FileReader(filename));
        }
    }
}
