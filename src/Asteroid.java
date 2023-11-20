public class Asteroid extends Entity{
    public Asteroid(int level) {
        this.lvl = level;
    }
    @Override
    public void move() {
        System.out.println("moving asteroid testing");
    }
}
