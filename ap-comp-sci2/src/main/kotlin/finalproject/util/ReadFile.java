package finalproject.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

public class ReadFile {
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
}
