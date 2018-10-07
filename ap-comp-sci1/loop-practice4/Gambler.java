public class Gambler {
    public static void main(String[] args) {
	final int stake = Integer.parseInt(args[0]);
	final int goal = Integer.parseInt(args[1]);
	final int trials = Integer.parseInt(args[2]);
	int winAmount = 0;
	int betCounter = 0;

	for(int i = 0; i <= trials; i++) {
	    int money = stake;
	    while(money < goal && money > 0) {
		double rand = Math.random();
      		money = (rand < .5) ? money + 1 : money - 1;
		betCounter++;
	    }
	    winAmount = (money == goal) ? winAmount + 1: winAmount;
	}
	System.out.println(winAmount * 100.0 / trials + "% wins");
	System.out.println("Avg # bets: " + betCounter / trials);
    }
}
