public class LevelGenerator {
    private int min;
    private int max;
    private int range;

    public LevelGenerator() {
        min = 1;
        max = 3;
        range = max-min+1;
    }
    public LevelGenerator(int min, int max) {
        this.min = min;
        this.max = max;
        range = this.max-this.min+1;
    }
    public int generateLvl() {
        return (int)(Math.random()*range)+min;
    }

}
