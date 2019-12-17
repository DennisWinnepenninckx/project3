package ucll.project.domain.user;

import ucll.project.domain.star.Star;

import java.util.List;

public class UserService {
    private UserRepository userRepo;

    public UserService(){
        userRepo = new UserRepositoryDb();
    }

    public List<User> getUsers(){
        return userRepo.getAll();
    }

    public List<Star>getStars(){
        return userRepo.getStars();
    }

    public UserRepository getUserRepo() {
        return userRepo;
    }
}
