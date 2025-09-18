package mypack;

public class Student {
    String name;
    int rollNo;
    int oopMarks;


    public Student(String name, int rollNo, int oopMarks) {
        this.name = name;
        this.rollNo = rollNo;
        this.oopMarks = oopMarks;
    }


    public void show() {
        System.out.println("Name: " + name +
                           " | Roll No: " + rollNo +
                           " | OOP Marks: " + oopMarks);
    }
}
