public class MedianOf5 {

    private static int median(int a, int b, int c, int d, int e) {
	int max = Math.max(Math.max(Math.max(Math.max(a,b),c),d),e);
	int min = Math.min(Math.min(Math.min(Math.min(a,b),c),d),e);
	if (a == max || a == min) a = d;
	if (b == max || b == min) b = d;
	if (c == max || c == min) c = d;
	int med = Math.min(Math.max(a,b),Math.max(b,c));
	if (med == min || med == max) med = d;
	return med;
    }

    public static void main(String[] args) {
	int a = Integer.parseInt(args[0]);
	int b = Integer.parseInt(args[1]);
	int c = Integer.parseInt(args[2]);
	int d = Integer.parseInt(args[3]);
	int e = Integer.parseInt(args[4]);

	

	System.out.println(median(a,b,c,d,e));
    }
    
}
