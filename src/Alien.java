import javafx.scene.image.Image;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class Alien extends Entity{
    private ArrayList<Bullet> b;

    private Image alienPicture;
    public Alien(double x, double y, double angle) {
        position = new PVector(x, y);
        velocity = new PVector(0, 0);
        alienPicture = new Image("file:src/Images/Icons_22.png");
        velocity.setSize(Math.random()*3+0.5);
        velocity.setAngle(angle);
        b = new ArrayList<>();


    }
    public void shoot(double xPlayer, double yPlayer) { //takes player position
        double a = Math.atan2(yPlayer-position.getY(), xPlayer-position.getX());
        double temp2 = Math.toDegrees(a);
        Bullet temp = new Bullet(0, this.position.getX(), this.position.getY());
        temp.setRotation(temp2);
        b.add(temp);

    }
    @Override
    public void move() {
        position.add(velocity.getX(), velocity.getY());
    }
    public PVector getPos() {
        return position;
    }
    public double getAngle() {
        return velocity.getAngle();

    }
    public void setAngle(double a) {
        velocity.setAngle(a);
        rotation = a;

    }
    public void draw(GraphicsContext pen) {
        pen.drawImage(alienPicture, position.getX(), position.getY(), 50, 50);
        for(int i = 0; i < b.size(); i++) {
            b.get(i).move();
            b.get(i).draw(pen);
        }
    }

    @Override
    public int getLevel() {
        return 1;
    }
}
