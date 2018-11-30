import java.io.*;

public class CopyFiles {

    private BufferedReader rd;
    private BufferedWriter wr;

    private void precondition(String origFile, String copyFile) {
	try {
	    rd = new BufferedReader(new FileReader(origFile));
	    wr = new BufferedWriter(new FileWriter(copyFile));
	} catch(IOException ex) {
	    throw new RuntimeException("file not found");
	}
    }
    
    private void postCondition(Reader rd, Writer wr) {
	try{
	    rd.close(); wr.close();
	} catch(IOException ex) {
	    throw new RuntimeException("Error closing files");
	}
    }

    private void copyFileLineByLine(String rName, String wName) {
	precondition(rName, wName);
	try {
	    while(rd.readLine() != null) {
		String line = rd.readLine();
		wr.write(rd.readLine());
		wr.newLine();
	    }
	} catch(IOException ex) {
	    throw new RuntimeException("Error writing files");
	}
	postCondition(rd, wr);
    }
}
