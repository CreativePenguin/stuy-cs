public class Coin implements Flippable {

    @Override
    public String flip() {
        return Math.random() > 0.5 ? "H" : "T";
    }

}
