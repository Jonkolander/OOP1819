package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Variable extends NoArgumentExpression {

    private final String NAME;
    
    public Variable (String name) {
        super();
        this.NAME = name;
    }
    
    public String name() {
        return this.NAME;
    }
    
    @Override
    public Expression partialEval() {
        return this;
    }

    @Override
    public Expression eval(Map<String, Double> env) {
        return new Constant(env.get(this.NAME));
    }
    
    @Override
    public String toString () {
        return this.NAME;
    }

}
