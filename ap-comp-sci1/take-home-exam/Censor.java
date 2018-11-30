import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Censor{

    /**
     *@author Jarair Tahsin
     */
    
    public static void main(String [] args){
        Censor C = new Censor();
        C.run();
    }
    
    public void run(){
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
            run();
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
            }
        }
        return writer;
    }
    
}
  
