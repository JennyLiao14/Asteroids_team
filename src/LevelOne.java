import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;

public class LevelOne extends Level{        //contains all the information about a specific level, (i,e probability of generating things. Calls on certain generator to determine if anything is actually created)
    double probability;
    public LevelOne() { //creates level
        probability = 3;
        asteroidGenerator = new AsteroidGenerator();
        asteroidFactory = new AsteroidFactory();
        levelGenerator = new LevelGenerator();
        asteroidDestroyer = new AsteroidDestroyer();
    }
    public void summonAsteroid() {

        boolean generated = asteroidGenerator.checkIfGenerate(15);
        if(generated) {
            entity.add(asteroidFactory.getAsteroid(levelGenerator.generateLvl()));
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



    }


    public void replaceAsteroid(int index) { //if gun collide with asteroid return true, index of asteroid in array
            if(entity.get(index).getLevel() != 1) {
                entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
                entity.add(asteroidDestroyer.replaceAsteroid(entity.get(index).getLevel(), entity.get(index).getPos()));
            }
            entity.remove(index);
                    /*

            randomize velocity, etc.

                     */
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
            //spawn random small ones from it
        }
                    /*

            randomize velocity, etc.

                     */
    }
    }









