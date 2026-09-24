import java.util.Scanner;

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
        }

        public String getCommand() {
            return scan.nextLine();
        }

        public String extractDirection(String command) {
            return command.replace("go ", "");
        }
    }


