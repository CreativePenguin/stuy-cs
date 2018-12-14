import java.util.Scanner;

public class Bridge {

    //@author Winston Peng
    /* INSTRUCTIONS:

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
	String[] cardsString = hand.split(",");
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
	    probability1 * (1 / 13);
	}
    }

}
