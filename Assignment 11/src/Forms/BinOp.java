package Forms;

import java.util.function.BinaryOperator;

/**
 * @author Dennis den Hollander s4776658
 * @author Tom Kamp s4760921
 */
public enum BinOp implements BinaryOperator<Boolean> {
  AND("/\\") {
    @Override
    public Boolean apply(Boolean a1, Boolean a2) {
      return a1 && a2;
    }
  },
  OR("\\/") {
    @Override
    public Boolean apply(Boolean a1, Boolean a2) {
      return a1 || a2;
    }
  },
  IMPLIES("=>") {
    @Override
    public Boolean apply(Boolean a1, Boolean a2) {
      return !a1 || a2;
    }
  },
  IFF("<=>") {
    @Override
    public Boolean apply(Boolean a1, Boolean a2) {
      return (!a1 || a2) && (!a2 || a1);
    }
  };

  private final String string;

  private BinOp(String string) {
    this.string = string;
  }

  public String getBinOp() {
    return this.string;
  }
}
