package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class Particle {
    protected Vec2 pos;
    protected Vec2 vel;
    protected Color col;

    public Particle(Vec2 p, Vec2 v) {
        pos = p;
        vel = v;
        col = Color.CHARTREUSE;
    }
    public abstract void display(GraphicsContext g);

    public void timeStep() {
        pos.addThis(vel);
    }
    public void addForce(Vec2 force) {
        vel.addThis(force);
    }
    
    
}
