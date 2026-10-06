public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;
    private Weapon weapon;

    public Enemy(String shortName, String longName, int health, Weapon weapon) {
        this.shortName = shortName;
        this.longName = longName;
        this.health = health;
        this.weapon = weapon;
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


}
