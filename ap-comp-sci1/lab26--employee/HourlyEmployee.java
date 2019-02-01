public class HourlyEmployee extends Employee implements Payable {

    private double hourlyRate;
    private double hoursWorked;

    public HourlyEmployee(String name, double rate, double hours) {
        super(name);
        hourlyRate = rate;
        hoursWorked = hours;
    }

    public void setHourlyRate(double newVal) {
        hourlyRate = newVal;
    }

    public void setHoursWorked(double newVal) {
        hoursWorked = newVal;
    }

    @Override
    public String toString() {
        String val = super.toString();
        val += "\n Hourly Rate: " + hourlyRate;
        val += "\n Hours Worked: " + hoursWorked;
        return val;
    }

    @Override
    public double getPay() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public double payCheck() {
        double val = getPay();
        hoursWorked = 0;
        return val;
    }
}
