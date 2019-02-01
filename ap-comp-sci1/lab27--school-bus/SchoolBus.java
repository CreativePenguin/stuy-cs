import java.util.ArrayList;

public class SchoolBus extends ArrayList<Student> {

    int seats;
    
    public SchoolBus(int seats) {
        super();
        this.seats = seats;
    }

    public boolean isFull() {
        return size() == seats;
    }

    @Override
    public boolean add(Student obj) {
        if(!isFull()) return super.add(obj);
        return false;
    }

    @Override
    public void add(int index, Student obj) {
        if(!isFull()) super.add(index, obj);
    }

}
