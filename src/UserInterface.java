import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {

    private Scanner scan = new Scanner(System.in);
    private Adventure adventure = new Adventure();

    public void startProgram() {
        System.out.println("Game start");
        System.out.println(adventure.look());

        boolean running = true;

        while (running) {
            String command = scan.nextLine();

            switch (command) {
                case "look" -> System.out.println(adventure.look());
                case "inventory" -> System.out.println(adventure.inventory());
                case "health" -> System.out.println(adventure.health());
                case "help" -> printHelp();
                case "attack" -> System.out.println(adventure.attack());
                case "exit" -> {
                    System.out.println("Goodbye");
                    running = false;

                }
                default -> handleCommandWithArgument(command);
            }
        }
    }

    private void handleCommandWithArgument(String command) {
        if (command.startsWith("go ")) {
            go(command.substring(3));
        }
        else if(command.startsWith("eat ")){
            eat(command.substring(4));
        }
        else if (command.startsWith("take ")) {
            take(command.substring(5));
        } else if (command.startsWith("drop ")) {
            drop(command.substring(5));
        } else if (command.startsWith("equip ")) {
            equip(command.substring(6));
        } else {
            System.out.println("Unknown command");
        }

    }

    private void go(String direction) {
        if (adventure.go(direction)) {
            System.out.println(adventure.look());
        } else {
            System.out.println("You cannot go that way");
        }
    }

    private void take(String shortName) {
        String taken = adventure.take(shortName);
        if (taken != null) {
            System.out.println("You took " + taken);
        } else {
            System.out.println("There is no such item");
        }
    }

    private void drop(String shortName) {
        String dropped = adventure.drop(shortName);
        if (dropped != null) {
            System.out.println("You dropped " + dropped);
        } else {
            System.out.println("There is no such item");
        }
    }

    private void printHelp() {
        System.out.println("go north");
        System.out.println("go east");
        System.out.println("go south");
        System.out.println("go west");
        System.out.println("take <item>");
        System.out.println("drop <item>");
        System.out.println("look");
        System.out.println("inventory");
        System.out.println("help");
        System.out.println("health");
        System.out.println("eat");
        System.out.println("exit");
    }

    private void eat(String shortName) {
        EatResult result = adventure.eat(shortName);

        switch (result) {
            case NOT_FOOD -> System.out.println("That item is not a food");
            case NOT_FOUND -> System.out.println("You can't find that item");
            case EATEN -> System.out.println("You ate the " + shortName);

        }
    }
    private void equip(String shortName) {
        System.out.println(adventure.equip(shortName));
    }

}

