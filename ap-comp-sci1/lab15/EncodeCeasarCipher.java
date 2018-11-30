import java.util.Scanner;

public class EncodeCeasarCipher {

    private Scanner scan;
    private String alphabetU;
    private String alphabetL;

    public EncodeCeasarCipher() {
	scan = new Scanner(System.in);
	alphabetU = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	alphabetL = "abcdefghijklmnopqrstuvwxyz";
    }

    public boolean isUppercase(String input) {
	if(input.length() == 1) return alphabetU.contains(input);
	else return false;
    }

    public boolean isLowercase(String input) {
	if(input.length() == 1) return alphabetL.contains(input);
	else return false;
    }
    
    public String encodeCeasarCipher(String str, int shift) {
	String val = "";
	for(int i = 0; i < str.length(); i++) {
	String temp = str.substring(i, i + 1);
	    if(isUppercase(temp)) {
		int index = (alphabetU.indexOf(temp) + shift) % 26;
		val += alphabetU.substring(index, index + 1);
	    } else if (isLowercase(temp)){
		int index = (alphabetL.indexOf(temp) + shift) % 26;
		val += alphabetL.substring(index, index + 1);
	    } else {
		val += temp;
	    }
	}
	return val;
    }

    public static void runCeasarCipher() {
	Lab15 lab = new Lab15();
	System.out.print("Enter the number of character positions to shift: ");
	int shift = lab.scan.nextInt();
	lab.scan.nextLine();
	System.out.print("Enter a message: ");
	String str = lab.scan.nextLine();
	System.out.println("Encoded message: " +
			   lab.encodeCeasarCipher(str, shift));
    }

    public String letterSubCipher(String key, String base) {
	String val = "";
	for(int i = 0; i < base.length(); i++) {
	    String letter = key.substring(i, i + 1);
	    int baseIndex = isUppercase ? alphabetU.indexOf(letter) :
		isLowercase ? alphabetL.indexOf(letter) : letter;
}
