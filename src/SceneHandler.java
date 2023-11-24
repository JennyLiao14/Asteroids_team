import javafx.scene.canvas.GraphicsContext;

public class SceneHandler implements Drawable{     //changes scenes based on smt
    protected Player player;
    protected LvlHandler lvlHandler;
    protected Level level;


    public SceneHandler(int lvl) {
        lvlHandler = new LvlHandler(lvl);
        level = lvlHandler.getLevel();
        player = new Player(1, 400, 300 );

    }
    public void replaceAsteroid() {
        level.replaceAsteroid(0);
    }
    public void enhanceAsteroid() {
        level.enhanceAsteroid(0);
    }


    @Override
    public void draw(GraphicsContext pen) {
        level.summonAsteroid(15, level.getLvl());
        level.summonPower(3);
        level.draw(pen);
        player.drawBul(pen);
    }
    public void drawPlayer(GraphicsContext pen) {
        player.draw(pen);

        if(player.getPos().getX() >= 800) {
            player.setPos(-80, player.getPos().getY());
        }
        else if(player.getPos().getY() >= 600) {
            player.setPos(player.getPos().getX(), -80);
        }
        else if(player.getPos().getX() <= -80) {
            player.setPos(800, player.getPos().getY());
        }
        else if(player.getPos().getY() <= -80) {
            player.setPos(player.getPos().getX(), 600);
        }
        player.deccelerate();
    }
    public Player getPlayer() {
        return player;
    }
}
