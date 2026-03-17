package cs2.particles;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ParticleSystemApp extends Application {
    public void start(Stage primary) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        primary.setScene(scene);
        primary.setTitle("Particles!");

        GraphicsContext g = canvas.getGraphicsContext2D();
        primary.show();

        ArrayList<ParticleSystem> plist = new ArrayList<>();
        
        canvas.setOnMousePressed((MouseEvent e) -> {
            plist.add(new ParticleSystem(new Vec2(e.getX(),e.getY())));
        });
        
        AnimationTimer timer = new AnimationTimer() {
            public void handle(long t) {
                g.setFill(Color.WHITE);
                g.fillRect(0,0, 600,600);

                for(ParticleSystem p : plist) {
                    p.addParticle();
                    p.display(g);
                    p.timeStep();
                }
            }
        };
        timer.start();
    }
}
