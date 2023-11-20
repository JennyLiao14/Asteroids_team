public class AsteroidFactory {
    public static Asteroid getAsteroid(int lvl) {

        //need to randomly generate position and velocity btw
        if (lvl == 1) {
            System.out.println("very small asteroid");
            return new Asteroid(1);
        } else if (lvl == 2) {
            System.out.println("small asteroid");
            return new Asteroid(2);
        } else if (lvl == 3) {
            System.out.println("asteroid");
            return new Asteroid(3);
        }
        else {
            return null;
        }
    }

    public static Asteroid getAsteroid(int lvl, PVector pos, PVector v) {

        if (lvl == 1) {
            return new Asteroid(1, pos,v);
        } else if (lvl == 2) {

            return new Asteroid(2, pos, v);
        } else if (lvl == 3) {
            System.out.println("asteroid");
            return new Asteroid(3, pos, v);
        }
        else {
            return null;
        }
    }


}
