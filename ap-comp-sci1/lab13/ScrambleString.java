public class ScrambleString {

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

}
