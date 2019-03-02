package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Negate extends OneArgumentExpression {

    private final Expression X;
    
    public Negate(Expression x) {
        super();
        this.X = x;
    }
    
    @Override
    public Expression partialEval() {
        Expression partialX = this.X.partialEval();
        if (partialX instanceof Constant){
            Constant constant = (Constant) partialX;
            return new Constant(-constant.value());
        } else if (partialX instanceof Variable) {
            Variable variable = (Variable) partialX;
            return new Variable("-" + variable.name());
        }
        return this;
    }

    @Override
    public Expression eval(Map<String, Double> env) {
        return this.X.eval(env);
    }
    
    @Override
    public String toString() {
        return "-" + this.X;
    }

}
