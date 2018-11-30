import java.io.*;
import java.util.Scanner;

public class Exam {

    // Jarair Tahsin and Winston Peng
    
    //Question 1: Trig Table

    
    private void runTrigTable() {
        System.out.println("Running Trig Table");
        System.out.println("theta   | sin(theta) | cos(theta) |");
        System.out.println("--------+------------+------------+");
        System.out.printf("   %d  | %.7f | %.7f  |",-90,Math.sin(Math.toRadians(-90)), Math.cos(Math.toRadians(-90)));
        for (int i = -75; i<=90; i+=15){
            if (i<=-15){
                System.out.printf("\n" + "   %d  | %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
            }
            if (i==0){
                System.out.printf("\n" + "     %d  |  %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
            }
            if (i>0 && i<=90){
                System.out.printf("\n" + "    %d  |  %.7f | %.7f  |",i,Math.sin(Math.toRadians(i)), Math.cos(Math.toRadians(i)));
            }
        }
    }

    
    //Question 2: Remove Comments

    
    boolean isComment = false;

    
    private void runRemoveComments() {
	try {
            System.out.println();
            System.out.println("Running Remove Comments");
	    Scanner src = new Scanner(System.in);
	    System.out.print("Input Read File: ");
	    String readFilename = src.nextLine();
	    Reader rd = new FileReader(readFilename);
	    System.out.print("Input Write File: ");
	    String writeFilename = src.nextLine();
	    Writer wr = new FileWriter(writeFilename);
	    removeCommentsMain(rd, wr);
	    wr.close(); rd.close();
	} catch(IOException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    private void removeCommentsMain(Reader rd, Writer wr) {
	try {
	    BufferedReader br = new BufferedReader(rd);
	    BufferedWriter bw = new BufferedWriter(wr);

	    while(true) {
		String line = br.readLine();
		if (line == null) break;
		bw.write(removeComments(line));
		bw.newLine();
	    }
	    br.close(); bw.close();
	}
	catch(IOException ex) {
	    throw new RuntimeException(ex.toString());
	}
    }

    private String removeComments(String line) {
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

    
    //Question 3: Censor

    
    public void runCensor(){
        System.out.println("Running Censor");
        BufferedReader inputfile = openfile(new Scanner(System.in), "Enter the name of input file:");
        PrintWriter writer = createwriter(new Scanner(System.in), "Enter the name of an output file that's different from the input file:");
        System.out.println("Enter the words in the input file that you want to censor");
        Scanner theSystem = new Scanner (System.in);
        String censored = theSystem.nextLine();
        String censoredwithoutwhitespace = "";
        for (int i = 0; i<censored.length(); ++i){ //this for statement makes sure the program can still work even if the letters in the censored string are seperated by whiespace or commas.
            if (Character.isLetter(censored.charAt(i)) == true) censoredwithoutwhitespace += censored.charAt(i);
        }
        censor(inputfile, writer, censoredwithoutwhitespace);
        System.out.println("Success! Check the output file to see the censored text from the input file");
    }
    private void censor(BufferedReader inputfile, PrintWriter writer, String censoredwithoutwhitespace){
        try{
            String ans = "";
            while (true){
                int ch = inputfile.read();
                char character = (char)ch;
                if (ch == -1) break;
                if (Character.isLetter(character)){
                    String theUpperCase = Character.toUpperCase(character) + "";
                    String theLowerCase = Character.toLowerCase(character) + "";
                    if ((censoredwithoutwhitespace.indexOf(theUpperCase)!=-1)||(censoredwithoutwhitespace.indexOf(theLowerCase)!=-1)) ans += "";
                    else ans += character + "";
                }
                else ans += character + "";
            }
            writer.print(ans);
            writer.close();
        }catch(IOException exception){
            throw new RuntimeException(exception.toString());
        }
    }   
    private BufferedReader openfile(Scanner sys, String enterstatement){
        BufferedReader file = null;
        while (file == null){
            try {
                System.out.print (enterstatement);
                String filename = sys.nextLine();
                file = new BufferedReader(new FileReader(filename));
            }catch(IOException exception){
                System.out.println("Invalid File. Enter the name of an existing input file.");
            }
        }
        return file;
    }
    private PrintWriter createwriter(Scanner sys, String enterstatement){
        BufferedReader outputfile = null;               
        String outputfilename = "";
        while (outputfile == null){ 
            try{
                System.out.print(enterstatement);
                outputfilename = sys.nextLine();
                outputfile = new BufferedReader(new FileReader(outputfilename));
            }catch(IOException exception){
                System.out.println("Invalid File. Enter the name of an existing output file.");
            } 
        }
        PrintWriter writer = null;
        while (writer == null){         
            try{
                writer = new PrintWriter(new FileWriter(outputfilename));
            }catch(IOException e){
                throw new RuntimeException(e.toString());
            }}
        return writer;
    }  

    
    //Question 4: Tabify

    
    private void runTabify() {
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
	    throw new RuntimeException(ex.toString());
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
            throw new RuntimeException(ex.toString());
        }
    }

    private String tabify(String line) {
	String val = "";
	int len = line.length();
	for(int i = 0; i < len; i++) {
	    String test = line.substring(i, i + 1);
	    if(test.equals("\t")) {
                System.out.println("i = " + i);
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
	Exam exam = new Exam();
        exam.runTrigTable();
        exam.runRemoveComments();
        exam.runCensor();
        exam.runTabify();
    }
}
