public class Enemy {

    private String shortName;
    private String longName;
    private String description;
    private int health;

    public Enemy(String shortName, String longName, int health){
        this.shortName = shortName;
        this.longName = longName;
        this.health = health;
    }

    public String getShortName(){
        return shortName;
    }


}
