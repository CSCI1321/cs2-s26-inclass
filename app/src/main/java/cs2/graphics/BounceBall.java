package cs2.graphics;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BounceBall extends Application{
    public void start(Stage primary) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        primary.setTitle("Bounce Ball");
        primary.setScene(scene);
        GraphicsContext g = canvas.getGraphicsContext2D();
        
        primary.show();

        
        AnimationTimer timer = new AnimationTimer() {
            double x = 100;
            double velX = 4;
            double y = 100;
            double velY = (Math.random() * 4) - 2;
            public void handle(long t) {
                g.setFill(Color.WHITE);
                g.fillRect(0,0, canvas.getWidth(),canvas.getHeight());
                g.setFill(Color.RED);
                g.fillOval(x,y, 100,100);
                x += velX;
                y += velY;
                if(x < 0 || x+100 > canvas.getWidth()) {
                    velX = -velX;
                }
                if(y < 0 || y+100 > canvas.getHeight()) {
                    velY = -velY;
                }
            }
        };
        timer.start();
        

    }
    
}
