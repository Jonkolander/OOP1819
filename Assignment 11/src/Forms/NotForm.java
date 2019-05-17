package Forms;

import Visitors.FormVisitor;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class NotForm implements Form {

  private final Form OPERAND;

  public NotForm(Form operand) {
    this.OPERAND = operand;
  }

  public Form getOperand() {
    return this.OPERAND;
  }

  @Override
  public <R> R accept(FormVisitor<R> visitor) {
    return visitor.visit(this);
  }
}
