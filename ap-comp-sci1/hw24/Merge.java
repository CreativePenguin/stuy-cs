import java.util.ArrayList;
import java.util.Scanner;

public class Merge {

    private ArrayList<String> sortArray(ArrayList<String> unsortedList) {
	ArrayList<String> val = new ArrayList<>();
	int size = unsortedList.size();
	for(int i = 0; i < size; i++) {
	    String testVal = null;
	    for(String s : unsortedList) {
		testVal = (testVal == null) ? s :
		    (s.compareTo(testVal) < 0) ? s : testVal;
	    }
	    unsortedList.remove(testVal);
	    val.add(testVal);
	}
	return val;
    }

    private ArrayList<String> merge(ArrayList<String> list1, ArrayList<String> list2) {
	ArrayList<String> val = new ArrayList<>();
	int counter1 = 0; int counter2 = 0;
	while(counter1 < list1.size() && counter2 < list2.size()) {
	    tmp1 = list1.get(counter1); tmp2 = list2.get(counter2);
	    if(tmp1.compareTo(tmp2) < 0) {
		val.add(tmp1);
		counter1++;
	    } else if(tmp2.compareTo(tmp1) < 0) {
		val.add(tmp2);
		counter2++;
	    } else {
		val.add(tmp1); val.add(tmp2);
		counter1++; counter2++;
	    }
	}
	return val;
    }

    public static void main(String[] args) {
	ArrayList<String> list = new ArrayList<>();
	Merge file = new Merge();
	list.add("Banana"); list.add("Calculus"); list.add("Abacus"); 
	System.out.println(file.sortArray(list));
    }

}
