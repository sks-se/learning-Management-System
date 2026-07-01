import java.lang.Override;
import java.util.Scanner;

public class Admin extends User {
    private static int nextAdminId = 100;

    public Admin(String name, String email, String password) {
        super(nextAdminId++, name, email, password);
    }
    Scanner sc = new Scanner(System.in);
    @Override
    public void showDashboard(){
        while (true){
            System.out.println("System Admin Dashboard");
            System.out.println("1. Show Profile\n2. Manage Student\n3. Manage Instructor\n4. Manage Course\n5. Logout");
            int dashBoardChoice = sc.nextInt();
            switch(dashBoardChoice){
                case 1: showProfile();
                    break;
                case 2: manageStudent();
                    break;
                case 3: manageInstructor();
                    break;
                case 4: manageCourse();
                    break;
                case 5: return;
            }
        }
    }
    @Override
    public void showProfile(){
        System.out.println("System Admin");
        System.out.println("ID: " + getId() + "\n" +
                            "Name: " + getName() + "\n" +
                            "Email: " + getEmail());
        updatedMenu();

    }
    public void manageStudent(){
        while(true){
            System.out.println("1. View all student\n2. Remove Student\n3. Back");
            int manageStudentChoice = sc.nextInt();
            switch (manageStudentChoice){
                case 1:
                    viewAllStudents(); break;
                case 2:removeStudent(); break;
                case 3: return;
            }

        }
    }

    public void viewAllStudents(){
        for (User user: Main.students){
            System.out.println(user.getId() + " " + user.getName());
        }
    }

    public void removeStudent(){
        System.out.println("Enter Student Id");
        int inputStudentId = sc.nextInt();
        User selectedStudent = null;

        for (User student: Main.students){
            if(student.getId()== inputStudentId){
              selectedStudent = student; break;
            }
        }
        if (selectedStudent != null){
            Main.users.remove(selectedStudent);
            Main.students.remove(selectedStudent);
            System.out.println("Student removed !!");
        } else {
            System.out.println("Student not found");
         }
    }
    public void manageInstructor(){
        while(true){
            System.out.println("1. View all instructor\n2. Remove Instructor\n3. Back");
            int manageInstructorChoice = sc.nextInt();
            switch (manageInstructorChoice){
                case 1:
                    viewAllInstructors(); break;
                case 2:removeInstructor(); break;
                case 3: return;
            }

        }
    }
    public void viewAllInstructors(){
        for (User user: Main.instructor){
            System.out.println(user.getId() + " " + user.getName());
        }
    }
    public void removeInstructor(){
        System.out.println("Enter Instructor Id");
        int inputInstructorId = sc.nextInt();
        User selectedInstructor = null;

        for (User instructor: Main.instructor){
            if(instructor.getId()== inputInstructorId){
                selectedInstructor = instructor; break;
            }
        }
        if (selectedInstructor != null){
            Main.users.remove(selectedInstructor);
            Main.instructor.remove(selectedInstructor);
            System.out.println("Instructor removed !!");
        } else {
            System.out.println("Instructor not found");
        }
    }
    public void manageCourse(){
        while(true){
            System.out.println("1. View all course\n2. Remove Course\n3. Back");
            int manageCourseChoice = sc.nextInt();
            switch (manageCourseChoice){
                case 1:
                    viewAllCourse(); break;
                case 2:removeCourse(); break;
                case 3: return;
            }
        }
    }
    public void viewAllCourse(){
        for (Course course: Main.courses){
            System.out.println(course.getCourseId() +" "+ course.getCourseName());
        }
    }
    public void removeCourse(){
        System.out.println("Enter Course Id");
        int inputCourseId = sc.nextInt();
        Course selectedCourse = null;

        for (Course course: Main.courses){
            if(course.getCourseId()== inputCourseId){
                selectedCourse = course;break;
            }
        }
        if (selectedCourse != null){
            Main.courses.remove(selectedCourse);
            System.out.println("Course removed !!");
        } else {
            System.out.println("course not found");
        }
    }
}
