package ucll.project.application;

import ucll.project.domain.user.User;
import ucll.project.domain.user.UserRepositoryDb;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //ExcelReadWrite.read();
        User user = new User("dennisw@live.Be","andr","ass", "pass", true);
        User karrel = new User("dennisw@live.Be","andr","ass", "pass", false);

        ArrayList<User> users = new ArrayList<>();
        UserRepositoryDb db = new UserRepositoryDb();
        db.createUser(user);
        users.add(user);
        users.add(karrel);
        //ExcelReadWrite.write(users);
    }
}
