package Forms;

import Visitors.FormVisitor;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public enum ConstantForm implements Form {

  TRUE(true), FALSE(false);

  private final boolean VAL;

  private ConstantForm(boolean b) {
    this.VAL = b;
  }

  public boolean getBooleanVal() {
    return this.VAL;
  }

  @Override
  public <R> R accept(FormVisitor<R> visitor) {
    return visitor.visit(this);
  }

}
