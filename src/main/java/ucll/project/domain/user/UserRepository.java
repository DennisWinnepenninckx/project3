package ucll.project.domain.user;

import ucll.project.domain.star.Star;

import java.util.List;

public interface UserRepository {

    // CREATE
    void createUser(User user);

    // READ ONE
    User get(String email);

    // READ ALL
    List<User> getAll();

    // LOGIN (= GET but with password check)
    User loginUser(String username, String password) throws InvalidLogin;

    // UPDATE
    void update(User user);

    // DELETE
    void delete(User user);

    public List<Star> getStars();
}
