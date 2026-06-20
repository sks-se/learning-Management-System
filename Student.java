import java.lang.Override;
import java.util.Scanner;

public class Student extends User {

    public Student(String name, String email, String password){
        super(name, email, password);

    }
    @Override
    public void showProfile(){
        System.out.println("Student Profile");
        System.out.println("ID: "+ getId() +"\n"+
                    "Name: "+ getName()+"\n"+
                    "Email: "+ getEmail());
        return;

    }
    @Override
    public void showDashboard(){
        Scanner sc = new Scanner(System.in);
       while (true){
           System.out.println("Student Dashboard");
           System.out.println("1. Show Profile\n2. Logout");
           int dashboardChoice = sc.nextInt();
           switch(dashboardChoice){
               case 1:
                   showProfile(); break;
               case 2: return;
           }
       }

    }
}
