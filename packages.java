import MyPack.java;
class student{
    string name;
    int rollNo;
    double marks;
    void getData(){
        Scanner sc=new Scanner(system.in);
        System.out.println("enter name:");
        name=sc.nextLine();
        System.out.println("enter Roll No:");
        rollNo=sc.nextInt();
        System.out.println("Enter Marks:");
        marks=sc.nextDouble();
    }
    void showData(){
        System.out.println("\nStudent details");
        System.out.println("name:"+name);
        System.out.println("Roll No:"+rollNo);
        System.out.println("Marks:"+marks);
    }
}
public class Main{
    public static void main(String args[]){
        Student s=new Student();
        s.getData();
        s.showData();
    }
}