public class Cannonball {

    public static int cannonball(int height) {
        return (height == 1) ? 1 :
            cannonball(height - 1) + height * height;
    }

    public static void main(String[] args) {
        System.out.println(cannonball(2));
        System.out.println(cannonball(3));
        System.out.println(cannonball(4));
    }

}
