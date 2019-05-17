package Visitors;

import Forms.AtomForm;
import Forms.ConstantForm;
import Forms.NotForm;
import Forms.BinOpForm;

/**
 * A class designed to print given formulas
 *
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class PrintFormVisitor implements FormVisitor<String> {

  @Override
  public String visit(NotForm notForm) {
    return "~" + notForm.getOperand().accept(this);
  }

  @Override
  public String visit(BinOpForm binOpForm) {
    return "(" + binOpForm.getLeftOperand().accept(this)
      + " " + binOpForm.getOperand().getBinOp()
      + " " + binOpForm.getRightOperand().accept(this)
      + ")";
  }

  @Override
  public String visit(ConstantForm constantForm) {
    return constantForm.getBooleanVal() + "";
  }

  @Override
  public String visit(AtomForm atomForm) {
    return atomForm.getVariable();
  }

}
