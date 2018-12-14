public class Lab19 {

    public int[][] countMines(boolean[][] mines) {
	int val = new int[mines.length][mines[0].length];
	for(int i = 0; i < mines.length; i++) {
	    for(int j = 0; j < mines[0].length; i++) {
		int indexVal = 0;
		if(mines[i - 1][j]) indexVal += 1;
		if(mines[i + 1][j]) indexVal += 1;
		if(mines[i][j]) indexVal += 1;
		if(mines[i][j + 1]) indexVal += 1;
		if(mines[i][j - 1]) indexVal += 1;
		if(mines[i + 1][j + 1]) indexVal += 1;
		if(mines[i - 1][j - 1]) indexVal += 1;
		if(mines[i + 1][i - 1]) indexVal += 1;
		if(mines[i - 1][i + 1]) indexVal += 1;
	    }
	}
	return val;
    }
