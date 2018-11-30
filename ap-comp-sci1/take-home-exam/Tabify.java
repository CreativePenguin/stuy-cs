import java.io.*;
import java.util.Scanner;

public class Tabify {

    /**
       @author Winston Peng
    */

     private void run() {
	try {
	    Scanner src = new Scanner(System.in);
	    System.out.println("Running Tabify.java");
	    System.out.print("Input Read File: ");
	    String readFilename = src.nextLine();
	    Reader rd = new FileReader(readFilename);
	    System.out.print("Input Write File: ");
	    String writeFilename = src.nextLine();
	    Writer wr = new FileWriter(writeFilename);
	    tabifyMain(rd, wr);
	    wr.close(); rd.close();
	} catch(IOException ex) {
            System.out.println(ex.toString());
	    run();
	}
    }

    private void tabifyMain(Reader rd, Writer wr) {
	try {
	    BufferedReader br = new BufferedReader(rd);
	    BufferedWriter bw = new BufferedWriter(wr);

	    while(true) {
		String line = br.readLine();
		if(line == null) break;
		bw.write(tabify(line));
		bw.newLine();
	    }
	    br.close(); bw.close();
        } catch(IOException ex) {
            System.out.println(ex.toString());
            run();
        }
    }

    private String tabify(String line) {
	String val = "";
	int len = line.length();
	for(int i = 0; i < len; i++) {
	    String test = line.substring(i, i + 1);
	    if(test.equals("\t")) {
                val += addSpaces(calcEndIndex(i));
            } else {
                val += test;
            }
	}
	return val;
    }

    private String addSpaces(int place)  {
        String val = "";
        for(int i = 0; i <= place; i++) val += " ";
        return val;
    }

    private int calcEndIndex(int stringIndex) {
        return 8 - (stringIndex % 8);
    }

    public static void main(String[] args) {
	Tabify tab = new Tabify();
	tab.run();
    }
}
