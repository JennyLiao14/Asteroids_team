public class AsteroidFactory {
    public static Asteroid getAsteroid(int lvl) {
        if (lvl == 1) {
            System.out.println("very small asteroid");
            return new Asteroid(1);
        } else if (lvl == 2) {
            System.out.println("small asteroid");
            return new Asteroid(2);
        } else if (lvl == 3) {
            System.out.println("asteroid");
            return new Asteroid(3);
        } else if (lvl == 4) {
            System.out.println("big asteroid");
            return new Asteroid(4);
        }
        else {
            return null;
        }
    }

}
