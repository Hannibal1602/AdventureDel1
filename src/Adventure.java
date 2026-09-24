
public class Adventure {


        public static void main(String[] args) {
            Adventure adventure = new Adventure();
            adventure.start();
        }

        public void start() {
            UserInterface ui = new UserInterface();
            GameMap map = new GameMap();
            Player player = new Player();

            Room startRoom = map.buildMap();
            player.setCurrentRoom(startRoom);

            ui.printWelcome();
            ui.printRoom(player.getCurrentRoom());

            boolean gameRunning = true;

            while (gameRunning) {
                String command = ui.getCommand();

                switch (command) {
                    case "go north", "go south", "go east", "go west" -> {
                        String direction = ui.extractDirection(command);
                        boolean moved = player.move(direction);
                        if (moved) {
                            ui.printRoom(player.getCurrentRoom());
                        } else {
                            ui.printCannotGoThatWay();
                        }
                    }
                    case "exit" -> {
                        ui.printGoodbye();
                        gameRunning = false;
                    }
                    case "look" -> ui.printRoom(player.getCurrentRoom());
                    case "help" -> ui.printHelp();
                }
            }
        }
    }
