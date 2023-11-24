public class LevelThree extends Level{      //has aliens
    public void summonAsteroid() {  //contains levelOne probability of summoning asteroid
        summonAsteroid(50, 3);
    }
    public void summonPower() { //if collide with smt, it will disappear
        summonPower(9);
    }
    public int getLvl() {
        return 3;
    }
}
