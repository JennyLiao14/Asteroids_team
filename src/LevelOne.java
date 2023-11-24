import javafx.scene.canvas.GraphicsContext;
public class LevelOne extends Level{        //contains all the information about a specific level, (i,e probability of generating things.)
    public void summonAsteroid() {  //contains levelOne probability of summoning asteroid
        summonAsteroid(15, 1);
    }
    public void summonPower() { //if collide with smt, it will disappear
        summonPower(3);
    }

}