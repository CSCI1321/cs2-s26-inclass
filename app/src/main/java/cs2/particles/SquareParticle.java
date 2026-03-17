package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;

public class SquareParticle extends Particle {
    public SquareParticle(Vec2 o, Vec2 v) {
        super(o,v);
    }

    public void displaySquare(GraphicsContext g) {
        g.setFill(col);
        g.fillRect(pos.x, pos.y, 20,20);
    }

}
