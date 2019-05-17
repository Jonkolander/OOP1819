package Forms;

import Visitors.FormVisitor;
import java.util.Map;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public class AtomForm implements Form {

  private final String VARIABLE;

  public AtomForm(String variable) {
    this.VARIABLE = variable;
  }

  public String getVariable() {
    return this.VARIABLE;
  }

  @Override
  public <R> R accept(FormVisitor<R> visitor) {
    return visitor.visit(this);
  }

  public Boolean getVariableValue(Map<String, Boolean> ENVIRONMENT) {
    if (ENVIRONMENT.containsKey(VARIABLE)) {
      return ENVIRONMENT.get(VARIABLE);
    }
    return false;
  }

}
