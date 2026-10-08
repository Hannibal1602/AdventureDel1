public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName, String longName, int health, Weapon weapon, Room room, String description) {
        this.shortName = shortName;
        this.longName = longName;
        this.health = health;
        this.weapon = weapon;
        this.room = room;
        this.description = description;

    }
    public String dropWeapon() {
        if (weapon == null) {
            return "";
        }
        Weapon dropped = weapon;
        room.addItem(dropped);
        weapon = null;
        return " It dropped " + dropped.getLongName() + ".";
    }

    public String getShortName() {
        return shortName;
    }

    public String getLongName() {
        return longName;
    }

    public int getHealth() {
        return health;
    }
    public int getDamage(){
        return weapon.getDamage();
    }

    public void hit(int damage) {
        health -= damage;
    }

    public String getDescription() {
        return description;
    }

    public Room getRoom() {
        return room;
    }
    public void attack(Player player){
        player.setHealth(player.getHealth() - weapon.getDamage());
    }
}

