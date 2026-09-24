public class Player {

        private Room currentRoom;

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
    }


