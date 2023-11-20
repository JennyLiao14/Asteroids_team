public class Asteroid extends Entity{
    public Asteroid(int level) {
        this.lvl = level;
    }
    public Asteroid(int level, PVector pos) {
        this.lvl = level;
        position = pos;
    }
    public Asteroid(int level, PVector pos, PVector v) {
        this.lvl = level;
        position = pos;
        velocity = v;
    }
    @Override
    public void move() {
        System.out.println("moving asteroid testing");
    }
    public int getLevel() {
        return lvl;
    }
    public PVector getPos() {
        return position;
    }
    public void setPos(double x, double y) {
        position.setPos(x, y);

    }
}
