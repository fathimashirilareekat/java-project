package com.hostel.model;

public class Room {
    private int roomNo;
    private String hostelType;
    private int capacity;
    private int allocated;

    // Getters and Setters
    public int getRoomNo() { return roomNo; }
    public void setRoomNo(int roomNo) { this.roomNo = roomNo; }

    public String getHostelType() { return hostelType; }
    public void setHostelType(String hostelType) { this.hostelType = hostelType; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public int getAllocated() { return allocated; }
    public void setAllocated(int allocated) { this.allocated = allocated; }
}
