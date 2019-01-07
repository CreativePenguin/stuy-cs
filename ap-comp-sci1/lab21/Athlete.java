public class Athlete implements Trainable {

    private final String FIRSTNAME;
    private final String LASTNAME;
    protected double hoursTrained;

    public Athlete(String firstname, String lastname) {
        FIRSTNAME = firstname;
        LASTNAME = lastname;
    }

    @Override
    public String toString() {
        return FIRSTNAME + " " + LASTNAME + ", " + hoursTrained;
    }

    public void train(double hours) {
        hoursTrained = hours;
    }

    public double getHoursTrained() {
        return hoursTrained;
    }

}
