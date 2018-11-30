import java.io.*;
import java.util.Scanner;

public class RemoveComments {

    /**
       @author Winston Peng
    */

    boolean isComment = false;
    
    private void runRemoveComments() {
	try {
	    Scanner src = new Scanner(System.in);
	    System.out.print("Input Read File: ");
	    String readFilename = src.nextLine();
	    Reader rd = new FileReader(readFilename);
	    System.out.print("Input Write File: ");
	    String writeFilename = src.nextLine();
	    Writer wr = new FileWriter(writeFilename);
	    removeComments(rd, wr);
	    wr.close(); rd.close();
	} catch(IOException ex) {
            System.out.println(ex.toString());
	    runRemoveComments();
	}
    }

    private void removeComments(Reader rd, Writer wr) {
	try {
	    BufferedReader br = new BufferedReader(rd);
	    BufferedWriter bw = new BufferedWriter(wr);

	    while(true) {
		String line = br.readLine();
		if (line == null) break;
		bw.write(commentRemoverMain(line));
		bw.newLine();
	    }
	    br.close(); bw.close();
	}
	catch(IOException ex) {
	    System.out.println(ex.toString());
            runRemoveComments();
        }
    }

    private String commentRemoverMain(String line) {
	String val = "";
	int len = line.length();
	int i = 0;
	for(i = 0; i < len - 1; i++) {
	    String test = line.substring(i, i + 2);
	    if(test.equals("//")) return val;
	    if(test.equals("/*")) isComment = true;
	    if(!isComment) val += test.substring(0,1);
	    if(isComment && test.equals("*/")) {
		i ++;
		isComment = false;
	    }
	}
	return (isComment || i == len) ? val : val + line.substring(len - 1);
    }

    public static void main(String[] args) {
	RemoveComments e = new RemoveComments();
	e.runRemoveComments();
    }
}
