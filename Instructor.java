import java.lang.Override;
import java.util.Scanner;

public class Instructor extends User {
    private static int nextInstructorId = 2001;
    private String specialization;
    public Instructor(String name, String specialization, String email, String password) {
        super(nextInstructorId++, name, email, password);
        setSpecialization(specialization);
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public void showProfile() {
        System.out.println("Instructor Profile");
        System.out.println("ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Specialization : " + getSpecialization());
        updatedMenu();
    }
    Scanner sc = new Scanner(System.in);

    @Override
    public void showDashboard() {

        while (true) {
            System.out.println("Instructor Dashboard");
            System.out.println("1. Show Profile\n2. Course Management\n3. Logout");
            int dashboardChoice = sc.nextInt(); sc.nextLine();
            switch (dashboardChoice) {
                case 1:
                    showProfile();
                    break;
                case 2:
                    courseManagement();
                    break;
                case 3:
                    return;
            }
        }
    }
    public void courseManagement() {
        System.out.println("1. Create Course\n2. View Course\n3. back");
        int input = sc.nextInt();
        sc.nextLine();
        switch (input){
            case 1:
                createCourse();
                break;
            case 2: viewCourse();
                break;
            case 3: return;
        }
    }
    public void createCourse() {
        System.out.println("Course Name: ");
        System.out.println("Course Duration: ");
        System.out.println("Course Description: ");
        String inputname = sc.nextLine();
        String inputduration = sc.nextLine();
        String inputdescription = sc.nextLine();
        Course course = new Course(inputname, inputduration, inputdescription);
        Main.courses.add(course);
        System.out.println(" Created successfully");
        System.out.println("Course ID:" + course.getCourseId());
    }
public void viewCourse(){
        for( Course course: Main.courses){
            System.out.println("ID :" + course.getCourseId());
            System.out.println(course.getCourseName());
        }
    if(!(Main.courses.isEmpty())){
    System.out.println("1. Update\n2. Delete\n3. Back");
        int viewCourseMenuInput = sc.nextInt(); sc.nextLine();
        switch (viewCourseMenuInput){
            case 1: updateCourseMenu(); break;
            case 2: deleteCourseMenu(); break;
            case 3: return;
        }
    } else {
        System.out.println("No course created");
    }}
public void updateCourseMenu(){

    System.out.println("Enter course Id to update.");
    int inputCourseId = sc.nextInt();sc.nextLine();
    Course selectedCourse = null;

     // to find the course exactly to be updated
    for (Course course: Main.courses){
        if(course.getCourseId() == inputCourseId){
            selectedCourse = course; break;
        }
    }
    System.out.println("1. Update Name\n" +
            "2. Update Duration\n" +
            "3. Update Description\n" +
            "4. Back");
    int updateMenuInput = sc.nextInt();sc.nextLine();
    switch (updateMenuInput){
        case 1: UpdateCourseName(selectedCourse);
                break;
        case 2: UpdateCourseDuration(selectedCourse);
            break;
        case 3: UpdateCourseDescription(selectedCourse);
            break;
        case 4: return;

    }


}
private void UpdateCourseName(Course course){
   if(!(course == null)){
       System.out.println("Enter new name");
       sc.nextLine();
       String newName = sc.nextLine();
       course.setCourseName(newName);
       System.out.println("Name Updated successfully");
   } else {
       System.out.println(" Course not Found");
   }
}
    private void UpdateCourseDuration(Course course){
       if(!(course==null)){
           System.out.println("Enter new Duration");
           sc.nextLine();
           String newDuration = sc.nextLine();
           course.setCourseDuration(newDuration);
           System.out.println("Duration Updated successfully");
       }
    }
    private void UpdateCourseDescription(Course course){
        if(!(course==null)){
        System.out.println("Type new description");
        sc.nextLine();
        String newDescription = sc.nextLine();
        course.setCourseDescription(newDescription);
        System.out.println("Description Updated successfully");}
    }
public void deleteCourseMenu(){
    System.out.println("Enter course ID to delete");
    int deleteMenuInput = sc.nextInt();sc.nextLine();
    Course selectedCourse = null;

    // find course exactly to be deleted
    for (Course course: Main.courses){
        if (course.getCourseId() == deleteMenuInput){
            selectedCourse = course; break;
        }
    }
    if(!(selectedCourse == null)){
        Main.courses.remove(selectedCourse);
        System.out.println("Course Deleted Successfully");

    } else {
        System.out.println("course doesn't exist");
    }

}

}

