public class Lab13 {

    private String reverseL(String input) {
        String val = "";
        for(int i = 0; i < input.length(); i++)
            val = input.substring(i, i+1) + val;
        return val;
    }

    private String reverseR(String input) {
        int len = input.length();
        return (len <= 1) ? input : 
            input.substring(len - 1) + reverseR(input.substring(0, len - 1));
    }

    private String scramble(String input) {
	String[] val = new String[input.length() * input.length()];
	int counter = 0;
	for(int i = 0; i < input.length(); i++) {
	    for(String a : scramblesSingleLetter(input, i)) {
		val[counter] = a;
		counter++;
	    }
	}
	double rand = Math.random() * input.length() * input.length();
	return val[(int) rand];
    }
    
    private String[] scramblesSingleLetter(String input, int index) {
        String base = input.substring(0, index)
	    + input.substring(index + 1, input.length());
	String x = input.substring(index, index + 1);
	String[] val = new String[input.length()];
	for(int i = 0; i < input.length(); i++) {
	    val[i] = base.substring(0,i) + x +
		base.substring(i, base.length());
	}
	return val;
    }

    public static void main(String[] args) {
        Lab13 lab = new Lab13();

        System.out.println(lab.reverseL(""));
        System.out.println(lab.reverseL("a"));
        System.out.println(lab.reverseL("clam"));

        System.out.println();

        System.out.println(lab.reverseL(""));
        System.out.println(lab.reverseL("a"));
        System.out.println(lab.reverseR("clam"));

	System.out.println();

	System.out.println(lab.scramble("abc"));
	System.out.println(lab.scramble("abc"));
	System.out.println(lab.scramble("abc"));
    }
}
