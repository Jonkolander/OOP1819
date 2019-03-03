package Assignment06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public interface Configuration extends Comparable<Configuration> {
    
    public abstract Configuration parent();
    
    public abstract Collection<Configuration> successors();
    
    public abstract boolean isSolution();
    
    public abstract int manhattanDistance();
    
    public default List<Configuration> pathFromRoot() {
        List<Configuration> path = new ArrayList();
        Configuration current = this;
        path.add(current);
        while (current.parent() != null) {
            Configuration parent = current.parent();
            path.add(0, parent);
            current = parent;
        }
        return path;
    }
}
