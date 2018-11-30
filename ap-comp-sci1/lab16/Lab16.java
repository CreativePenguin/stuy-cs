import java.io.*;
public class Lab16 {

    private BufferedReader rFile(String filename) {
	try {
	    return new BufferedReader(new FileReader(filename));
	} catch(IOException ex) {
	    throw new RuntimeException("File " + filename + " not found");
	}
    }

    private void countWords(String filename) {
	int lineCounter = 0;
	int letterCounter = 0;
	int wordCounter = 0;
	try {
	    BufferedReader rd = rFile(filename);
	    String line = "a";
	    while(true) {
		line = rd.readLine();
		if(line == null) break;
		lineCounter ++;
		letterCounter += line.length();
		wordCounter += count(line, " ");
		System.out.println(line);
	    }
	    wordCounter += lineCounter;
	    letterCounter += lineCounter;
	} catch(IOException ex) {
	    throw new RuntimeException("error reading files");
	}
	System.out.printf("Chars:%5d%n", letterCounter);
	System.out.printf("Words:%5d%n", wordCounter);
	System.out.printf("Lines:%5d%n", lineCounter);
    }

    private int count(String input, String sub) {
	int len = sub.length();
	int val = 0;
	for(int i = 0; i < input.length() - len; i++) {
	    if(input.substring(i, i + len).equals(sub))	val ++;
	}
	return val;
    }

    public static void main(String[] args) {
	Lab16 lab = new Lab16();
	lab.countWords("Lear.txt");
    }

}
