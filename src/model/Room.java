package model;

public class Room {
    private String roomNo;   // use String for values like "B101", "G1"
    private int capacity;
    private int allocated;   // current number allocated

    public Room() {}

    // getters & setters
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getAllocated() {
        return allocated;
    }

    public void setAllocated(int allocated) {
        this.allocated = allocated;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNo='" + roomNo + '\'' +
                ", capacity=" + capacity +
                ", allocated=" + allocated +
                '}';
    }
}
