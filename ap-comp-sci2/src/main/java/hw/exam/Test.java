package hw.exam;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Test {
    
    public static void testVoterBallots() {
        Set<String> voter0 = new HashSet<>(Arrays.asList("Chris", "Jamie"));
        Set<String> voter1 = new HashSet<>(Arrays.asList("Chris", "Sandy"));
        Set<String> voter2 = new HashSet<>(Arrays.asList("Chris", "Sandy", "Pat", "Jamie"));
        Set<String> voter3 = new HashSet<>(Arrays.asList("Pat"));
        Set<String> voter4 = new HashSet<>(Arrays.asList("Sandy", "Jamie"));
        Set<String> voter5 = new HashSet<>(Arrays.asList("Sandy", "Pat", "Jamie"));
        Set<String> voter6 = new HashSet<>(Arrays.asList("Jamie", "Chris"));
        List<Set<String>> list = new LinkedList<>(Arrays.asList(voter0, voter1, voter2, voter3, voter4, voter5, voter6));
        VoterBallots ballots1 = new VoterBallots(list);
        System.out.println(ballots1.candidatesWithMost());
        voter3.add("Chris");
        VoterBallots ballots2 = new VoterBallots(list);
        System.out.println(ballots2.candidatesWithMost());
    }

    public static void testMorseCode() {
        //MorseCode.getInstance().run();
        try {
            System.out.println(MorseCode.getInstance().readFile(new File("Morse.txt")));
        } catch (IOException e) {
            throw new RuntimeException("File Not found");
        }
    }

    public static void main(String[] args) {
        //testVoterBallots();
        testMorseCode();
    }

}
