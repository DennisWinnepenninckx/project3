package ucll.project.application;

import ucll.project.db.DBController;
import ucll.project.db.UserRepositoryDb;
import ucll.project.domain.user.User;

public class main {
    public static void main(String[] args) {
        //ExcelReadWrite.read();

        User user = new User();
        user.setEmail("superuser@test.be");
        user.setNewPassword("superuserpaswoord");
        user.setLastname("TEST");
        user.setFirstName("SUPERUSER");
        user.setSuperUser(false);
        user.setAdmin(true);
        user.setManager(false);

        DBController.getInstance().createUser(user);


        System.out.println(DBController.getInstance().getAllStars());

        //db.createUser(user);
    }
}