//import java.util.Scanner;

public class Course {
    private static int nxtCourseId = 100001;
    private int courseId;
    private String courseName;
    private String courseDuration;
    private String courseDescription;
//Scanner sc = new Scanner(System.in);
    public Course(String cName, String cDuration, String cDescription){
        this.courseId =nxtCourseId; nxtCourseId++;
        setCourseName(cName);
        setCourseDuration(cDuration);
        setCourseDescription(cDescription);
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }



}
