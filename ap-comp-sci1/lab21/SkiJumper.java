public final class SkiJumper extends Athlete implements Flier, Comparable<SkiJumper> {

    private int jumps;

    public SkiJumper(String firstname, String lastname) {
        super(firstname, lastname);
        super.hoursTrained = 0;
    }
    
    @Override
    public void fly() {
        jumps++;
    }

    public int getJumps() {
        return jumps;
    }

    @Override
    public String toString() {
        return super.toString() + jumps;
    }

    @Override
    public int compareTo(SkiJumper rival) {
        return jumps > rival.getJumps() ? 1 :
            jumps == rival.getJumps() ? 0 : -1;
    }

}
