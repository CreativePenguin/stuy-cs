package hw.exam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCode {

    private static MorseCode instance;
    private String[] morseAToZ;
    private String[] englishAToZ;
    private Map<String, String> morseToEnglish;
    private Map<String, String> englishToMorse;

    private MorseCode() {
        morseAToZ = ".- -... -.-. -.. . ..-. --. .... .. .--- -.- .-.. -- -. --- .--. --.- .-. ... - ..- ...- .-- -..- -.-- --..".split(" ");
        englishAToZ = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        morseToEnglish = listsToMap(morseAToZ, englishAToZ);
        englishToMorse = listsToMap(englishAToZ, morseAToZ);
    }

    public static MorseCode getInstance() {
        if(instance == null) {
            instance = new MorseCode();
        }
        return instance;
    }

    private <K, V> Map<K, V> listsToMap(K[] keys, V[] values) {
        if(keys.length != values.length) throw new IllegalArgumentException("Lists must be the same size");
        Map<K, V> ans = new HashMap<>();
        for(int i = 0; i < keys.length; i++) {
            ans.put(keys[i], values[i]);
        }
        return ans;
    }
    
    public String readFile(File file) throws FileNotFoundException, IOException {
        String ans = "";
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while((line = reader.readLine()) != null) {
                ans += readLine(line);
            }
        }
        return ans;
    }
    
    public String readLine(String input) {
        boolean isMorse = input.substring(0, 1).equals(".") || input.substring(0, 1).equals("-");
        String[] splitInput = (isMorse) ? input.split(" ") : input.split("");
        String ans = "";
        for(int i = 0; i < splitInput.length; i++) {
            String tmp = (isMorse) ? morseToEnglish.get(splitInput[i]) : englishToMorse.get(splitInput[i].toUpperCase());
            ans += tmp == null ? splitInput[i] : tmp;
        }
        return ans;
    }

    public void run() {
        System.out.println("Morse Code Translator");
        try (Scanner src = new Scanner(System.in)) {
            while(true) {
                System.out.print(">");
                String input = src.nextLine();
                System.out.println(readLine(input));
            }
        }
    }
    
    public static void main(String[] args) {
        MorseCode.getInstance().run();
    }

}
