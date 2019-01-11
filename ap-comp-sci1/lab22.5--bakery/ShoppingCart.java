import java.util.ArrayList;

public class ShoppingCart extends ArrayList<OrderItem> {

    public double totalDue() {
        double sum = 0;
        for(OrderItem i : this) {
            sum += i.getPrice();
        }
        return sum;
    }

}
