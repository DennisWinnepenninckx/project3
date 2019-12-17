package ucll.project.domain.user;

public class DummyUserData {
    public static void addData(UserRepository userRepository) {
        userRepository.createUser(
                new User("admin",
                        "admin", "user",
                        "admin@example.com",
                        Role.ADMIN
                ),
                "admin" // password
        );
        userRepository.createUser(
                new User("support",
                        "support", "user",
                        "support@example.com",
                        Role.SUPPORT
                ),
                "support" // password
        );
        userRepository.createUser(
                new User("user",
                        "simple", "user",
                        "user@example.com"
                        , Role.USER
                ),
                "user" // password
        );
        userRepository.createUser(
                new User("user2",
                        "simple2", "user",
                        "user2@example.com", Role.USER
                ),
                "user2" // password
        );
    }
}
