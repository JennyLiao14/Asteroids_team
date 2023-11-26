import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class PowerUp extends GameObject{
    private final Image powerPicture;
    private final int size = 30;
    public PowerUp (double x, double y) {
        position = new PVector(x,y);

        powerPicture = new Image("file:src/Images/Icons_22.png"); //change
    }

    @Override
    public void draw(GraphicsContext pen) {
        pen.drawImage(powerPicture, position.getX(), position.getY(), size, size);
    }


    public PVector getPos() {
        return position;
    }

}
