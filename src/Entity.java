
import javafx.scene.canvas.GraphicsContext;
public abstract class Entity implements Collideable, Drawable, Moveable, Splittable{
    protected PVector position;
    protected PVector velocity;
    protected double rotation;
    protected int lvl;



    public abstract void move();
    public abstract void draw(GraphicsContext pen);

}
