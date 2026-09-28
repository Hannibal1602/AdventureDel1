import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Scanner scan = new Scanner(System.in);

    public void printWelcome() {
        System.out.println("Game start");
    }

    public void printGoodbye() {
        System.out.println("Goodbye");
    }

    public void printRoom(Room room) {
        System.out.println("You are in " + room.getName());
        System.out.println(room.getDescription());
        printItems(room.getItems());
    }
    public void printItems(ArrayList<Item> items) {
        if (!items.isEmpty()) {
            System.out.println("Items:");
            for (Item item : items) {
                System.out.println("  " + item.getLongName());
            }
        }
    }

    public void printCannotGoThatWay() {
        System.out.println("You cannot go that way");
    }

    public void printHelp() {
        System.out.println("go north");
        System.out.println("go east");
        System.out.println("go south");
        System.out.println("go west");
        System.out.println("exit");
        System.out.println("look");
        System.out.println("help");
        System.out.println("take");
        System.out.println("drop");
    }

    public String getCommand() {
        return scan.nextLine();
    }

    public String extractDirection(String command) {
        return command.replace("go ", "");
    }

    public void printTaken(Item item) {
        System.out.println("You took " + item.getLongName());
    }
    public void printDropped(Item item) {
        System.out.println("You dropped " + item.getLongName());
    }
    public void printNoSuchItem() {
        System.out.println("There is no such item");
    }
    public void printUnknownCommand() {
        System.out.println("Unknown command");
    }
    public void printInventory(ArrayList<Item> inventory) {
        if (inventory.isEmpty()) {
            System.out.println("You are not carrying anything");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("  " + item.getLongName());
            }
        }
    }
}

