package ucll.project.db;

import ucll.project.domain.star.Star;
import ucll.project.domain.user.InvalidLogin;
import ucll.project.domain.user.User;

import java.util.List;

public class DBController {
    private StarDB starDB;
    private UserRepositoryDb userRepositoryDb;
    private static DBController dbController;

    private DBController() {
        starDB = new StarDB();
        userRepositoryDb = new UserRepositoryDb();
    }

    public static DBController getInstance() {
        if (dbController == null) {
            dbController = new DBController();
        }
        return dbController;
    }

    public List<User> getAllUsers() {
        return userRepositoryDb.getAll();
    }

    public void createUser(User user) {
        userRepositoryDb.createUser(user);
    }

    public User getUser(String email) {
        return userRepositoryDb.get(email);
    }

    public User loginUser(String email, String password) throws InvalidLogin {
        return userRepositoryDb.loginUser(email, password);
    }

    public void updateUser(User user) {
        userRepositoryDb.update(user);
    }

    public void deleteUser(User user) {
        userRepositoryDb.delete(user);
    }

    public List<Star> getAllStars() {
        return starDB.getAll();
    }

    public void createStar(Star star) {
        starDB.createStar(star);
    }

    public boolean userHasStars(User user) {
        return starDB.usersHasStars(user);
    }

    public List<String> getTagsOfStar(int starId) {
        return starDB.getTagsOfStar(starId);
    }

    public List<String> getTags() {
        return starDB.getTags();
    }

    public List<Star> getStarsUserGaveAway(User user) {
        return starDB.getAllGivenStarsUser(user);
    }

    public List<Star> getStarsUserReceived(User user) {
        return starDB.getAllReceivedStars(user);
    }

}
