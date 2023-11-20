public class LvlHandler {      //depending on user input, will "create" a certain level using the level Factory
    LvlFactory levelFactory = new LvlFactory();
    public Level createLvl(int level) {
        return levelFactory.getLevel(level);
    }
}
