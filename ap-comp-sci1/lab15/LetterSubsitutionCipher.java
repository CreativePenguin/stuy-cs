public class LetterSubsitutionCipher {
    
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
}
