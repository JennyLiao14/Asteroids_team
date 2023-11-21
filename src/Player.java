public class Player extends Entity{
    public Player() {
        this.position= new PVector();
        this.velocity = new PVector();
        this.rotation = 0;
        lvl = 1;


    }
    public Player(int level) {
        this.position= new PVector();
        this.velocity = new PVector();
        this.rotation = 0;
        lvl = level;

    }
    public Player(int level, PVector pos) {
        this.position= pos;
        this.velocity = new PVector(5, 5);
        this.rotation = 0;
        lvl = level;

    }
    public void accelerate() {

        if(velocity.getSize() <= 15) {
            velocity.setSize(velocity.getSize()+0.05);
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
    public void turnRight() {
        rotation += 5;
    }
    public void turnLeft() {
        rotation -= 5;
    }
    public double getRotation() {
        return rotation;
    }


    @Override
    public void move() {

        position.add(velocity.getX(), velocity.getY());
    }

    @Override
    public int getLevel() {
        return lvl;
    }

    @Override
    public PVector getPos() {
        return position;
    }
}
