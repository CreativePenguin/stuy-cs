public class ProbabilityBoard {

    private double[] probabilityBoard(int spaces, int trials) {
	double[] val = new double[trials];
	for(int i = 0; i < trials; i++) {
	    val[i] = spaces / 2;
	    for(int j = 0; j <= spaces; j++) {
		if(Math.random() > 0.5) val[i] += 0.5;
		else val[i] -= 0.5;
	    }
	}
        return val;
    }

    private void runProbabilityBoard() {
        double[] val = probabilityBoard(10, 50);
        double[] table = new double[10];
        for(double i : val) {
            table[(int)i]++;
        }
        System.out.println("Channel        Marbles");
        System.out.println("------------------------");
        for(int i = 0; i < 10; i++) {
            System.out.print(i + "               ");
            for(int j = 0; j < table[i]; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}
