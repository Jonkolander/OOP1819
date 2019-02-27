package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Multiplication extends TwoArgumentExpression {

    private final Expression X;
    private final Expression Y;
    
    public Multiplication(Expression x, Expression y) {
        super();
        this.X = x;
        this.Y = y;
    }
    
    @Override
    public Expression partialEval() {
        Expression av = this.X.partialEval();
        Expression bv = this.Y.partialEval();
        if (av instanceof Constant) {
            Constant ac = (Constant) av;
            if (ac.value() == 0) 
                return new Constant(0);
            if (ac.value() == 1) 
                return bv;
            if (bv instanceof Constant) {
                Constant bc = (Constant) bv;
                return new Constant(ac.value() * bc.value());
            }
            return new Multiplication(ac, bv);
        } else if (bv instanceof Constant) {
            Constant bc = (Constant) bv;
            if (bc.value() == 0) 
                return new Constant(0);
            if (bc.value() == 1) 
                return av;
            return new Multiplication(av, bc);
        }
        return this;
    }

    @Override
    public Expression eval(Map<String, Double> env) {
        Expression evaluatedExpression = new Multiplication(this.X.eval(env), this.Y.eval(env));
        return evaluatedExpression.partialEval();
    }
    
    @Override
    public String toString() {
        return "(" + this.X + " * " + this.Y + ")";
    }

}
