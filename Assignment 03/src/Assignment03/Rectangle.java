package Assignment03;

/**
 * @author Dennis den Hollander
 */
public class Rectangle implements Geometric {

    private double x;
    private double y;
    private double width;
    private double height;

    public Rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.width = w;
        this.height = h;
    }
    
    @Override
    public double left() {
        return this.x - this.width;
    }

    @Override
    public double right() {
        return this.x + this.width;
    }

    @Override
    public double top() {
        return this.y + this.height;
    }

    @Override
    public double bottom() {
        return this.y - this.height;
    }

    @Override
    public double area() {
        return this.width * this.height;
    }

    @Override
    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public int compareTo(Geometric geometric) {
        return Double.compare(this.area(), geometric.area());
    }
    
    @Override
    public String toString() {
        return "Rectangle(x: " + x + ", y: " + y + ", width: " + width + ", height: " + height + ", area: " + area() + ")";
    }

}
