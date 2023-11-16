public class Player extends Entity{
    public Player() {
        this.position= new Vector();
        this.velocity = new Vector();
        this.angle = 0;
    }
    public void updatePosFromV(double ChangeTime) {
        this.position.add(this.velocity.getX()*ChangeTime, this.velocity.getY()*ChangeTime);
    }

}
