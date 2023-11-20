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
    public void accelerate() {
        if(velocity.getSize() <= 2.5) {
            velocity.setSize(velocity.getSize()+0.05);
        }
        else{
            velocity.setSize(velocity.getSize());
        }
        velocity.setAngle(rotation);
    }
    public void deccelerate() {
        velocity.setSize(velocity.getSize()-0.01);
    }
    public void turnRight() {
        rotation += 1;
    }
    public void turnLeft() {
        rotation -= 1;
    }


    @Override
    public void move() {

        System.out.println("moving person testing");
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
