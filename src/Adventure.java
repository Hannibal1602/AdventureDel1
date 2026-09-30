public class Adventure {

    private GameMap map = new GameMap();
    private Player player = new Player();

    public Adventure() {
        player.setCurrentRoom(map.buildMap());
    }

    public boolean go(String direction) {
        return player.move(direction);
    }

    public String look() {
        return player.look();
    }

    public String inventory() {
        return player.describeInventory();
    }

    public String take(String shortName) {
        Item item = player.takeItem(shortName);
        if (item == null) {
            return null;
        }
        return item.getLongName();
    }

    public String drop(String shortName) {
        Item item = player.dropItem(shortName);
        if (item == null) {
            return null;
        }
        return item.getLongName();
    }

    public EatResult eat(String shortName) {
        return player.eat(shortName);
    }

    public int getHealth(){
        return player.getHealth();
    }

}