package Assignment05;

import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Addition extends TwoArgumentExpression {

    private final Expression X;
    private final Expression Y;
    
    public Addition (Expression x, Expression y) {
        super();
        this.X = x;
        this.Y = y;
    }
    
    @Override
    public Expression partialEval() {
        Expression av = this.X.partialEval();
        Expression bv = this.Y.partialEval();
        if (av instanceof Constant) 
        {
            Constant ac = (Constant) av;
            if (ac.value() == 0) 
                return bv;
            if (bv instanceof Constant) {
                Constant bc = (Constant) bv;
                return new Constant(ac.value() + bc.value());
            }
            return new Addition(ac, bv);
        } 
        else if (bv instanceof Constant) {
            Constant bc = (Constant) bv;
            if (bc.value() == 0) 
                return av;
            return new Addition(av, bc);
        }
        return this;
    }

    @Override
    public Expression eval(Map<String, Double> env) {
        Expression evaluatedExpression = new Addition(this.X.eval(env), this.Y.eval(env));
        return evaluatedExpression.partialEval();
    }
    
    @Override
    public String toString() {
        return "(" + this.X + " + " + this.Y + ")";
    }

}
