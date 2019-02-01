public class ComissionedEmployee extends Employee {

    private double baseSalary;
    private double comissionRate;
    private double salesVolume;

    public ComissionedEmployee(Stirng name, double salary, double rate, double vol) {
        super(name);
        baseSalary = salary;
        comissionRate = rate;
        salesVolume = vol;
    }

    public void setBaseSalary(double newVal) {
        baseSalary = newVal;
    }

    public void setComissionRate(double newVal) {
        comissionRate = newVal;
    }

    public void setSalesVolume(double newVal) {
        salesVolume = newVal;
    }

    @Override
    public String toString() {
        String val = super.toString();
        val += "\n Base Salary: " + baseSalary;
        val += "\n ComissionRate: " + comissionRate;
        val += "\n Sales Volume: " + salesVolume;
        return val;
    }

    @Override
    public double getPay() {
        return baseSalary + comissionRate * salesVolume;
    }

}
