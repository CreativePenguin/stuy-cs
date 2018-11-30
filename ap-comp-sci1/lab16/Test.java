public class Test {

    public static void main(String[] args) {
	System.out.print("" == null);
    }
    
    private void formatOutput(int letter, int word, int line) {
	String letterSpaces = "  ";
	String wordSpaces = "   ";
	String lineSpaces = "  ";
	int lenLetter = Integer.toString(letter).length();
	int lenWord = Integer.toString(word).length();
	int lenLine = Integer.toString(line).length();
	for(int i = 0; i <= lenLetter - lenWord; i++) wordSpaces += " ";
	for(int i = 0; i <= lenLetter - lenLine; i++) lineSpaces += " ";
	System.out.println(letterSpaces + letter);
	System.out.println(wordSpaces + letter);
	System.out.println(lineSpaces + letter);
    }
}
