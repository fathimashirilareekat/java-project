package model;

public class Student {
    private int id;
    private String name;
    private String admissionNo;
    private int keamRank;
    private String phone;
    private String email;
    private String year;
    private String hostelType;
    private String roomNo;

    // Constructor without ID (for registration)
    public Student(String name, String admissionNo, int keamRank, String phone,
                   String email, String year, String hostelType, String roomNo) {
        this.name = name;
        this.admissionNo = admissionNo;
        this.keamRank = keamRank;
        this.phone = phone;
        this.email = email;
        this.year = year;
        this.hostelType = hostelType;
        this.roomNo = roomNo;
    }

    // Constructor with ID (for fetching)
    public Student(int id, String name, String admissionNo, int keamRank, String phone,
                   String email, String year, String hostelType, String roomNo) {
        this.id = id;
        this.name = name;
        this.admissionNo = admissionNo;
        this.keamRank = keamRank;
        this.phone = phone;
        this.email = email;
        this.year = year;
        this.hostelType = hostelType;
        this.roomNo = roomNo;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getAdmissionNo() { return admissionNo; }
    public int getKeamRank() { return keamRank; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getYear() { return year; }
    public String getHostelType() { return hostelType; }
    public String getRoomNo() { return roomNo; }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", admissionNo='" + admissionNo + '\'' +
                ", keamRank=" + keamRank +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", year='" + year + '\'' +
                ", hostelType='" + hostelType + '\'' +
                ", roomNo='" + roomNo + '\'' +
                '}';
    }
}

