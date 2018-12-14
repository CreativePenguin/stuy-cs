import java.util.ArrayList;

public class ListDemo {

    public static void main(String[] args) {
	ArrayList<Integer> list = new ArrayList<>();
	list.add(694); list.add(310); list.add(479);
	System.out.println(list.size());
	System.out.println(list.isEmpty());
	System.out.println(list.contains(42));
	System.out.println(list.indexOf(31));
	System.out.println(list.get(1));
	list.set(0, 254);
	System.out.println(list);
    }

}
    
