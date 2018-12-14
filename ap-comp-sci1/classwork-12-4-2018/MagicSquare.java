public class MagicSquare {

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

}
