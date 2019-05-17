package Forms;

import Visitors.FormVisitor;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public interface Form {

  public <R> R accept(FormVisitor<R> visitor);

}
