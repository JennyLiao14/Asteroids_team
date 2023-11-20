public class AsteroidGenerator {
    private double probability;

    public boolean checkIfGenerate(double prob) {
        probability = prob;
        double temp = Math.random();
        if(temp < probability) {
            return true;
        }
        else  {
            return false;
        }
    }
}
