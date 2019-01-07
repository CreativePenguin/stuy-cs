public class Domino {

    private final int LEFT;
    private final int RIGHT;

    public Domino() {
        this(0, 0);
    }

    public Domino(int left, int right) {
        LEFT = left;
        RIGHT = right;
    }

    public int getLeftDots() {
        return LEFT;
    }

    public int getRightDots() {
        return RIGHT;
    }

    private String topRow(int dotTotal) {
        return (dotTotal / 2 == 0) ?  "*       *" :
            (dotTotal / 2 == 1) ?     "*     0 *" :
            "* 0   0 *";
    }

    private String midRow(int dotTotal) {
        return (dotTotal % 2 == 1) ? "*   0   *" :
            (dotTotal == 6) ? "* 0   0 *" :
            "*       *";
    }

    private String botRow(int dotTotal) {
        return (dotTotal == 1) "*       *" :
            (dotTotal <= 3)    "* 0     *" :
            "* 0   0 *";
    }
    
    @Override
    public String toString() {
        String val = "*****************\n";
        val += topRow(LEFT); val += topRow(RIGHT); val += "\n";
        val += midRow(LEFT); val += midRow(RIGHT); val += "\n";
        val += botRow(LEFT); val += botRow(RIGHT); val += "\n";
        val += "*****************\n";
        return val;
    }

}
