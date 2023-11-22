import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class PowerUp extends GameObject{
    private final Image powerPicture;
    public PowerUp (double x, double y, double angle) {
        position = new PVector(x,y);
        velocity = new PVector();
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        powerPicture = new Image("file:src/Images/Icons_22.png"); //change
    }

    @Override
    public void draw(GraphicsContext pen) {
        pen.drawImage(powerPicture, position.getX(), position.getY(), 100, 100);
    }


    @Override
    public PVector getPos() {
        return null;
    }

    @Override
    public double getAngle() {
        return 0;
    }

    @Override
    public void move() {

            position.add(velocity.getX(), velocity.getY());

    }
}
