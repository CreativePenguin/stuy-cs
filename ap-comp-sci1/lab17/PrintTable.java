public class PrintTable {

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
