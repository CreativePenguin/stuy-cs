public final class Point {

    private int x;
    private int y;

    public Point() {
        this(0, 0);
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {return x;}

    public int getY() {return y;}

    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void translate(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setLocation(Point other) {
        x = other.x;
        y = other.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
