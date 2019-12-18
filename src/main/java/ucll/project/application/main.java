package ucll.project.application;

import ucll.project.db.DBController;
import ucll.project.db.UserRepositoryDb;
import ucll.project.domain.user.User;

public class main {
    public static void main(String[] args) {
        //ExcelReadWrite.read();
/*
        User user = new User();
        user.setEmail("andreas.milants@gmail.com");
        user.setNewPassword("pushbanaan");
        user.setLastname("Milants");
        user.setFirstName("Andreas");
        user.setSuperUser(true);
        user.setAdmin(true);
        user.setManager(false);

        DBController.getInstance().createUser(user);

 */
        System.out.println(DBController.getInstance().getAllStars());

        //db.createUser(user);
    }
}