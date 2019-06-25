package finalproject;

import finalproject.util.Sorts;

import java.util.ArrayList;
import java.util.List;

public class BWTE {

    private static BWTE instance;

    private BWTE() {}

    public static BWTE getInstance() {
        return (instance == null) ? new BWTE() : instance;
    }

    private List<String> cyclicRotations(String input) {
        List<String> ans = new ArrayList<>();
        String[] inputList = input.split("");
        for(int i = 0; i < input.length(); i++) {
            shift(inputList, 0, input.length() - 1);
            ans.set(i, listToString(inputList));
        }
        Sorts.mergeSort(ans);
        return ans;
    }

    private String BWT(List<String> cyclicRotations) {
        StringBuilder ans = new StringBuilder();
        for(String i : cyclicRotations) {
            ans.append(i.substring(i.length() - 1));
        }
        return ans.toString();
    }

    private <T> void shift(T[] li, int i1, int i2) {
        int min = (i1 < i2) ? i1 : i2;
        int max = (i1 < i2) ? i2 : i1;
        T tmp = li[max];
        for(int i = max; i > min; i--) {
            li[i] = li[i - 1];
        }
        li[min] = tmp;
    }

    private <T> String listToString(T[] li) {
        StringBuilder ans = new StringBuilder();
        for(T i : li) ans.append(i.toString());
        return ans.toString();
    }

    public String BurrowsWheelerTransform(String input) {
        return BWT(cyclicRotations(input));
    }

}
