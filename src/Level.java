import java.util.ArrayList;

public abstract class Level {   //contains all the requirements each level must have (i,e entities)
    protected AsteroidGenerator asteroidGenerator;
    protected AsteroidFactory asteroidFactory;
    protected LevelGenerator levelGenerator;
    protected AsteroidDestroyer asteroidDestroyer;
    protected ArrayList<Entity> entity = new ArrayList<>();
}
