package ucll.project.domain.user;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceTest {
    private UserService userService = new UserService();

    @Before
    public void addTestUserRobbe(){

        //userService.getUserRepo().createUser(new User("Rob","Robbe","De Bie","rob@gmail.com",Gender.valueOf("MALE"),Role.valueOf("USER")),"wwRob");
    }

    @After
    public void deleteTestUserRobbe(){
        //userService.getUserRepo().delete(new User("Rob","Robbe","De Bie","rob@gmail.com",Gender.valueOf("MALE"),Role.valueOf("USER")));
    }


    @Test
    public void getUsers_doesntReturnNull() {
        List<User> getUsersUsers = userService.getUsers();
        assertFalse(getUsersUsers == null);

    }


}