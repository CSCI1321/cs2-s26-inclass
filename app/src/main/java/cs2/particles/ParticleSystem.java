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
        parts.add(new RainbowParticle(origin.clone(), Vec2.random()));
        
        //parts.add(new ImageParticle(origin.clone(), Vec2.random()));
        
        /* 
        if(Math.random() < 0.5) 
            parts.add(new SquareParticle(origin.clone(), Vec2.random()));
        else {
            Particle rp = new RoundParticle(origin.clone(), Vec2.random());
            parts.add(rp);
        }*/
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
    public void addForce(Vec2 force) {
        for(Particle p : parts) p.addForce(force);
    }

}
