public class CouponCollector {

    private int couponCollector(int amt) {
        int counter = 0;
        boolean[] valList = new boolean[amt];
        while(someFalse(valList)) {
            int index = (int) (Math.random() * amt);
            valList[index] = true;
            counter++;
        }
        return counter;
    }

    private boolean someFalse(boolean[] list) {
        for(boolean i : list) {
            if(!i) return true;
        }
    }

}
