package cs2.util;

public class Vec2 {
    public double x;
    public double y;
    public Vec2(double xx, double yy) {
        x = xx; y = yy;
    }
    public Vec2() {
        x = 0; y = 0;
    }
    public static Vec2 random() {
        Vec2 v = new Vec2();
        v.x = (Math.random() * 2) - 1;
        v.y = (Math.random() * 2) - 1;
        return v;
    }
    public Vec2 add(Vec2 other) {
        return new Vec2(this.x + other.x, this.y + other.y);
    }
    public void addThis(Vec2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public Vec2 clone() {
        return new Vec2(this.x, this.y);
    }

}
