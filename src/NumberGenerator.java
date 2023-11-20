public class NumberGenerator {
    public int randomInt(int min, int max) {
        int range = max-min+1;
        return (int)(Math.random()*range)+min;
    }
    public double randomDouble(double min, double max) {
        double range = max-min+1;
        return (Math.random()*range)+min;
    }
}
