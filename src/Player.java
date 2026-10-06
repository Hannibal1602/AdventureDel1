import java.util.ArrayList;

public class Player {

    private Room currentRoom;

    private int health = 100;

    private ArrayList<Item> inventory = new ArrayList<>();

    private Weapon equipped;

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
            if (item == equipped) {
                equipped = null;
            }
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
        if (equipped != null) {
            text += "\nEquipped: " + equipped.getLongName();
        }
        return text;
    }

    public EatResult eat(String shortName) {
        Item item = findItem(shortName);
        if (item == null) {
            item = currentRoom.findItem(shortName);
        }
        if (item == null) {
            return EatResult.NOT_FOUND;
        }
        if (!(item instanceof Food)) {
            return EatResult.NOT_FOOD;
        }
        Food food = (Food) item;
        health += food.getHealthPoints();
        removeItem(food);
        currentRoom.removeItem(food);
        return EatResult.EATEN;
    }

    public int getHealth() {
        return health;
    }
    public void setHealth(int health){
        this.health = health;
    }

    public String describeHealth() {
        String text;
        if (health >= 100) {
            text = "you are in perfect health";
        } else if (health >= 50) {
            text = "you are in good health, but avoid fighting right now";
        } else if (health >= 25) {
            text = "you are wounded - find something healthy to eat";
        } else if (health >= 1) {
            text = "you are barely alive";
        } else {
            text = "you should be dead";
        }
        return "health: " + health + " - " + text;
    }

    public String equip(String shortName) {
        Item item = findItem(shortName);
        if (item == null) {
            return "You don't have that";
        }
        if (!(item instanceof Weapon weapon)) {
            return item.getLongName() + " is not a weapon";
        }
        equipped = weapon;
        return "You have equipped " + weapon.getLongName();
    }

    public String attack() {
        if (equipped == null) {
            return "You have no weapon equipped";
        }
        if (!equipped.canUse()) {
            return "Your weapon is out of ammunition";
        }
        if(currentRoom.getEnemies().isEmpty()){
            equipped.use();
            return "You " + equipped.getAttackVerb() + " " + equipped.getLongName()
                    + " at the empty air. " + equipped.getUsesLeftText();
        }
        Enemy enemy = currentRoom.getEnemies().get(0);
        if(enemy.getHealth() < 0){
            return "Enemy is already dead";
        }
        equipped.use();
        enemy.hit(equipped.getDamage());
        if(enemy.getHealth() < 0){
            currentRoom.removeEnemy(enemy);
            return "You " + equipped.getAttackVerb() + " your weapon at a " + enemy.getLongName() + " and killed it";
        }
        enemy.attack(this);
        return "You " + equipped.getAttackVerb() + " your weapon at a " + enemy.getLongName() + " " + enemy.getHealth() + " HP remaining." + " The " + enemy.getShortName() + " attacks you for " + enemy.getDamage() + " HP";
    }
}