public class Vector {
    private double x;       //tracks xPos
    private double y;       //tracks yPos
    public Vector() {       //initial Vector position is 0, 0
        this.setPos(0, 0);
    }
    public Vector(double xPos, double yPos) {       //set position of object when created
        this.setPos(xPos, yPos);
    }
    public void setPos(double xPos, double yPos) {  //set position when needed
        x = xPos;
        y = yPos;
    }
    public void add(double xAdd, double yAdd) {     //when moving at constant velocity in some direction
        x += xAdd;
        y += yAdd;
    }
    public void mult(double xyMul) {                //moving at constant acceleration at xyMul
        x *= xyMul;
        y *= xyMul;
    }
    public double getSize() {                        //returns size of vector based on xpos and ypos using pythagorean
        return Math.sqrt(x*x + y*y);
    }
    public void setSize(double S) {
        double currentSize = this.getSize();
        if(currentSize==0) {        //check if vector is 0
            return;
        }
        else{
            this.mult(1/currentSize);       //handles if previous vector exists
            this.mult(S);                          //changes vector size
        }
    }
    public double getAngle() {
        return Math.toDegrees(Math.atan2(this.y, this.x));      //diff format so that signs don't cancel out
    }
    public void setAngle(double angle) {      //angle in deg  //find new values of x and y, given fixed value of size
        double size = this.getSize();
        double angleinRad = Math.toRadians(angle);
        this.x = size * Math.cos(angle);
        this.y = size * Math.sin(angle);
    }
    public double getX() {
        return x;

    }
    public double getY() {
        return y;

    }

}
