package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Constant extends NoArgumentExpression {
    
    private final double VALUE;
    
    public Constant (double value) {
        super();
        this.VALUE = value;
    }
    
    public double value() {
        return this.VALUE;
    }

    @Override
    public Expression partialEval() {
        return this;
    }

    @Override
    public Expression eval(Map<String, Double> env) {
        return this;
    }
    
    @Override
    public String toString() {
        return Double.toString(this.VALUE);
    }

}
