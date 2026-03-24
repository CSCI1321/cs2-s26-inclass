package cs2.particles;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ParticleSystemApp extends Application {
    Vec2 wind = new Vec2();
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
        canvas.setOnMouseMoved((MouseEvent e) -> {
            wind = new Vec2(e.getX() / 600 * 2 -1,0);
        });
        
        Background bg = new Background(new RainbowColor());//new SolidColor(Color.BLACK));

        AnimationTimer timer = new AnimationTimer() {
            public void handle(long t) {
                // g.setFill(Color.WHITE);
                // g.fillRect(0,0, 600,600);
                bg.display(g);
                for(ParticleSystem p : plist) {
                    p.addParticle();
                    p.display(g);
                    p.timeStep();
                    p.addForce(new Vec2(0,0.1));
                    p.addForce(wind);
                }
            }
        };
        timer.start();

        Image img = new Image("file:star.png");
        System.out.println(img.getHeight());
        g.drawImage(img, 0, 0, 80, 80);


    }
}
