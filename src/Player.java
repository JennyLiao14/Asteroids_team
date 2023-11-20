public class Player extends Entity{
    public Player() {
        this.position= new PVector();
        this.velocity = new PVector();
        this.angle = 0;
        lvl = 1;

    }
    public Player(int level) {
        this.position= new PVector();
        this.velocity = new PVector();
        this.angle = 0;
        lvl = level;

    }


    @Override
    public void move() {
        System.out.println("moving person testing");
    }
}
