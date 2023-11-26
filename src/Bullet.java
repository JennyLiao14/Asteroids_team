import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Bullet implements Moveable{
    private PVector pos;
    private PVector velocity;
    private double rotation;
    private Image b;
    public Bullet(double rot, double x, double y) {

        b = new Image("images/spaceship.png");
        pos = new PVector(x, y);
        velocity = new PVector();
        velocity.setSize(2);
        rotation = rot;
        velocity.setAngle(rotation);


    }
    public Bullet() {

        b = new Image("images/spaceship.png");
        pos = new PVector(0, 0);
        velocity = new PVector();
        velocity.setSize(2);
        System.out.println("x " + pos.getX());
        System.out.println("y " +pos.getY());

    }
    @Override
    public PVector getPos() {
        return pos;
    }

    @Override
    public double getAngle() {
        return rotation;
    }

    public void draw(GraphicsContext pen) {
        pen.drawImage(b, pos.getX(), pos.getY(), 20, 20);

    }
    public void move() {
        pos.add(velocity.getX(), velocity.getY());
    }
    public void setRotation(double r) {
        rotation = r;
        velocity.setAngle(rotation);
    }
}
