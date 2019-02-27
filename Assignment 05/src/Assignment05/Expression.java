package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public interface Expression {
    
    public Expression partialEval();
    
    public Expression eval(Map<String, Double> env);
    
    @Override
    public String toString();
    
}
