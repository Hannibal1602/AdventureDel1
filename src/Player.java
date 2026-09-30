import java.util.ArrayList;

public class Player {

    private Room currentRoom;

    private int health;

    public void setCurrentRoom(Room room) {
        currentRoom = room;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {
        Room desiredRoom = switch (direction) {
            case "north" -> currentRoom.getNorth();
            case "south" -> currentRoom.getSouth();
            case "east" -> currentRoom.getEast();
            case "west" -> currentRoom.getWest();
            default -> null;
        };

        if (desiredRoom != null) {
            currentRoom = desiredRoom;
            return true;
        } else {
            return false;
        }

    }

    private ArrayList<Item> inventory = new ArrayList<>();

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);
    }

    public ArrayList<Item> getItems() {
        return inventory;
    }

    public Item findItem(String shortName) {
        for (Item item : inventory) {
            if (item.getShortName().equalsIgnoreCase(shortName)) {
                return item;
            }
        }
        return null;
    }

    public Item takeItem(String shortName) {
        Item item = currentRoom.findItem(shortName);
        if (item != null) {
            currentRoom.removeItem(item);
            inventory.add(item);
        }
        return item;
    }

    public Item dropItem(String shortName) {
        Item item = findItem(shortName);
        if (item != null) {
            inventory.remove(item);
            currentRoom.addItem(item);
        }
        return item;
    }

    public ArrayList<Item> getInventory() {
        return inventory;
    }

    public String look() {
        return currentRoom.describe();
    }

    public String describeInventory() {
        if (inventory.isEmpty()) {
            return "You are not carrying anything";
        }
        String text = "You are carrying:";
        for (Item item : inventory) {
            text += "\n  " + item.getLongName();
        }
        return text;
    }

    public EatResult eat(String shortName){
        Item item = findItem(shortName);
        if(item == null){
            item = currentRoom.findItem(shortName);
        }
        if(item == null){
            return EatResult.NOT_FOUND;
        }
        if(!(item instanceof Food)){
            return EatResult.NOT_FOOD;
        }
        Food food = (Food) item;
        health += food.getHealthPoints();
        removeItem(food);
        currentRoom.removeItem(food);
        return EatResult.EATEN;
    }

    public int getHealth(){
        return health;
    }

}

