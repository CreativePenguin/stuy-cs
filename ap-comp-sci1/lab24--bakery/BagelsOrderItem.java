public class BagelOrderItem implements OrderItem {

    private final double PRICE;
    private final double QUANTITY;
    
    public BagelOrderItem(double price, int quantity) {
        PRICE = price;
        QUANTITY = quantity;
    }

    @Override
    public double getPrice() {
        return PRICE;
    }

    @Override
    public double getQuantity() {
        return QUANTITY;
    }

    @Override
    public double getCost() {
        return PRICE * QUANTITY;
    }
    
}
