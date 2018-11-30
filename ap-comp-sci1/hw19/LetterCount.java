import java.io.*;

public class LetterCount {

    final String alph = "abcdefghijklmnopqrstuvwxyz";
    
    private int[] LetterCountMain(Reader rd) {
        try {
            BufferedReader br = new BufferedReader(rd);

            int[] val = new int[alph];

            String line = br.readLine();
            for(int i = 0; i < line.length(); i++) {
                for(int j = 0; j < alph.length(); j++) {
                    if(alph.substring(j, j + 1).
                       equals(line.substring(i, i + 1))) {
                           val[j] ++;
                       }
                }
            }
        }
        catch(IOException ex) {
            throw new RuntimeException(ex.toString());
        }
    }

}
