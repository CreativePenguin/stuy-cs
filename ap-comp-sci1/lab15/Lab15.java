import java.util.Scanner;

public class Lab15 {
    
    private Scanner scan;
    private String alphabetU;
    private String alphabetL;

    public Lab15() {
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

    public String letterSubCipher(String base, String key) {
	String val = "";
	for(int i = 0; i < base.length(); i++) {
	    String tempbase = base.substring(i, i + 1);
	    int index = alphabetU.indexOf(tempbase.toUpperCase());
	    val += isUppercase(tempbase) ? key.substring(index, index + 1).toUpperCase() :
		isLowercase(tempbase) ? key.substring(index, index + 1).toLowerCase() :
		tempbase;
	}
	return val;
    }

    public String invertKey(String base, String key) {
	String val = "";
	for(int i = 0; i < base.length(); i++) {
	    String tempbase = base.substring(i, i + 1);
	    int index = key.toUpperCase().indexOf(tempbase.toUpperCase());
	    val += isUppercase(tempbase) ? alphabetU.substring(index, index + 1) :
		isLowercase(tempbase) ? alphabetL.substring(index, index + 1) :
		tempbase;
	}
	return val;
    }

    public int findDNAMatch(String s1, String s2, int start) {
	String s2u = s2.toUpperCase();
	int lens2 = s2.length();
	for(int i = start; i < s1.length() - lens2; i++) {
	    if(s1.substring(i, i + lens2).toUpperCase().equals(s2u))
		return i;
	}
	return -1;
    }

    public int findDNAMatch(String s1, String s2) {
	return findDNAMatch(s1, s2, 0);
    }

    private String DNAMatch(String s1) {
	String val = "";
	for(int i = 0; i < s1.length(); i++) {
	    String s = s1.substring(i, i + 1);
	    if(s.toUpperCase().equals("A")) val += "T";
	    if(s.toUpperCase().equals("T")) val += "A";
	    if(s.toUpperCase().equals("C")) val += "G";
	    if(s.toUpperCase().equals("G")) val += "C";
	}
	return val;
    }

    public void runCeasarCipher() {
	System.out.print("Enter the number of character positions to shift: ");
	int shift = scan.nextInt();
	scan.nextLine();
	System.out.print("Enter a message: ");
	String str = scan.nextLine();
	System.out.println("Encoded message: " +
			encodeCeasarCipher(str, shift));
    }

    public void runLetterSubCipher() {
	System.out.print("Enter a 26- letter key: ");
	String key = scan.nextLine();
	System.out.print("Enter a message: ");
	String base = scan.nextLine();
	System.out.println("Encoded message: " +
			   letterSubCipher(base, key));
    }

    public void runInvertKey() {
	System.out.print("Enter a 26- letter key: ");
	String key = scan.nextLine();
	System.out.print("Enter an encoded message: ");
	String base = scan.nextLine();
	System.out.println("Decoded message: " +
			   invertKey(base, key));
    }

    public static void main(String[] args) {
	Lab15 lab = new Lab15();
//	lab.runCeasarCipher();
//	lab.runLetterSubCipher();
//	lab.runInvertKey();
	lab.findDNAMatch("TAACGGTACGTC", "TTCGC");
    }
}
