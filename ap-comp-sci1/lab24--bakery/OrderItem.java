public interface OrderItem {

    public double getPrice();

    public int getQuantity();

    public double getCost();

}

/*
  |--------------|
  |  Order Item  |
  |--------------|
         |        \
         |         \
         |          \
  |---------------|  |-------------------|
  |  BakersDozen  |--|  BagelsOrderItem  |
  |---------------|  |-------------------|
*/
