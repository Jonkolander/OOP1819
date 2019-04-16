/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment09;

import java.text.DecimalFormat;
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
 * @author Dennis den Hollander (s4776658)
 */
public class Assignment09 extends Application {
  
  private IntegerProperty sum = new SimpleIntegerProperty();
  private final IntegerProperty value1 = new SimpleIntegerProperty(1);
  private final IntegerProperty value2 = new SimpleIntegerProperty(1);
  private final IntegerProperty value3 = new SimpleIntegerProperty(1);
  private final IntegerProperty value4 = new SimpleIntegerProperty(1);

  private final DoubleProperty outval1 = new SimpleDoubleProperty();
  private final DoubleProperty outval2 = new SimpleDoubleProperty();
  private final DoubleProperty outval3 = new SimpleDoubleProperty();
  private final DoubleProperty outval4 = new SimpleDoubleProperty();

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
        if (!newValue.matches("[1 -9]\\d{0,3}")) {
          textField1.setText(oldValue);
        }
    });
    
    TextField textField2 = new TextField();
    textField2.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1 -9]\\d{0,3}")) {
          textField1.setText(oldValue);
        }
    });
    
    TextField textField3 = new TextField();
    textField3.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1 -9]\\d{0,3}")) {
          textField1.setText(oldValue);
        }
    });
    
    TextField textField4 = new TextField();
    textField4.textProperty().addListener((
      ObservableValue<? extends String> observable, 
      String oldValue, String newValue) -> {
        if (!newValue.matches("[1 -9]\\d{0,3}")) {
          textField1.setText(oldValue);
        }
    });

    Label A = new Label();
    Label B = new Label();
    Label C = new Label();
    Label D = new Label();

    // Add a fixed number of TextFields
    textField1.textProperty().bindBidirectional(value1, new NumberStringConverter());
    IntegerProperty tempsum1 = new SimpleIntegerProperty();
    tempsum1.bind(value1);

    textField2.textProperty().bindBidirectional(value2, new NumberStringConverter());
    IntegerProperty tempsum2 = new SimpleIntegerProperty();
    tempsum2.bind(tempsum1.add(value2));

    textField3.textProperty().bindBidirectional(value3, new NumberStringConverter());
    IntegerProperty tempsum3 = new SimpleIntegerProperty();
    tempsum3.bind(tempsum2.add(value3));

    textField4.textProperty().bindBidirectional(value4, new NumberStringConverter());
    IntegerProperty tempsum4 = new SimpleIntegerProperty();
    tempsum4.bind(tempsum3.add(value4));

    sum = new SimpleIntegerProperty(75);

    outval1.bind(value1.add(0f).divide(sum));
    outval2.bind(value2.add(0f).divide(sum));
    outval3.bind(value3.add(0f).divide(sum));
    outval4.bind(value4.add(0f).divide(sum));
    
    DecimalFormat df = new DecimalFormat("#.0000");
    
    A.textProperty().bind(outval1.asString());
    B.textProperty().bind(outval2.asString());
    C.textProperty().bind(outval3.asString());
    D.textProperty().bind(outval4.asString());

    root.add(textField1, 0, 0);
    root.add(textField2, 0, 1);
    root.add(textField3, 0, 2);
    root.add(textField4, 0, 3);

    root.add(A, 1, 0);
    root.add(B, 1, 1);
    root.add(C, 1, 2);
    root.add(D, 1, 3);

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
