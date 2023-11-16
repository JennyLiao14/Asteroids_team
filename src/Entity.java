
public abstract class Entity {
    protected Vector position;
    protected Vector velocity;
    protected double angle;

    public void move(double x, double y) {
        position.add(x, y);
    }

}
