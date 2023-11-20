public class EntityFactory {        //not making stuff
    public static Entity getEntity(String entityName, int level) {
        if(entityName.equals("Player")) {
            return PlayerFactory.getPlayer(level);
        }
        else if(entityName.equals("Asteroid")) {
            return AsteroidFactory.getAsteroid(level);
        }


        else {
            return AsteroidFactory.getAsteroid(level);
        }
    }
}
