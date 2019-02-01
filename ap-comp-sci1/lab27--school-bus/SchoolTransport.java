import java.util.List;

public class SchoolTransport {

    List<SchoolBus> buses;

    public SchoolTransport() {
        buses = new ArrayList<>();
    }

    public void add(SchoolBus bus) {
        buses.add(bus);
    }

    private boolean placeStudent(Student oldbie, Student newbie) {
        return oldbie.distance(newbie) != 9999;
    }

    public boolean enroll(Student student) {
        for(SchoolBus i : buses) {
            if(!i.isFull()) {
                for(Student j : i) {
                    if(placeStudent(j, student)) {
                        i.add(j);
                    }
                }
            }
        }
        return false;
    }
