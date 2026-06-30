import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> users = new ArrayList<>();

    public static void main(String[] args) {
 Admin admin = new Admin("System Admin", "amin@skslms.com", "admin@123");
        // #Home
        System.out.println("\n======================");
        System.out.println("LEARNING MANAGEMENT SYSTEM");
        System.out.println("======================");

        while (true) {
            System.out.println("1. Login\n2. Register\n3. Exit");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: //#login
                    User loggedInUser = loginUser();
                    if (loggedInUser != null) {
                        loggedInUser.showDashboard();
                    } else {
                        System.out.println("Invalid Id or Password !!!");
                    }
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
                            return;
                    }
                    break;
                case 3:
                    System.out.println("Thanks for Using SKS AI LMS");
                    return;
                default:
                    System.out.println("Please enter values from options");
            }

        }
    }

    public static void registerStudent() {
        System.out.println("Enter Name:\nEnter Email\nEnter Password");
        Scanner sc = new Scanner(System.in);
        String studentName = sc.nextLine();
        String studentEmail = sc.nextLine();
        String studentPassword = sc.next();
        Student student = new Student(studentName, studentEmail, studentPassword);
        users.add(student);

        System.out.println("You have registered Successfully");
        System.out.println("Your Id: " + student.getId());
    }

    public static void registerinstructor() {
        System.out.println("Enter Name:\nEnter Email\nEnter Password");
        Scanner sc = new Scanner(System.in);
        String instructorName = sc.nextLine();
        String instructorEmail = sc.nextLine();

        String instructorPassword = sc.nextLine();
        Instructor instructor = new Instructor(instructorName, instructorEmail, instructorPassword);
        users.add(instructor);
        System.out.println(" You have registered Successfully");
        System.out.println("Your Id: " + instructor.getId());
    }

    public static User loginUser() {
        System.out.println("Enter details to Login !!");
        Scanner sc = new Scanner(System.in);
        System.out.println("Id: \nPassword: ");
        int inputId = sc.nextInt();
        sc.skip("(\r\n|[\n\r\u2028\u2029\u0085]?)");
        String inputPassword = sc.next();
        for (User user : users) {
            if (inputId == user.getId() && inputPassword.equals(user.getPassword())) {
                System.out.println("Welcome " + user.getName());
                return user;
            }
        }
        return null;
    }


}
