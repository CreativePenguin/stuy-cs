public final class BakersDozen extends BagelsOrderItem implements OrderItem {
    public BakersDozen(double price) {
        super(price, 13);
    }

    @Override
    public double getCost() {
        return super.getCost() - PRICE;
    }
}
