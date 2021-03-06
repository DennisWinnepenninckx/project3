package ucll.project.domain.user;

import ucll.project.db.UserRepository;
import ucll.project.db.UserRepositoryDb;

import java.util.List;

public class UserService {
    private UserRepository userRepo;

    public UserService(){
        userRepo = new UserRepositoryDb();
    }

    public List<User> getUsers(){
        return userRepo.getAll();
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }
}
