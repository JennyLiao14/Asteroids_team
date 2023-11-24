import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public abstract class Level {   //contains all the requirements each level must have (i,e entities)
    protected AsteroidGenerator asteroidGenerator = new AsteroidGenerator();
    protected AsteroidFactory asteroidFactory = new AsteroidFactory(); // could change to entity factory
    protected LevelGenerator levelGenerator = new LevelGenerator();
    protected AsteroidDestroyer asteroidDestroyer = new AsteroidDestroyer();
    protected ArrayList<Entity> entity = new ArrayList<>();
    protected ArrayList<PowerUp>  powers = new ArrayList<>();
    protected PowerFactory powerFactory = new PowerFactory();
    protected PowerUpGenerator powerUpGenerator =  new PowerUpGenerator();


    public void summonAsteroid(int prob, int lvl) {

        boolean generated = asteroidGenerator.checkIfGenerate(prob);
        if(generated) {
            entity.add(asteroidFactory.getAsteroid(levelGenerator.generateLvl(lvl)));
        }
    }
    public void summonPower(int prob) { //if collide with smt, it will disappear

        boolean generated = powerUpGenerator.checkIfGenerate(prob);
        if(generated) {
            powers.add(powerFactory.getPower());
        }
    }
    public void replaceAsteroid(int index) { //if gun collide with asteroid return true, index of asteroid in array
        if(entity.get(index).getLevel() != 1) {
            entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
            entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
        }
        entity.remove(index);
    }
    public void enhanceAsteroid(int index) { //if gun collide with asteroid return true, index of asteroid in array
        if(entity.get(index).getLevel() != 3) {
            entity.add(asteroidDestroyer.enhanceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos(), entity.get(index).getAngle()));
            entity.remove(index);
        }
        else {
            int counter = 0;
            while (counter < 3) {
                entity.add(asteroidFactory.getAsteroid(entity.get(index).getPos().getX(), entity.get(index).getPos().getY()));
                counter++;
            }
        }
    }
    public void draw(GraphicsContext pen) {
        for(int i = 0; i < entity.size(); i++) {
            entity.get(i).move();
            entity.get(i).draw(pen);
            if(entity.get(i).getPos().getX() >= 1200 || entity.get(i).getPos().getY() >= 1000 || entity.get(i).getPos().getX() <= -400 || entity.get(i).getPos().getY() <= -400) {
                entity.remove(i);
            }
        }
        for(int i = 0; i < powers.size(); i++) {
            powers.get(i).draw(pen);
        }
    }
    public int getLvl() {
        return 1;
    }
}
