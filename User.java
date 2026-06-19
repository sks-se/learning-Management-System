

public class User {
    private static int nextId = 101;
    private int id;
    private String name;
    private String email;
    private String password;

    public User(String name, String email, String password){
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
        if(name == null){
            System.out.println("Empty name is not allowed.");
        }
        this.name = name;
    }
    // email update and get
    public String getEmail() { return email; }

    public void updateEmail(String email) {
        if (email == null){ System.out.println("Enter your email"); }
        if (email.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9_.-]+$")){
        this.email = email;  }}

    public String getPassword() { return password; }

    public void updatePassword(String password) { this.password = password; }

//    public class login(){
//
//    }
//    public class logout(){
//
//    }
//    public class showprofile(){
//
//    }
}
