import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;
public class Asteroid extends Entity{

    private Image asteroidPicture;
    public Asteroid(int level) {
        this.lvl = level;
        position = new PVector(0, 0);
        velocity = new PVector(0, 0);
        if(level == 1) {
            asteroidPicture = new Image("file:src/Images/Icons_22.png");
        }
        else if(level == 2) {
            asteroidPicture = new Image("file:src/Images/Icons_23.png");
        }
        else if(level == 3) {
            asteroidPicture = new Image("file:src/Images/Icons_24.png");
        }

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
    public Asteroid(int level, double x, double y, double angle) {
        this.lvl = level;
        position = new PVector(x,y);
        velocity = new PVector();
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        if(level == 1) {
            asteroidPicture = new Image("file:src/Images/Icons_22.png");
        }
        else if(level == 2) {
            asteroidPicture = new Image("file:src/Images/Icons_23.png");
        }
        else if(level == 3) {
            asteroidPicture = new Image("file:src/Images/Icons_24.png");
        }
        System.out.println(velocity.getX() + " - " + velocity.getY());

    }
    @Override
    public void move() {
            position.add(velocity.getX(), velocity.getY());
    }

    @Override


    public int getLevel() {
        return lvl;
    }
    public PVector getPos() {
        return position;
    }
    public double getAngle() {

        return velocity.getAngle();

    }



    public void draw(GraphicsContext pen) {
        pen.drawImage(asteroidPicture, position.getX(), position.getY(), 100, 100);

    }

}
