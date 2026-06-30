public class Admin extends User {
    private static int AdminId = 100;

    public Admin(String name, String email, String password) {
        super(AdminId++, name, email, password);
    }

}
