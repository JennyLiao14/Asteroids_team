import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
public class Player extends Entity{
    private ArrayList<Bullet> b;
    private Image user;
    public Player() {
        this.position= new PVector();
        this.velocity = new PVector();
        this.rotation = 0;
        lvl = 1;
        b = new ArrayList<>();
        user = new Image("file:src/Images/spaceship.png");

    }
    public Player(int level) {
        this.position= new PVector();
        this.velocity = new PVector();
        this.rotation = 0;
        lvl = level;
        b = new ArrayList<Bullet>();
        user = new Image("file:src/Images/spaceship.png");

    }
    public Player(int level, PVector pos) {
        this.position= pos;
        this.velocity = new PVector(0, 0);
        this.rotation = 0;
        lvl = level;
        b = new ArrayList<Bullet>();
        user = new Image("file:src/Images/spaceship.png");

    }
    public Player(int level, double x, double y) {
        this.position= new PVector(x, y);
        this.velocity = new PVector(0, 0);
        this.rotation = 0;
        lvl = level;
        b = new ArrayList<Bullet>();
        user = new Image("file:src/Images/spaceship.png");

    }
    public void accelerate() {

        if(velocity.getSize() <= 5) {
            velocity.setSize(velocity.getSize()+0.5);
        }
        else{
            velocity.setSize(velocity.getSize());
        }
        velocity.setAngle(rotation);
        rotation = velocity.getAngle();     //testing


    }
    public void deccelerate() {
        velocity.setSize(velocity.getSize()-0.01);
    }
    public void shoot() {
        Bullet temp = new Bullet(this.rotation, this.position.getX(), this.position.getY());
        b.add(temp);

    }
    public void turnRight() {
        rotation += 10;
    }
    public void turnLeft() {
        rotation -= 10;
    }
    public double getRotation() {
        return rotation;
    }


    @Override
    public void move() {

        position.add(velocity.getX(), velocity.getY());
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
        }
    }
    public void draw(GraphicsContext pen) {
        move();
        pen.drawImage(user, -100 / 2, -100 / 2, 100, 100);

    }
    public void drawBul(GraphicsContext pen) {
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
            b.get(i).draw(pen);
        }
    }

    @Override
    public int getLevel() {
        return lvl;
    }

    @Override
    public PVector getPos() {
        return position;
    }

    @Override
    public double getAngle() {
        return rotation;
    }

    public void setPos(double x, double y) {
        position = new PVector(x, y);

    }
}
