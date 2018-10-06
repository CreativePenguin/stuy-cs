public class Kary{

    //Hi, sorry I couldn't figure out how to do it using longs

    private static String hexadigit(int n) {
	if(n <= 9) {
	    return Integer.toString(n);
	} else {
	    switch(n) {
	    case 10: return "A";
	    case 11: return "B";
	    case 12: return "C";
	    case 13: return "D";
	    case 14: return "E";
	    case 15: return "F";
	    case 16: return "G";
	    default: return "I bet you didn't expect the Spanish Inquisition";
	    }
	}
    }
    
    public static void main(String[] args){
	int n = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);

	String val = "";

	while(n > 0) {
	    val = hexadigit(n % b)  + val;
	    n /= b;
	}

	System.out.println(val);
    }
}
