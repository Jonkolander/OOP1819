package Assignment10;

/**
 *
 * @author pieterkoopman
 */
public enum Direction {
  Up(0, -1), Right(1, 0), Down(0, 1), Left(-1, 0);

  private final int dX, dY;

  private Direction(int dX, int dY) {
    this.dX = dX;
    this.dY = dY;
  }

  public int getdX() {
    return dX;
  }

  public int getdY() {
    return dY;
  }

}
