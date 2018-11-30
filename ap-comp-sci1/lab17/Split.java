public class Split {

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

}
