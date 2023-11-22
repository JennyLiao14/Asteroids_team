public class PowerFactory {
    public static PowerUp getPower() {
            double xPos = Math.random()*800 ;
            double yPos = Math.random()* 600 ;
            double angle = Math.random()*360;
            return new PowerUp(xPos, yPos, angle);

    }
}
