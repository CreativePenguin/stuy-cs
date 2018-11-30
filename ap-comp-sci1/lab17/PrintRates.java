import java.io.*;
import java.util.Scanner;

public class PrintRates {
    public void run(){
	try{
	    BufferedReader rd = new BufferedReader(new FileReader("GraduationRates.csv"));
	    while(true){
		String line = rd.readLine();
		if (line == null) break;
		Scanner scanner = new Scanner(line);
		scanner.useDelimiter(",");
		String state = scanner.next();
		int grads = scanner.nextInt();
		double rate = scanner.nextDouble();
		System.out.printf("%-15s%,12d%10.2f%%%n", state, grads, rate);
	    }
	    rd.close();
	}catch(IOException ex){
       	    throw new RuntimeException(ex.toString());
	}
    }

    public static void main(String[] args) {
	new PrintRates().run();
    }
}
