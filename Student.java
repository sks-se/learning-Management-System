import java.lang.Override;
import java.util.ArrayList;
import java.util.Scanner;

public class Student extends User {

    public Student(String name, String email, String password) {
        super(name, email, password);

    }

    private ArrayList<Course> enrolledCourse = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    @Override
    public void showProfile() {
        System.out.println("Student Profile");
        System.out.println("ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Email: " + getEmail());
        updatedMenu();
    }

    @Override
    public void showDashboard() {

        while (true) {
            System.out.println("Student Dashboard");
            System.out.println("1. Show Profile\n2. View Available courses\n3. My courses\n4. Logout");
            int dashboardChoice = sc.nextInt();
            sc.nextLine();
            switch (dashboardChoice) {
                case 1:
                    showProfile();
                    break;
                case 2:
                    viewAvailableCourse(); enrollCourse();
                    break;
                case 3:
                    myCourse(); removeCourse();
                    break;
                case 4:
                    return;
            }
        }

    }

    public void viewAvailableCourse() {

        for (Course course : Main.courses) {
            System.out.println("\n" + course.getCourseName() + ": " + course.getCourseId());
        }
    }

    public void enrollCourse() {
        System.out.println("1. Enroll to course\n2. back");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.print("Enter Course ID: ");
                int inputCourseID = sc.nextInt();
                Course selectedCourse = null;
                boolean courseExistence = false;
                //first loops to find course
                for (Course course : Main.courses) {
                    if (course.getCourseId() == inputCourseID) {
                        selectedCourse = course;
                        break;
                    }
                }
                if (selectedCourse != null) {
                    for (Course course1 : enrolledCourse) {
                        if (course1.getCourseId() == selectedCourse.getCourseId()) {
                            courseExistence = true;
                            break;
                        }
                    }
                    if (!courseExistence) {
                        enrolledCourse.add(selectedCourse);
                        System.out.println("Enrolled Successfully into " + selectedCourse.getCourseName());
                    } else {
                        System.out.println(" Already Enrolled");
                    }
                } else {
                    System.out.println("Course not found");
                }
                break;
            case 2:
                return;
        }
    }
    public void myCourse() {

        for (Course course : enrolledCourse) {
            System.out.println("\n" + course.getCourseName() + ": " + course.getCourseId());
        }

    }
    public void removeCourse() {
        System.out.println("1. Drop course\n2. Back");
        int option = sc.nextInt(); sc.nextLine();
        Course selectedCourse = null;
        switch (option) {
            case 1:
                System.out.println("Enter course Id to Drop");
                int inputId = sc.nextInt();
            for (Course course : enrolledCourse) {
                if (course.getCourseId() == inputId) {
                    selectedCourse = course;break;
                }
            }
            if (selectedCourse != null) {
                enrolledCourse.remove(selectedCourse);
                System.out.println("Course dropped");
            } else {
                System.out.println("Course not enrolled");
            } break;
            case 2: return;
        }
    }
}

