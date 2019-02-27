package Assignment05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {

    public static void main (String[] args) {
        Map<String, Double> env = new HashMap<>();
        env.put("pi", 3.1415);
        
        Constant n = new Constant(3);
        Constant m = new Constant(4);
        Expression e = new Addition(n, m);
        
        List<Expression> expressions = new ArrayList<>();
        expressions.add(new Addition(n, m));
        expressions.add(new Addition(e, new Constant(0)));
        expressions.add(new Addition(new Constant(0), e));
        expressions.add(new Multiplication(n, m));
        expressions.add(new Multiplication(new Constant(0), e));
        expressions.add(new Multiplication(new Constant(1), e));
        expressions.add(new Multiplication(e, new Constant(0)));
        expressions.add(new Multiplication(e, new Constant(1)));
        expressions.add(new Negate(n));
        expressions.add(new Addition(new Variable("pi"), new Constant(3)));
        
        for(Expression exp : expressions) {
            System.out.printf("%-20s = %s\n", exp, exp.partialEval().eval(env));
        }
        
    }
    
}
