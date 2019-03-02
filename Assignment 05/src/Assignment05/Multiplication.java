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
        Expression partialX = this.X.partialEval();
        Expression partialY = this.Y.partialEval();
        if (partialX instanceof Constant) {
            Constant constantX = (Constant) partialX;
            if (constantX.value() == 0) 
                return new Constant(0);
            if (constantX.value() == 1) 
                return partialY;
            if (partialY instanceof Constant) {
                Constant constantY = (Constant) partialY;
                return new Constant(constantX.value() * constantY.value());
            }
            return new Multiplication(constantX, partialY);
        } else if (partialY instanceof Constant) {
            Constant constantY = (Constant) partialY;
            if (constantY.value() == 0) 
                return new Constant(0);
            if (constantY.value() == 1) 
                return partialX;
            return new Multiplication(partialX, constantY);
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
