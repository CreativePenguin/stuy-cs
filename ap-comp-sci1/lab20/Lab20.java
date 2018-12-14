public class Lab20 {

    //Unused, to remove soon
    private boolean[][] createBoard() {
	boolean[][] probabilityBoard = new boolean[10][10];
	for(int i = 0; i < probabilityBoard.length; i++) {
	    for(int j = 0; j < probabilityBoard[0].length; i++) {
		if(Math.random() > 0.5)
		    probabilityBoard[i][j] = true;
	    }
	}
	return probabilityBoard;
    }

    private void probabilityBoard() {
	int[] val = new int[50];
	for(int i = 0; i < 50; i++) {
	    val[i] = 5;
	    for(int j = 0; j <= 10; j++) {
		if(Math.random() > 0.5) val[i] += 1;
		else val[i] -= 1;
	    }
	}
	for(int i = 0; i < val.length; i++) {
	    System.out.println(val[i]);
	}
    }

    public static void main(String[] args) {
	Lab20 lab = new Lab20();
	lab.probabilityBoard();
    }
}
