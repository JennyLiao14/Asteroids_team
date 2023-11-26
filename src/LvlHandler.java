import javafx.scene.canvas.GraphicsContext;
public class LvlHandler implements Drawable{      //depending on user input, will "create" a certain level using the level Factory
    LvlFactory levelFactory = new LvlFactory();
    Level level;
    protected Player player;



    public LvlHandler(int lvl) {
        level = levelFactory.getLevel(lvl);
        player = new Player(1, 400, 300 );
    }

    public Level getLevel() { //returns level obj
        return level;
    }

    public void replaceAsteroid() {
        level.replaceAsteroid(0);
    }       //need index of collided/enhanced asteroid
    public void enhanceAsteroid() {
        level.enhanceAsteroid(0);
    }
    @Override
    public void draw(GraphicsContext pen) {
        level.summonAsteroid(level.getProbAsteroid(), level.getLvl());
        level.summonPower(level.getProbPower());
        level.summonAlien(level.getProbAlien());
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
        level.setPlayerPos(player.getPos().getX(), player.getPos().getY());
    }


    public Player getPlayer() {
        return player;
    }

}
