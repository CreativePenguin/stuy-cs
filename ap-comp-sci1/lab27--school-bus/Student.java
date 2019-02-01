public class Student implements Person {

    private String name;
    private String street;
    private int num;

    public Student(String name, String street, int num) {
        this.name = name;
        this.street = street;
        this.num = num;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public int getNumber() {
        return num;
    }

    public int distance(Student other) {
        if(!street.equals(other.getStreet())) {
            return 9999;
        }
        return Math.abs(other.getNumber() - num);
    }

    @Override
    public String toString() {
        String val = "Name: " + name;
        val += "\nStreet: " + street;
        val += "\nNumber: " + num;
        return val;
    }

}
