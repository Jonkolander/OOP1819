package Assignment05;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class ExpressionFactory {
    
    public static Expression con(double value) {
        return new Constant(value);
    }
    
    public static Expression var(String variable) {
        return new Variable(variable);
    }
    
    public static Expression neg(Expression X) {
        return new Negate(X);
    }
    
    public static Expression add(Expression X, Expression Y) {
        return new Addition(X, Y);
    }
    
    public static Expression mul(Expression X, Expression Y) {
        return new Multiplication(X, Y);
    }
}

