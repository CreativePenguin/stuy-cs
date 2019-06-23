package finalproject;

public class BurrowsWheelerDataCompression {

    private static BurrowsWheelerDataCompression instance;

    private BurrowsWheelerDataCompression() {}

    public BurrowsWheelerDataCompression getInstance() {
        return (instance == null) ? new BurrowsWheelerDataCompression() : instance;
    }

    private String[] cyclicRotations(String input) {
        String[] ans = new String[input.length()];
        String[] inputList = input.split("");
        for(int i = 0; i < input.length(); i++) {
            swap(inputList, 0, input.length() - 1);
            ans[i] = listToString(inputList);
        }
        return ans;
    }

    private <T> void swap(T[] li, int i1, int i2) {
        T tmp = li[i1];
        li[i1] = li[i2];
        li[i2] = li[i1];
    }

    private <T> String listToString(T[] li) {
        StringBuilder ans = new StringBuilder();
        for(T i : li) ans.append(i.toString());
        return ans.toString();
    }
}
