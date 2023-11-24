import javafx.scene.canvas.GraphicsContext;

public abstract class GameObject implements Collideable, Drawable{
    protected PVector position;


    public abstract void draw(GraphicsContext pen);
}
