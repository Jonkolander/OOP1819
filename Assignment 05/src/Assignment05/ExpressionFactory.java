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
    
    public static Expression add(Expression A, Expression B) {
        return new Addition(A, B);
    }
    
    public static Expression mul(Expression A, Expression B) {
        return new Multiplication(A, B);
    }
    
    public static Expression neg(Expression A) {
        return new Negate(A);
    }
}

