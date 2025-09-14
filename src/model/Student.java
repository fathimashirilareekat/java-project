package model;

public class Student {
    private int id;
    private String name;
    private String admissionNo;
    private int keamRank;
    private String phone;
    private String address;
    private int roomNo;
    private String password;

    // Getters and Setters for all fields

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAdmissionNo() { return admissionNo; }
    public void setAdmissionNo(String admissionNo) { this.admissionNo = admissionNo; }

    public int getKeamRank() { return keamRank; }
    public void setKeamRank(int keamRank) { this.keamRank = keamRank; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public int getRoomNo() { return roomNo; }
    public void setRoomNo(int roomNo) { this.roomNo = roomNo; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
