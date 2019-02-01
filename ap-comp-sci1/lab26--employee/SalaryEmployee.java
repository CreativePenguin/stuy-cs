public class SalaryEmployee extends Employee {

    private double salary;

    public SalaryEmployee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    public void setSalary(double newVal) { salary = newVal; }
    
    @Override
    public double getPay() { return salary; }

    @Override
    public String toString() {
        String val = super.toString();
        val += "\n Salary: " + salary;
        return val;
    }

    @Override
    public double payCheck() {
        return salary;
    }
}
