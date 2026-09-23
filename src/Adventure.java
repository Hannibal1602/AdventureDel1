import java.util.Scanner;

public class Adventure {
    public static void main(String[] args) {


    }

    static Room currentRoom;

    public static void moveNorth() {

        Room next = currentRoom.getNorth();

        if (next != null) {
            currentRoom = next;
            System.out.println("You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("You cannot go that way");
        }

    }

    public static void moveSouth() {

        Room next = currentRoom.getSouth();

        if (next != null) {
            currentRoom = next;
            System.out.println("You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("You cannot go that way");
        }

    }

    public static void moveEast() {

        Room next = currentRoom.getEast();

        if (next != null) {
            currentRoom = next;
            System.out.println("You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("You cannot go that way");
        }
    }

    public static void moveWest() {

        Room next = currentRoom.getWest();

        if (next != null) {
            currentRoom = next;
            System.out.println("You are in " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        } else {
            System.out.println("You cannot go that way");
        }

    }

    public void start() {
        Room room1 = new Room("Room1", "A dusty hall with a flickering torch.");
        Room room2 = new Room("Room2", "Old books line the walls in silence.");
        Room room3 = new Room("Room3", "Rusty pots hang from the ceiling.");
        Room room4 = new Room("Room4", "Chains rattle in the dark.");
        Room room5 = new Room("Room5", "Old swords rest against the walls.");
        Room room6 = new Room("Room6", "A golden throne sits empty.");
        Room room7 = new Room("Room7", "Overgrown vines cover the stone floor.");
        Room room8 = new Room("Room8", "A spiral staircase winds upward.");
        Room room9 = new Room("Room9", "Gold coins glitter in the shadows.");


        // Række 1: forbundet vandret
        room1.setEast(room2);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);

        //Række 3: forbundet vandret
        room7.setEast(room8);
        room8.setWest(room7);
        room8.setEast(room9);
        room9.setWest(room8);

        // Række 2: room4 til room6 forbindes UDENOM room5
        room4.setEast(room6);
        room6.setWest(room4);

        // Lodrette forbindelser i venstre og højre kolonne
        room1.setSouth(room4);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room7.setNorth(room4);

        room3.setSouth(room6);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room9.setNorth(room6);

        // Den ENESTE vej ind i room5: gennem room8
        room8.setNorth(room5);
        room5.setSouth(room8);
        boolean gameNotFinished = false;
        currentRoom = room1;
        System.out.println("Game start");
        System.out.println("You are in " + currentRoom.getName());
        System.out.println(currentRoom.getDescription());
        Scanner scan = new Scanner(System.in);
        while (!gameNotFinished) {
            String i = scan.nextLine();
            switch (i) {
                case "go north":
                    moveNorth();
                    break;
                case "go south":
                    moveSouth();
                    break;
                case "go east":
                    moveEast();
                    break;
                case "go west":
                    moveWest();
                    break;
                case "exit":
                    System.out.println("Goodbye");
                    gameNotFinished = true;
                    break;
                case "look":
                    System.out.println(currentRoom.getName());
                    System.out.println(currentRoom.getDescription());
                    break;
                case "help":
                    System.out.println("go north");
                    System.out.println("go east");
                    System.out.println("go south");
                    System.out.println("go west");
                    System.out.println("exit");
                    System.out.println("look");
                    System.out.println("help");

            }
        }

    }
}