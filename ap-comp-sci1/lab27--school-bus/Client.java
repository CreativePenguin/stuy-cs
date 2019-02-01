import java.util.ArrayList;

public class Client {

    public static void main(String[] args) {
        SchoolBus bus = new SchoolBus(3);
        bus.add(new Student("Billy Boy", "33", 12));
        bus.add(new Student("Stuyvesant", "Homer", 3312));
        bus.add(new Student("Togepi", "Pachirisu", 794));
        bus.add(new Student("Cyndaquil", "Turts", 501));
        System.out.println(bus);
        bus.remove(2); 
        System.out.println(bus);
        bus.add(2, new Student("Index 0", "hell", 371));
        System.out.println(bus);
    }

}
