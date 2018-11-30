import java.io.*;

public class Classwork {

    private BufferedReader rd;
    private BufferedWriter wr;
    private BufferedReader rd1;
    private BufferedReader rd2;

    private void precondition(String origFile, String copyFile) {
	try {
	    rd = new BufferedReader(new FileReader(origFile));
	    wr = new BufferedWriter(new FileWriter(copyFile));
	} catch(IOException ex) {
	    throw new RuntimeException("file not found");
	}
    }

    private void precondition(String r1, String r2, String w) {
	try {
	    rd1 = new BufferedReader(new FileReader(r1));
	    rd2 = new BufferedReader(new FileReader(r2));
	    wr = new BufferedWriter(new FileWriter(w));
	} catch(IOException ex) {
	    throw new RuntimeException("file not found");
	}
    }
    
    private void postcondition(Reader rd, Writer wr) {
	try{
	    rd.close(); wr.close();
	} catch(IOException ex) {
	    throw new RuntimeException("Error closing files");
	}
    }

    private void copyFile(BufferedReader rd, BufferedWriter wr) {
	try {
	    while(rd.readLine() != null) {
		wr.write(rd.readLine());
		wr.newLine();
	    }
	} catch(IOException ex) {
	    throw new RuntimeException("Error writing files");
	}
    }

    private void postcondition(Reader rd1, Reader rd2, Writer wr) {
	try {
	    rd1.close(); rd2.close(); wr.close();
	} catch(IOException ex) {
	    throw new RuntimeException("Error closing files");
	}
    }

    private void copyFileLineByLine(String rName, String wName) {
	precondition(rName, wName);
	copyFile(rd, wr);
	postcondition(rd, wr);
    }

    private void concatFiles(String r1, String r2, String w) {
	precondition(r1, r2, w);
	copyFile(r1, w);
	copyFile(r1, w);
	postcondition(rd1, rd2, wr);
    }

    public static void main(String[] args) {
	Classwork stuypulse = new Classwork();
	stuypulse.copyFileLineByLine("BohemianRhapsody", "copy");
	stuypulse.concatFiles("BohemianRhapsody", "Cars", "copy");
	System.out.println("run terminated");
    }
}
