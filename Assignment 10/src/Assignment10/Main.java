package Assignment10;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * The user scores a point if the snake eats food. 
 * The snake is attracted by the position of the mouse. 
 * The snake dies if it hits the wall or its own tail.
 *
 * @author pieterkoopman
 * @author Dennis den Hollander (s4776658)
 * @author Tom Kamp (s4760921)
 */
public class Main extends Application {

  public final static int DELAY = 300; // timer delay in ms

  private double goalX = (World.SIZE * World.UNIT) / 2, goalY = (World.SIZE * World.UNIT) / 2;

  @Override
  public void start(Stage primaryStage) {
    BorderPane root = new BorderPane();
    VBox textPane = new VBox();
    Label runningText = new Label("Press 's' to start");
    Label scoreText = new Label("0 points");
    textPane.getChildren().addAll(runningText, scoreText);

    World world = new World(scoreText.textProperty());
    root.setRight(textPane);
    root.setLeft(world);
    Scene scene = new Scene(root);

    Timeline timeline = new Timeline(
      new KeyFrame(
        Duration.millis(DELAY), 
        (ActionEvent event) -> world.step()
      )
    );
    
    timeline.setCycleCount(Timeline.INDEFINITE);

    scene.setOnKeyPressed(event -> {
      if (event.getCode() == KeyCode.S) {
        if (world.StartOrStop()) {
          timeline.play();
          runningText.textProperty().set("Running");
        } else {
          timeline.pause();
          runningText.textProperty().set("Stopped");
        }
      }
    });

    scene.setOnMouseMoved((MouseEvent e) -> world.redirectSnake(e.getX(), e.getY()));

    primaryStage.setTitle("Snake");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
