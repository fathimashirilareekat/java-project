import mypack.java;
import java.util.Scanner;

public class StudentMain {
    public static void main(String[] args) {
        final int TOTAL = 72;   
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[TOTAL];


        for (int i = 0; i < TOTAL; i++) {
            System.out.println("\nEnter details of Student " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Roll No: ");
            int roll = sc.nextInt();

            System.out.print("OOP Marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); 

            students[i] = new Student(name, roll, marks);
        }


        System.out.println("\n--- Student Details ---");
        for (Student s : students) {
            s.show();
        }

        sc.close();
    }
}
