public class Test {
    public static void main(String[] args) {
        String test = "This is a really long String";
        System.out.println(test.substring(0, 3) + test.substring(3, test.length()));
    }
}
