import java.util.Scanner;

public class Student {
    int Age;
    String Name;
    int Standard;
    String Section;

    public Student(int age, String name, int standard, String sec) {
        Age = age;
        Name = name;
        Standard = standard;
        Section = sec;
    }

    // method which can be accessed only by the object student class
    public void PrintNewStudent(Student newStudent){
        System.out.println("\n\n\nThe created object is  \nAge: " + newStudent.Age + "\nName: " + newStudent.Name + "\nStandard: " + newStudent.Standard
        + "\nSection: " + newStudent.Section);
    }

    // Method which doesnt need object to be accessed    
    static void StudentCreated(){
        System.out.println("\n\n\n-------------------------------------\n\nNEW STUDENT IS CREATED!!!!\n\n-------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please Enter your age");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        System.out.println("Please enter your Name");
        String userName = scanner.nextLine(); // Read name properly

        System.out.println("Please enter your standard");
        int standard = scanner.nextInt();
        scanner.nextLine(); // Consume leftover newline

        System.out.println("Please enter your section");
        String section = scanner.nextLine(); // Read section properly

        Student newStudent = new Student(age, userName, standard, section);

        StudentCreated();

        newStudent.PrintNewStudent(newStudent);
        
        scanner.close();
    }
}
