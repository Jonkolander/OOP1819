package Assignment05;

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import static Assignment05.ExpressionFactory.*;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main {
    
    public static void main (String[] args) {
        Map<String, Double> env = new HashMap<>();
        env.put("pi", 3.1415);
        env.put("y", 5.0);
        
        Expression n = con(3);
        Expression m = con(4);
        Expression y = var("y");
        Expression e = add(n, y);
        
        List<Expression> expressions = new ArrayList<>();
        expressions.add(add(n, m));
        expressions.add(add(e, con(0)));
        expressions.add(add(con(0), e));
        expressions.add(mul(n, m));
        expressions.add(mul(con(0), e));
        expressions.add(mul(con(1), e));
        expressions.add(mul(e, con(0)));
        expressions.add(mul(e, con(1)));
        expressions.add(neg(n));
        expressions.add(mul(var("pi"), con(3)));
        expressions.add(neg(var("pi")));
        
        View view = new View(env);
        view.printEnvironment();
        view.printTestCases(expressions);
    }
    
}
