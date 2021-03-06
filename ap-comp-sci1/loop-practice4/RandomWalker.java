public class RandomWalker {

    public static void main(String[] args) {
	int input = Integer.parseInt(args[0]);
	int boxSideVal = (2 * input) + 1;
	int counter = 0; int y = 0; int x = 0;

	System.out.println("Box Length: " + boxSideVal);

	while(Math.abs(x) < boxSideVal && Math.abs(y) < boxSideVal) {
	    double rand = Math.random();

	    boolean north = rand <= .25; boolean south = .25 < rand && rand <= .5;
	    boolean west = .5 < rand && rand <= .75; boolean east = .75 < rand;

	    if(north) y++; if(south) y--;
	    if(east) x++; if(west) x--;

	    counter++;
	    System.out.println("Pos: (" + x + ", " + y + ")" + "\t" + rand);
	}
	System.out.println("Steps: " + counter);
    }

}
