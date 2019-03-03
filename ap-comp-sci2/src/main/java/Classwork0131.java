package hw;

public class Classwork0131 {

    //map(lamda x : x == 694, data)
    private static int sequentialSearch(int[] data, int x) {
        for(int i = 0; i < data.length; i++) {
            if(data[i] == x) return i;
        }
        return -1;
    }
    //function: data.length is the amount of work done

    public static void print(int [] data){
        for (int x: data)
            System.out.print(x + " ");
        System.out.println();
    }

    private static boolean selfOrganizingSearch(int[] data, int x) {
        boolean val = false;
        int count = 0;
        for(int i : data) {
            if(i == x) {
                count ++;
                val = true;
            }
        }
        for(int i = 0; i < count; i++) data[i] = x;
        for(int i = data.length - 1; i >= count; i--) data[i] = data[i - count];
        return val;
    }
}
