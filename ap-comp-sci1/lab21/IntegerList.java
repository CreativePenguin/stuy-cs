import java.util.ArrayList;
public class IntegerList extends ArrayList<Integer> {

    public IntegerList(int... input) {
        for(int i : input) {
            super.add(i);
        }
    }

}
