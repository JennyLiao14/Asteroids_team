public class PlayerFactory {
    public static Player getPlayer(int lvl) {
        if (lvl == 1) {
            System.out.println("normal Player");
            return new Player(1);
        } else if (lvl == 2) {
            System.out.println("STRONG PLAYER");
            return new Player(2);
        }
        else {
            return null;
        }
    }
}
