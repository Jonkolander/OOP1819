package Assignment03;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Rectangle implements Geometric {

    private double x;
    private double y;
    private final double WIDTH;
    private final double HEIGHT;

    public Rectangle(double x, double y, double w, double h) {
        this.x = x;
        this.y = y;
        this.WIDTH = w;
        this.HEIGHT = h;
    }
    
    @Override
    public double left() {
        return this.x;
    }

    @Override
    public double right() {
        return this.x + this.WIDTH;
    }

    @Override
    public double top() {
        return this.y + this.HEIGHT;
    }

    @Override
    public double bottom() {
        return this.y;
    }

    @Override
    public double area() {
        return this.WIDTH * this.HEIGHT;
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
        return "Rectangle(x: " + this.x 
                + ", y: " + this.y 
                + ", width: " + this.WIDTH 
                + ", height: " + this.HEIGHT 
                + ", area: " + this.area() 
                + ")";
    }

}
