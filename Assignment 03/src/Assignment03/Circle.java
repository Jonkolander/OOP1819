package Assignment03;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Circle implements Geometric {

    private double x;
    private double y;
    private final double RADIUS;
    
    public Circle (double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.RADIUS = radius;
    }
    
    @Override
    public double left() {
        return this.x - this.RADIUS;
    }

    @Override
    public double right() {
        return this.x + this.RADIUS;
    }

    @Override
    public double top() {
        return this.y + this.RADIUS;
    }

    @Override
    public double bottom() {
        return this.y - this.RADIUS;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(this.RADIUS, this.x);
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
        return "Circle(x: " + this.x 
                + ", y: " + this.y 
                + ", radius: " + this.RADIUS 
                + ", area: " + this.area() 
                + ")";
    }    

}
