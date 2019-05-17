package Assignment11;

import Forms.AtomForm;
import Forms.BinOp;
import Visitors.EvalFormVisitor;
import Visitors.PrintFormVisitor;
import Forms.Form;
import java.util.HashMap;
import java.util.Map;

import static Forms.ConstantForm.*;
import static Forms.BinOp.*;
import Forms.BinOpForm;
import static Forms.FactoryForm.*;
import Forms.NotForm;
import java.util.ArrayList;
import java.util.List;

/**
 * The main class
 *
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class Main {

  private static final Map<String, Boolean> ENVIRONMENT = new HashMap<String, Boolean>() {{
    put("X", true);
    put("Y", true);
    put("Z", false);
    put("P", false);
    put("Q", true);
  }};

  /**
   * NOTE: add() is not part of the logical outcome of the formula!
   */
  private static final List<Form> FUNCTIONS = new ArrayList<Form>() {{
    add(not(FALSE));
    add(binOp(TRUE, not(TRUE), AND));
    add(binOp(TRUE, TRUE, AND));
    add(binOp(binOp(TRUE, TRUE, AND), not(FALSE), IMPLIES));
    add(binOp(var("X"), var("Y"), AND));
    add(binOp(var("X"), var("Z"), AND));
    add(binOp(not(var("Z")), binOp(TRUE, var("X"), IMPLIES), IFF));
  }};

  public static void main(String args[]) {
    // Test cases from assignment
    Form f1 = new NotForm(new BinOpForm(new AtomForm("P"), new AtomForm("Q"), BinOp.IMPLIES));
    Form f2 = new BinOpForm(new NotForm(new AtomForm("P")), new AtomForm("Q"), BinOp.IMPLIES);
    
    System.out.println(f1.accept(new PrintFormVisitor()));
    System.out.println(f1.accept(new EvalFormVisitor(ENVIRONMENT)));
    System.out.println(f2.accept(new PrintFormVisitor()));
    System.out.println(f2.accept(new EvalFormVisitor(ENVIRONMENT)));
    
    for (Form function : FUNCTIONS) {
      printFunction(function);
      printEvaluation(function);
    }
  }

  public static void printFunction(Form f) {
    System.out.print(f.accept(new PrintFormVisitor()) + ": ");
  }

  public static void printEvaluation(Form f) {
    System.out.println(f.accept(new EvalFormVisitor(ENVIRONMENT)));
  }
}
