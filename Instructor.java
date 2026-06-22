import java.lang.Override;
import java.util.Scanner;

public class Instructor extends User {
    public Instructor(String name, String email, String password) {
        super(name, email, password);
    }

    @Override
    public void showProfile() {
        System.out.println("Instructor Profile");
        System.out.println("ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "Email: " + getEmail());
        updatedMenu();
    }

    @Override
    public void showDashboard() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Instructor Dashboard");
            System.out.println("1. Show Profile\n2. Logout");
            int dashboardChoice = sc.nextInt();
            switch (dashboardChoice) {
                case 1:
                    showProfile();
                    break;
                case 2:
                    return;
            }
        }
    }
}

