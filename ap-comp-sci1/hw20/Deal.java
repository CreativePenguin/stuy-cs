public class Deal {

    private final suits = ["h", "d", "s", "c"];
    private final rank = ["2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"];
    
    private void run(int n) {
        for(int i = 0; i < n; i++) {
            System.out.printf("suit %d rank %d",
                              rank[(int) (Math.random() * 13)],
                              suits[(int) (Math.random() * 4)]);
        }
    }
        
}
