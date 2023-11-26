import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject implements Collideable, Drawable{
    protected PVector position;



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
