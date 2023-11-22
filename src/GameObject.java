import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject implements Collideable, Drawable, Moveable{
    protected PVector position;
    protected PVector velocity;
    protected double rotation;

    public abstract void draw(GraphicsContext pen);
}
