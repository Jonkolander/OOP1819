package Assignment03;

/**
 * @author Dennis den Hollander
 */
public class Circle implements Geometric {

    private double x;
    private double y;
    private double radius;
    
    public Circle (double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
    
    @Override
    public double left() {
        return this.x - this.radius;
    }

    @Override
    public double right() {
        return this.x + this.radius;
    }

    @Override
    public double top() {
        return this.y + this.radius;
    }

    @Override
    public double bottom() {
        return this.y - this.radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.radius, this.x);
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
        return "Circle(x: " + x + ", y: " + y + ", radius: " + radius + ", area: " + area() + ")";
    }    

}
