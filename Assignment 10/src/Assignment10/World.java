package Assignment10;

import java.util.Random;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Pane;

/**
 *
 * @author Sjaak Smetsers <s.smetsers@cs.ru.nl>
 */
public class World extends Pane {

  public static final int SIZE = 20;
  public static final int UNIT = 10;

  private final Snake snake;
  private final Food food;
  private boolean running = false;
  private final Random random = new Random();
  private final IntegerProperty score = new SimpleIntegerProperty();

  public World(StringProperty scoreText) {
    scoreText.bind(score.asString().concat(" points"));
    setPrefSize(SIZE * UNIT, SIZE * UNIT);
    snake = new Snake(1, 1, this);
    food = new Food();
    getChildren().add(food);
    moveFoodRandomly();
  }

  public boolean foundFoodAt(int x, int y) {
    return food.foundAt(x, y);
  }

  public void eatFood() {
    score.setValue(score.getValue() + 1);
    moveFoodRandomly();
  }

  public void stop() {
    running = false;
  }

  public void step() {
    if (running) {
      snake.moveOneStep();
    }
  }

  public boolean StartOrStop() {
    running = !running;
    return running;
  }

  private void moveFoodRandomly() {
    food.moveTo(random.nextInt(SIZE), random.nextInt(SIZE));
  }

  private int dist(int x, int y) {
    return x < y ? y - x : x - y;
  }

  public void redirectSnake(double paneX, double paneY) {
    int snakeX = snake.getX();
    int snakeY = snake.getY();

    int worldX = (int) paneX / UNIT;
    int worldY = (int) paneY / UNIT;

    if (dist(snakeX, worldX) > dist(snakeY, worldY)) {
      snake.setDirection(snakeX > worldX ? Direction.Left : Direction.Right);
    } else {
      snake.setDirection(snakeY > worldY ? Direction.Up : Direction.Down);
    }

  }
}
