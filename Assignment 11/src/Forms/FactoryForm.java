package Forms;

/**
 * A class designed to shorten the composition of logical formulas
 *
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class FactoryForm {

  public static Form not(Form form) {
    return new NotForm(form);
  }

  public static Form var(String string) {
    return new AtomForm(string);
  }

  public static Form binOp(Form form1, Form form2, BinOp operand) {
    return new BinOpForm(form1, form2, operand);
  }
}
