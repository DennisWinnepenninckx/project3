package ucll.project.application;

import ucll.project.domain.user.User;
import ucll.project.domain.user.UserRepositoryDb;

import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        //ExcelReadWrite.read();
        //User user = new User("arne.walschap@ucll.be","Arne","Walschap", "Andreas4Ever!", true);

        UserRepositoryDb db = new UserRepositoryDb();
        //db.createUser(user);
    }
}