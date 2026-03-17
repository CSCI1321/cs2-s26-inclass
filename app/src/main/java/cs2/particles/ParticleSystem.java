package cs2.particles;

import java.util.ArrayList;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;

public class ParticleSystem {
    private Vec2 origin;
    private ArrayList<Particle> parts;

    public ParticleSystem(Vec2 o) {
        origin = o;
        parts = new ArrayList<Particle>();
    }

    public void addParticle() {
        parts.add(new Particle(origin.clone(), Vec2.random()));
    }
    public void display(GraphicsContext g) {
        for(int i=0; i<parts.size(); i++) {
            parts.get(i).display(g);
        }
    }
    public void timeStep() {
        System.out.println(parts.size());
        for(Particle p : parts) {
            p.timeStep();
        }
    }

}
