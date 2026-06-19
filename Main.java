import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // #Home
        System.out.println("\n======================");
        System.out.println("LEARNING MANAGEMENT SYSTEM");
        System.out.println("======================");
        System.out.println("1. Login\n2. Register\n3. Exit");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Select Login Type");
                System.out.println("\n1. Student\n2. Instructor\n3. Admin");
                int loginChoice = sc.nextInt();

                break;

            case 2:
                System.out.println("Register Type");
                System.out.println("\n1. Student\n2. Instructor\n");
                int registerChoice = sc.nextInt();

                switch (registerChoice) {
                    case 1:
                        registerStudent();
                        break;
                    case 2:
                        registerinstructor();
                        break;
                    default:
                        System.out.println("Enter valid input");

                }
        }


    }

    public static void registerStudent() {
        System.out.println("Enter Name:\nEnter Email\nEnter Password");
        Scanner sc = new Scanner(System.in);
        String studentName = sc.next();
        String studentEmail = sc.next();
        String studentPassword = sc.next();
        Student student = new Student(studentName, studentEmail, studentPassword);
        System.out.println(" You have registered Successfully");
        System.out.println("Your Id: " + student.getId());
    }
    public static void registerinstructor(){
        System.out.println("Enter Name:\nEnter Email\nEnter Password");
        Scanner sc = new Scanner(System.in);
        String instructorName = sc.next();
        String instructorEmail = sc.next();
        String instructorPassword = sc.next();
        Instructor instructor = new Instructor(instructorName, instructorEmail, instructorPassword);
        System.out.println(" You have registered Successfully");
        System.out.println("Your Id: " + instructor.getId());
    }
}
