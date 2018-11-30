import java.io.*;
import java.util.Scanner;

public class Lab17 {

    private BufferedReader rFile(String filename) {
	try {
	    return new BufferedReader(new FileReader(filename));
	} catch(IOException ex) {
	    throw new RuntimeException("Error reading file");
	}
    }

    private void split() {
	try {
	    BufferedReader rd = rFile("codes.csv");
	    while(true) {
		String line = rd.readLine();
		if(line == null) break;
		Scanner src = new Scanner(line);
		src.useDelimiter(",");
		while(true) {
		    String field = src.next();
		    if(field == null) break;
		    BufferedWriter wr = new BufferedWriter(new FileWriter(field));
		}
	    }
	} catch(IOException ex) {
	    throw new RuntimeExcpetion(ex.toString());
	}
    }

    private void printTable() {
	System.out.printf("%-20s|%-6s|5d%", "state","abrev", "code");
	try {
	    BufferedReader rd = rFile("codes.csv");
	    while(true) {
		String line = rd.readLine();
		if(line == null) break;
		Scanner src = new Scanner(line);
		src.useDelimiter(",");
		String state = src.next();
		String abrev = src.next();
		int code = src.nextInt();
		System.out.printf("%-20s|%-6s|5d%", state, abrev, code);
	    }
	} catch(IOException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

}
