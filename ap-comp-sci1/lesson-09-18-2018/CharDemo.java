public class CharDemo {

    public static void main(String[] args) {
	int stop = Integer.parseInt(args[0]);
	for (int i = 0; i < stop; i++) {
	    char c = (char) i;
	    System.out.println(i + " : " + c);
	}
    }

}
