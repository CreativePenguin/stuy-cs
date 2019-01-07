import java.util.List;
import java.util.ArrayList;

public class IsEvenClient {
    
    public static List<Boolean> filter(PredicateFunction f, List<Integer> list) {
        List<Boolean> val = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            val.add(f.evaluate(list.get(i)));
        }
        return val;
    }

    public static void main(String[] filter) {
        List<Integer> list5 = new IntegerList(1, 2, 3, 4, 5);
        System.out.println(list5);
        System.out.println(filter(new IsEven(), list5));
    }

}
