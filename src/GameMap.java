import java.util.ArrayList;

public class GameMap {

    private ArrayList<Room> rooms = new ArrayList<>();


        public Room buildMap() {
            Room room1 = new Room("Room1", "A dusty hall with a flickering torch.");
            Room room2 = new Room("Room2", "Old books line the walls in silence.");
            Room room3 = new Room("Room3", "Rusty pots hang from the ceiling.");
            Room room4 = new Room("Room4", "Chains rattle in the dark.");
            Room room5 = new Room("Room5", "Old swords rest against the walls.");
            Room room6 = new Room("Room6", "A golden throne sits empty.");
            Room room7 = new Room("Room7", "Overgrown vines cover the stone floor.");
            Room room8 = new Room("Room8", "A spiral staircase winds upward.");
            Room room9 = new Room("Room9", "Gold coins glitter in the shadows.");

            rooms.add(room1);
            rooms.add(room2);
            rooms.add(room3);
            rooms.add(room4);
            rooms.add(room5);
            rooms.add(room6);
            rooms.add(room7);
            rooms.add(room8);
            rooms.add(room9);

            // Række 1: forbundet vandret
            room1.setEast(room2);
            room2.setWest(room1);
            room2.setEast(room3);
            room3.setWest(room2);

            // Række 3: forbundet vandret
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

            Item lamp = new Item("lamp", "a shiny brass lamp");
            MeleeWeapon sword = new MeleeWeapon("sword", "a big sword", 30);
            Item hat = new Item("hat", "a magical hat");
            Food mushroom = new Food("mushroom", "a glowing mushroom",-30);
            Item coins = new Item("coins", "a stack of gold coins");
            Food beef = new Food("beef", "a juicy beefsteak", 30);
            Item diamonds = new Item("diamonds", "a chest full of diamonds");
            Item key = new Item("key", "an old rusty key");
            RangedWeapon crossbow = new RangedWeapon("crossbow", "a wooden crossbow", 20,5);
            Food apple = new Food("apple", "a golden apple", 50);
            Food bread = new Food("bread", "a loaf of bread", 10);
            MeleeWeapon club = new MeleeWeapon("club", "a round wooden club", 20);




            room1.addItem(lamp);
            room2.addItem(sword);
            room2.addItem(bread);
            room3.addItem(hat);
            room3.addItem(mushroom);
            room4.addItem(coins);
            room6.addItem(beef);
            room5.addItem(diamonds);
            room7.addItem(key);
            room8.addItem(crossbow);
            room9.addItem(apple);


            Enemy monster = new Enemy("monster", "A green monster", 70, sword, room2, "You have to kill the monster");
            room2.addEnemy(monster);
            Enemy troll = new Enemy("troll", "a green swamp troll", 60, club, room6, "You have to kill to troll");
            room6.addEnemy(troll);

            return room1; // startrummet, som Adventure skal bruge
        }

        public Room findRoom(String name){
            for(Room room : rooms){
                if(room.getName().equalsIgnoreCase(name)){
                    return room;
                }
            }
            return null;
        }

}

