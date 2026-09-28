import java.util.ArrayList;

public class Room {
    private String name;
    private String description;


    private Room north;
    private Room east;
    private Room south;
    private Room west;

    public Room(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Room getNorth(){
        return north;
    }
    public Room getSouth(){
        return south;
    }
    public Room getEast(){
        return east;
    }
    public Room getWest(){
        return west;
    }
    public void setNorth(Room north){
        this.north = north;
    }
    public void setSouth(Room south){
        this.south = south;
    }
    public void setEast(Room east){
        this.east = east;
    }
    public void setWest(Room west){
        this.west = west;
    }
    private ArrayList<Item> items = new ArrayList<>();


    public void addItem(Item item){
        items.add(item);
    }

    public void removeItem(Item item){
        items.remove(item);
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public Item findItem(String shortName) {
        for (Item item : items) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;   // ingen item med det navn i rummet
    }
    public String describe() {
        String text = "You are in " + name + "\n" + description;
        if (!items.isEmpty()) {
            text += "\nItems:";
            for (Item item : items) {
                text += "\n  " + item.getLongName();
            }
        }
        return text;
    }

}
