public class Lab18 {

    private boolean isMagicSquare(int[][] square) {
	try {
	    for(int i = 0; i < square.length; i++) {
		int sumRow = 0;
		int sumCol = 0;
		for(int j = 0; j < square[0].length; j++) {
		    sumRow += square[i][j];
		    sumCol += square[j][i];
		}
		final int SUM = sumRow;
		System.out.println(SUM + " " + sumRow + " " + sumCol);
		if(SUM != sumRow) return false;
		if(SUM != sumCol) return false;
	    }
	} catch(ArrayIndexOutOfBoundsException ex) {
	    System.out.println(ex.toString());
	    return false;
	}
	return true;
    }

    private boolean[][] hadamard(int side) {
	boolean[][] val = new boolean[side][side];
	for(int i = 0; i < side; i++) {
	    val[i][i + side / 2] = val[i][i];
	    val[i + side / 2][i] = val[i][i];
	}
	return val;
    }
		

    public static void main(String[] args) {
	int[][] threebythree = { {8, 1, 6},
				 {3, 5, 7},
				 {4, 9, 2} };
	int[][] fourbyfour = { {16, 3, 2, 13},
			       {5, 10, 11, 18},
			       {9, 6, 7, 12},
			       {4, 15, 14, 1} };
	int[][] failure = { {1, 2, 3},
			    {1, 2, 3},
			    {1, 2, 3} };
	Lab18 lab = new Lab18();
	System.out.println(lab.isMagicSquare(threebythree));
	System.out.println(lab.isMagicSquare(failure));
    }

}
