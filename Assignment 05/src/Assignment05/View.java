package Assignment05;

import java.util.List;
import java.util.Map;

/**
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class View {

    private final Map<String, Double> ENV;
    
    public View (Map<String, Double> env) { 
        this.ENV = env;
    };
    
    public void printEnvironment() {
        System.out.println("Environment store: ");
        for (Map.Entry<String, Double> entry : this.ENV.entrySet()) {
            System.out.printf("%-4s = %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
    
    public void printTestCases(List<Expression> expressions) {
        System.out.printf("%-20s | %-20s | Evaluation\n", "Expression", "Partial evaluation");
        System.out.println("---------------------+----------------------+-------------");
        for(Expression exp : expressions) {
            System.out.printf("%-20s | %-20s | %s\n", exp, exp.partialEval(), exp.partialEval().eval(this.ENV));
        }
    }
    
}
