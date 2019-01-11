public class BiasedCoin extends Coin {

    private final double chance;

    public BiasedCoin(double probabilityH) {
        double chance = probabilityH;
        while(chance > 1) {
            chance /= 10;
        }
        this.chance = chance;
    }

    @Override
    public String flip() {
        return Math.random() < chance ? "H" : "T";
    }

}
