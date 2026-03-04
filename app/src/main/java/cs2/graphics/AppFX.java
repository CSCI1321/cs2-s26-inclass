package cs2.graphics;

import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class AppFX extends Application {
  @Override
  public void start(javafx.stage.Stage primaryStage) {
    Canvas canvas = new Canvas(400, 200);
    javafx.scene.Scene scene = new javafx.scene.Scene(new StackPane(canvas));
    primaryStage.setScene(scene);
    GraphicsContext g = canvas.getGraphicsContext2D();
    g.setFill(Color.LIGHTBLUE);
    g.fillRect(0,0,400,200);
    g.setFill(Color.BLACK);
    g.fillText("Hello, JavaFX!", 150, 100);
    g.strokeLine(0,150, 400,150);
    primaryStage.show();
  }
}
