package Assignment03;

/**
 * The Geometric object interface
 * 
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
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
