import java.util.ArrayList;

public class APDataAnalysis {

    private static boolean isMode(ArrayList<Integer> data, int k) {
	return data.get(k - 1) < data.get(k) && data.get(k + 1) < data.get(k);
    }

    private static int modeIndex(ArrayList<Integer> data) {
	for(int i : data) {
	    if(isMode(data, i)) return i;
	}
	return -1;
    }

    private static void printHistogram(ArrayList<Integer> data, int barChar) {
	for(Integer i : data) {
	    for(int j = 0; j < longestBar * i / data.get(modeIndex(data)); j++) {
		System.out.print(barChar);
	    }
	    System.out.println();
	}
    }

}
