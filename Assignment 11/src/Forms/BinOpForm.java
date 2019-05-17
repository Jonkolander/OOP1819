package Forms;

import Visitors.FormVisitor;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class BinOpForm implements Form {

  private final BinOp OPERAND;
  private final Form LEFT_OPERAND;
  private final Form RIGHT_OPERAND;

  public BinOpForm(Form leftOperand, Form rightOperand, BinOp operand) {
    this.LEFT_OPERAND = leftOperand;
    this.OPERAND = operand;
    this.RIGHT_OPERAND = rightOperand;
  }

  public Form getLeftOperand() {
    return this.LEFT_OPERAND;
  }

  public Form getRightOperand() {
    return this.RIGHT_OPERAND;
  }

  public BinOp getOperand() {
    return this.OPERAND;
  }

  @Override
  public <R> R accept(FormVisitor<R> visitor) {
    return visitor.visit(this);
  }

}
