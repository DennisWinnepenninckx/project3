package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ucll.project.db.UserRepository;
import ucll.project.db.UserRepositoryDb;
import ucll.project.domain.user.User;

public class DeleteUser {

    private User user;
    private static WebDriver driver;
    private UserRepository db = new UserRepositoryDb();

    @Given("the admin is on the users page")
    public void the_admin_is_on_the_users_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Admin is on user page");
    }

    @When("the admin tries to delete a user")
    public void the_admin_tries_to_delete_a_user() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When");
    }

    @Then("the user will be deleted")
    public void the_user_will_be_deleted() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then");
    }
}
