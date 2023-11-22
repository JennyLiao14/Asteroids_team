public class AsteroidGenerator {
    private double probability;

    public boolean checkIfGenerate(double prob) {
        probability = prob;
        double temp = Math.random()*1000+1;
        if(temp < probability) {
            return true;
        }
        else  {
            return false;
        }
    }
}
