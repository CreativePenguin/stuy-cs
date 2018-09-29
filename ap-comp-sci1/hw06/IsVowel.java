public class IsVowel {
    public static void main(String[] args) {
	boolean val = false;
	switch(args[0]) {
	case "a": case "e": case "i": case "o": case "u": case "A": case "E": case "I": case "O": case "U":
	    val = true;
	}
	System.out.println(val);
    }
}
