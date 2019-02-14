package Assignment03;

/**
 * @author Dennis den Hollander
 */
public interface Geometric extends Comparable<Geometric> {

    public double left();
    
    public double right();
    
    public double top();
    
    public double bottom();
    
    public double area();
    
    public void move (double dx, double dy);
    
    @Override
    public int compareTo(Geometric geometric);
}
