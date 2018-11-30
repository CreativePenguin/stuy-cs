public class Lab14 {

    public String obenglobish(String input) {
	String val = "";
	String prev = "";
	String now = "";
	if(input.isEmpty()) return input;
	for(int i = 0; i < input.length() - 1; i++) {
	    now = input.substring(i, i + 1);
	    if(isVowel(now) && isVowel(prev)) val += now;
	    else if(isVowel(now)) val += "ob" + now;
	    else val += now;
	    prev = now;
	}
	return val + input.substring(input.length() - 1, input.length());
    }

    public boolean isVowel(String input) {
	String vowels = "AEIOUaeiou";
	for(int i = 0; i < vowels.length(); i++) {
	    if(input.equals(vowels.substring(i, i + 1))) return true;
	}
	return false;
    }

    public static void main(String[] args) {
	Lab14 lab = new Lab14();

	System.out.println(lab.obenglobish(""));
	System.out.println(lab.obenglobish("english"));
	System.out.println(lab.obenglobish("hobnob"));
	System.out.println(lab.obenglobish("gooiest"));
	System.out.println(lab.obenglobish("amaze"));
	System.out.println(lab.obenglobish("rot"));

	System.out.println();

	System.out.println(lab.isVowel("a"));
	System.out.println(lab.isVowel("i"));
	System.out.println(lab.isVowel("A"));
	System.out.println(lab.isVowel("j"));
    }
}
