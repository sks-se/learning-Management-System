import java.util.Scanner;

public class User {
    private static int nextId = 101;
    private int id;
    private String name;
    private String email;
    private String password;
    Scanner sc = new Scanner(System.in);

    public User(String name, String email, String password) {
        this.id = nextId++;
        setName(name);
        updateEmail(email);
        updatePassword(password);
    }

    public int getId() {
        return id;
    }

    // Name set and get
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            System.out.println("Empty name is not allowed.");
            return;
        }
        this.name = name;
    }

    // email update and get
    public String getEmail() {
        return email;
    }

    public void updateEmail(String email) {
        if (email == null) {
            System.out.println("Enter your email");
            return;
        }
        if (email.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9_.-]+$")) {
            this.email = email;
        }
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {

        if (password == null) {
            System.out.println("Enter your Password");
            return;
        }
        this.password = password;
    }


    public void showDashboard() {
        System.out.println("User Dashboard");
    }

    public void showProfile() {
        System.out.println("User Profile");
    }

    public void updatedMenu() {
        System.out.println("1. Update Name\n2. Update Email\n3. Change Password\n 4. Back");
        int updateChoice = sc.nextInt();
        sc.nextLine();
        switch (updateChoice) {
            case 1:
                System.out.println("Enter name");
                String newName = sc.nextLine();
                setName(newName);
                break;
            case 2:
                System.out.println("Enter new Email");
                String newEmail = sc.nextLine();
                updateEmail(newEmail);
                break;
            case 3:
                while (true) {
                    System.out.println("Enter your old password");
                    String oldPassword = sc.nextLine();
                    System.out.println("Enter new Password");
                    String newPassword = sc.nextLine();
                    if (oldPassword.equals(getPassword())) {
                        updatePassword(newPassword);
                        System.out.println("Password Updated successfully");
                        break;
                    } else {
                        System.out.println("Incorrect Old Password!! Try Again");
                    }
                }
                break;
            case 4:
                return;
        }
    }
}



