public class LevelTwo extends Level{
    public void summonAsteroid() {  //contains levelOne probability of summoning asteroid
        summonAsteroid(30, 2);
    }
    public void summonPower() { //if collide with smt, it will disappear
        summonPower(6);
    }
    public int getLvl() {
        return 2;
    }
}
