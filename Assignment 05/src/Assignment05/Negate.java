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
        Expression e1 = this.X.partialEval();
        if (e1 instanceof Constant){
            Constant c1 = (Constant) e1;
            return new Constant(-c1.value());
        }
        else if (e1 instanceof Variable) {
            Variable v1 = (Variable) e1;
            return new Variable("-" + v1.name());
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
