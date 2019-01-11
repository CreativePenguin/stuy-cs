public class TestCoin {
    
    public static void main(String[] args) {
        Flippable c = new BiasedCoin(0.2);
        System.out.println(c.toString());
    }

}
