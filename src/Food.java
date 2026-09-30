public class Food extends Item {
    private int healthPoints;

    public Food(String shortName, String longName, int healthPoints) {
        super(shortName, longName);
        this.healthPoints = healthPoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }
    @Override
    public String getLongName(){
        return "something edible (" + healthPoints + " health)" + " " + shortName;
    }
}
