package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.paint.Color;

public class RainbowParticle extends RoundParticle {
    public RainbowParticle(Vec2 p, Vec2 v) {
        super(p,v);
        col = Color.hsb(hue, 1, 1);
    }
    private double hue = 0;
    
    @Override
    public void timeStep() {
        super.timeStep();
        col = Color.hsb(hue, 1, 1);
        hue += 3;
    }


}
