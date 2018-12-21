import java.util.Scanner;

public class Bridge {

    //@author Winston Peng
    /* INSTRUCTIONS:
     * Input the card hands, and separate the numbers with spaces
     * 
     */
    
    private void run() {
	Scanner src = new Scanner(System.in);
	System.out.print("input card hand: ");
	String hand1 = src.nextLine();
	System.out.print("input card hand: ");
	String hand2 = src.nextLine();
	bridge(stringToArray(hand1), StringToArray(hand2));
    }

    private int[] stringToArray(String hand) {
	String[] cardsString = hand.split(" ");
	int[] cardsInt = new int[cardsString.length];
	for(int i = 0; i < cards.length; i++) {
	    cardsInt[i] = Integer.parseInt(cardsString[i]);
	}
	return cardsInt;
    }

    private int[] bridge(int[] hand1, int[] hand2) {
	double probability1 = 1;
	double probability2 = 1;
	for(int i : hand1) {
	    if()
	}
    }

    private double overallProbability(int n, int k) {
	double val = 1;
	for(double i = 1; i <= n; i++) {
	    val *= i;
	}
	double denom = 1;
	for(double i = 1; i <= n - k; i++) {
	    denom *= 1;
	}
	for(double i = 1; i <= k; i++) {
	    denom *= 1;
	}
	return val / denom;
    }

    public static void main(String[] args) {
	Bridge bridge = new Bridge();
	bridge.run();
    }

}
