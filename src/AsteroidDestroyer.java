public class AsteroidDestroyer {
    public Asteroid replaceAsteroid(int level, PVector pos) {
        PVector v = new PVector();
        v.setPos(Math.random()*0.5 + 0.1, Math.random()*0.5+0.1); //speed of asteroid

        Asteroid a = AsteroidFactory.getAsteroid(level - 1, pos, v);
        //randomly generate velocity
        return a;
    }
}
