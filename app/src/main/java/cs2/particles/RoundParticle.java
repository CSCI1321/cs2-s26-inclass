package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;

public class RoundParticle extends Particle {
    public RoundParticle(Vec2 p, Vec2 v) {
        super(p,v);
    }
    @Override
    public void display(GraphicsContext g) {
        g.setFill(col);
        g.fillOval(pos.x, pos.y, 20,20);
    }

    public void print() {
        System.out.println("ACK!");
    }
    
}
