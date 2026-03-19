package cs2.particles;

import cs2.util.Vec2;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

public class ImageParticle extends Particle {
    private static Image img = new Image("file:star.png");

    public ImageParticle(Vec2 p, Vec2 v) {
        super(p,v);
    }
    @Override
    public void display(GraphicsContext g) {
        g.setGlobalAlpha(0.2);
        g.drawImage(img, pos.x, pos.y, 40,40);
        g.setGlobalAlpha(1.0);
        
    }
}
