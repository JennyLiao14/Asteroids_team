public class LvlHandler {      //depending on user input, will "create" a certain level using the level Factory
    LvlFactory levelFactory = new LvlFactory();
    Level level;

    public LvlHandler(int lvl) {
        level = levelFactory.getLevel(lvl);
    }

    public Level getLevel() { //returns level obj
        return level;
    }



}
