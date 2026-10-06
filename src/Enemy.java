public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;
    private Room room;

    public Enemy(String shortName, String longName, int health, Weapon weapon, Room room) {
        this.shortName = shortName;
        this.longName = longName;
        this.health = health;
        this.weapon = weapon;
        this.room = room;

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

    public void hit(int damage){
        health -= damage;
    }
    public String getDescription(){
        return description;
    }

}
