
import javafx.scene.canvas.GraphicsContext;
public abstract class Entity implements Collideable, Drawable, Moveable, Splittable{
    protected PVector position;
    protected PVector velocity;
    protected double rotation;
    protected int lvl;



    public abstract void move();
    public abstract void draw(GraphicsContext pen);
    @Override
    public boolean isColliding(Collideable other) {
        return false;
    }

    @Override
    public int getCollisionType(Collideable other) {
        return 0;
    }

    @Override
    public void handleCollision(int collisionType) {

    }

    @Override
    public PVector getPosition() {
        return null;
    }

    @Override
    public double getCollisionRadius() {
        return 0;
    }

}
