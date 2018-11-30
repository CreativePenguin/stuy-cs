public class ConcatFiles {
    
    private BufferedWriter wr;
    private BufferedReader rd1;
    private BufferedReader rd2;
    
    private void precondition(String r1, String r2, String w) {
	try {
	    rd1 = new BufferedReader(new FileReader(r1));
	    rd2 = new BufferedReader(new FileReader(r2));
	    wr = new BufferedWriter(new FileWriter(w));
	} catch(IOException ex) {
	    throw new RuntimeException("file not found");
	}
    }
    private void postcondition(Reader rd1, Reader rd2, Writer wr) {
	try {
	    rd1.close(); rd2.close(); wr.close();
	} catch(IOException ex) {
	    throw new RuntimeException("Error closing files");
	}
    }

    private void concatFiles(String r1, String r2, String w) {
	precondition(r1, r2, w);
	copyFile(r1, w);
	copyFile(r1, w);
	postcondition(rd1, rd2, wr);
    }
}
