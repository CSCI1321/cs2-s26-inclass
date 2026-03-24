package cs2.particles;

import javafx.scene.canvas.GraphicsContext;

public class Background {
    protected ColorPattern col;
    public Background(ColorPattern cp) {
        col = cp;
    }
    public void display(GraphicsContext g) {
        g.setFill(col.getColor());
        g.fillRect(0,0,600,600);
    }
}
