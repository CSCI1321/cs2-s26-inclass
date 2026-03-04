package cs2.graphics;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class FXTests extends Application {
    double oldX = 0;
    double oldY = 0;
    
    public void start(Stage primary) {
        Canvas canvas = new Canvas(600,600);
        Scene scene = new Scene(new StackPane(canvas));
        primary.setTitle("My Graphics Window");
        primary.setScene(scene);
        primary.show();

        GraphicsContext g = canvas.getGraphicsContext2D();

        /*
        g.fillOval(150,150, 300,300);
        g.fillOval(150,350, 300,300);
        g.fillRect(150,300, 300,200);

        g.setFill(Color.WHITE);
        g.fillArc(150,150,300,300, 180,180, ArcType.ROUND);
        g.fillArc(150,225, 150,150, 0,180, ArcType.ROUND);
        g.fillArc(300,225, 150,150, 0,180, ArcType.ROUND);

        g.setFill(Color.BLACK);
        g.fillOval(200,275, 40,40);
        g.fillOval(350,275, 40,40);

        double[] xs = {300,320,300,280};
        double[] ys = {300,320,340,320};
        g.fillPolygon(xs, ys, 4);

        g.setFill(Color.WHITE);
        g.fillText("wat?", 300,500);

        g.setStroke(Color.BLACK);
        g.setLineWidth(2);
        for(int x=0; x<600; x+=1) {
            g.setStroke(Color.rgb(x*255/600,0,x*255/600));
            g.strokeLine(x,0 ,x,800 );
        }
        */

        
        canvas.setOnMouseDragged((MouseEvent e) -> {
            g.strokeLine(e.getX(), e.getY(), oldX, oldY);
            oldX = e.getX();
            oldY = e.getY();
        });

        canvas.requestFocus();
        canvas.setOnKeyPressed((KeyEvent e) -> {
            if(e.getCode() == KeyCode.SPACE) {
                g.setFill(Color.WHITE);
                g.fillRect(0,0, 600,600);
            } 
        });



        /*
        g.strokeRect(250,50, 100,50);
        g.setFill(Color.AQUAMARINE);
        g.setFill(Color.rgb(13, 105, 67));
        g.fillOval(250,50, 100,50);
        g.setStroke(Color.RED);
        g.setLineWidth(20);
        g.strokeLine(0,0, 600,400);
        g.strokeText("HEllo!", 250,50);

        double[] xs = {100, 200, 350, 150};
        double[] ys = {100, 100, 50, 250};
        g.strokePolygon(xs, ys, 3);
        
        g.setLineWidth(2);
        g.setStroke(Color.BLACK);
        g.fillArc(200,100, 200,100, 0,270, ArcType.ROUND);
        */
        //drawCircle(g, 300, 200, 100);

    }

    public static void drawCircle(GraphicsContext g, double x, double y, double r) {
        g.strokeOval(x-r,y-r, r*2,r*2);
        if(r > 2) {
            drawCircle(g,x-r,y,r/2);
            drawCircle(g,x+r,y,r/2);
            drawCircle(g,x,y-r,r/2);
        }
    }


}
