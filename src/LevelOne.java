import java.util.ArrayList;

public class LevelOne extends Level{        //contains all the information about a specific level, (i,e probability of generating things. Calls on certain generator to determine if anything is actually created)
    double probability;
    Player player;
    public LevelOne() { //creates level
        player = new Player();
        probability = 0.3;
    }
    public void summonAsteroid() {
        boolean generated = asteroidGenerator.checkIfGenerate(probability);
        if(generated) {
            entity.add(asteroidFactory.getAsteroid(levelGenerator.generateLvl()));
        }
    }


    public void replaceAsteroid(int index) { //if gun collide with asteroid return true, index of asteroid in array

            asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos());
            asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos());
            entity.remove(index);
                    /*

            randomize velocity, etc.

                     */
        }
    }




