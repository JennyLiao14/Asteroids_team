public abstract class GameObject implements Collideable, Drawable, Moveable {    //any object within the game
    protected PVector position;
    protected PVector velocity;
    protected double angle;
    @Override
    public void move(double ChangeTime) {       //moves object a certain distance based on its velocity
        position.add(velocity.getX()*ChangeTime, velocity.getY()*ChangeTime);
    }
    public void move(double x, double y) {

    }

}
