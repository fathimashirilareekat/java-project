package model;

public class Room {
    private int roomNo;
    private int capacity;
    private int allocated;

    // Getters and Setters

    public int getRoomNo() { return roomNo; }
    public void setRoomNo(int roomNo) { this.roomNo = roomNo; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getAllocated() { return allocated; }
    public void setAllocated(int allocated) { this.allocated = allocated; }
}
