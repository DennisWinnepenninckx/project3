package ucll.project.application;

import ucll.project.db.ExcelReadWrite;
import ucll.project.domain.user.Role;
import ucll.project.domain.user.User;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //ExcelReadWrite.read();
        User user = new User("Andredead", "andr","ass","dennisw@live.Be", Role.USER);
        User karrel = new User("Karrel", "andr","ass","dennisw@live.Be", Role.USER);

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(karrel);
        //ExcelReadWrite.write(users);
    }
}
