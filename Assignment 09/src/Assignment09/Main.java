package Assignment09;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

/**
 *
 * @author Dennis den Hollander | s4776658
 * @author Tom Kamp             | s4760921
 */
public class Main extends Application {
 
  @Override
  public void start(Stage primaryStage) {
    GridPane root = new GridPane();
    root.setAlignment(Pos.CENTER);
    root.setHgap(20);
    root.setVgap(10);

    TextField textField1 = new TextField();
    textField1.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1-9]\\d{0,3}")) {
          textField1.setText(oldValue);
        }
    });
    
    TextField textField2 = new TextField();
    textField2.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1-9]\\d{0,3}")) {
          textField2.setText(oldValue);
        }
    });
    
    TextField textField3 = new TextField();
    textField3.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1-9]\\d{0,3}")) {
          textField3.setText(oldValue);
        }
    });
    
    TextField textField4 = new TextField();
    textField4.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1-9]\\d{0,3}")) {
          textField4.setText(oldValue);
        }
    });
    
    IntegerProperty sum = new SimpleIntegerProperty(); 
    IntegerProperty value1 = new SimpleIntegerProperty(10);
    IntegerProperty value2 = new SimpleIntegerProperty(10);
    IntegerProperty value3 = new SimpleIntegerProperty(10);
    IntegerProperty value4 = new SimpleIntegerProperty(10);
    
    DoubleProperty outval1 = new SimpleDoubleProperty();
    DoubleProperty outval2 = new SimpleDoubleProperty();
    DoubleProperty outval3 = new SimpleDoubleProperty();
    DoubleProperty outval4 = new SimpleDoubleProperty();
  
    Label output1 = new Label();
    Label output2 = new Label();
    Label output3 = new Label();
    Label output4 = new Label();
    
    textField1.textProperty().bindBidirectional(value1, new NumberStringConverter());
    textField2.textProperty().bindBidirectional(value2, new NumberStringConverter());
    textField3.textProperty().bindBidirectional(value3, new NumberStringConverter());
    textField4.textProperty().bindBidirectional(value4, new NumberStringConverter());

    IntegerProperty partial_sum1 = new SimpleIntegerProperty(); 
    partial_sum1.bind(value2.add(value1));
    IntegerProperty partial_sum2 = new SimpleIntegerProperty(); 
    partial_sum2.bind(partial_sum1.add(value3));
    
    sum.bind(partial_sum2.add(value4));
    
    outval1.bind(value1.add(0f).divide(sum));
    outval2.bind(value2.add(0f).divide(sum));
    outval3.bind(value3.add(0f).divide(sum));
    outval4.bind(value4.add(0f).divide(sum));
    
    output1.textProperty().bind(outval1.asString("%.4f"));
    output2.textProperty().bind(outval2.asString("%.4f"));
    output3.textProperty().bind(outval3.asString("%.4f"));
    output4.textProperty().bind(outval4.asString("%.4f"));
    
    root.add(textField1, 0, 0);
    root.add(textField2, 0, 1);
    root.add(textField3, 0, 2);
    root.add(textField4, 0, 3);

    root.add(output1, 1, 0);
    root.add(output2, 1, 1);
    root.add(output3, 1, 2);
    root.add(output4, 1, 3);
    
    Scene scene = new Scene(root, 300, 250);

    primaryStage.setTitle("Pie Chart Generator");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    launch(args);
  }

}
