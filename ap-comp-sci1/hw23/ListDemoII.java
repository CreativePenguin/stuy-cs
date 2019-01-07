import java.util.ArrayList;

public class ListDemoII{

    public static void main(String [] args){
	new ListDemoII().run();
    }

    public void run(){
	ArrayList<String> list1 = new ArrayList<String>();
	ArrayList<String> list2 = new ArrayList<String>();
	String s = "abacadefg";
	for (int i = 0; i < s.length(); i++){
	    if (i % 2 == 0) list1.add(s.substring(i,i+1));
	    else list2.add(s.substring(i,i+1));
	}
	System.out.println("list 1: " + list1);
	System.out.println("list 2: " + list2);
	// Test numOccurrences
	System.out.println("a occurs " + numOccurrences(list1,"a") + " times in " + list1);
	// Test append
	System.out.println("append(" + list1 + ", " + list2 + "): " + append(list1,list2));
	System.out.println("append(" + list2 + ", " + list1 + "): " + append(list2,list1));
    }


    private int numOccurrences(ArrayList<String> list, String x){
	int ans = 0;
	for (String a : list)
	    if (a.equals(x)) ans++;
	return ans;
    }

    private ArrayList<String> append(ArrayList<String> list1, ArrayList<String> list2){
	ArrayList<String> ans = new ArrayList<String>();
	for (String x: list1)
	    ans.add(x);
	for (String x : list2)
	    ans.add(x);
	return ans;
	
    }

    private ArrayList<String> reverse(ArrayList<String> list) {
        ArrayList<String> rev = new ArrayList<String>();
        for(String i : list) {
            rev.add(0, i);
        }
        return rev;
    }

}
