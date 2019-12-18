package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import ucll.project.domain.user.User;
import ucll.project.db.UserRepository;
import ucll.project.db.UserRepositoryDb;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class CreateUser {
    private User user;
    private static WebDriver driver;
    private UserRepository db = new UserRepositoryDb();



    @Given("Arne is on the create user page")
    public void arne_is_on_the_create_user_page() {
        // Write code here that turns the phrase above into concrete actions
        /*driver.get(Config.BASE_URL);
        WebElement link = driver.findElement(By.xpath("//a[text() = 'Users']"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        link.click();*/
        System.out.println("Given step");
    }

    @When("Arne makes a user with the following details:")
    public void arne_makes_a_user_with_the_following_details(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        /*System.out.println(dataTable);
        String lastname = "";
        String firstname = "";
        String email = "";

        List<Map<String,String>> dtListMaps = dataTable.asMaps(String.class,String.class);
        for (int i=0; i<dtListMaps.size(); i++){
            lastname = dtListMaps.get(i).get("lastname");
            firstname = dtListMaps.get(i).get("firstname");
            email = dtListMaps.get(i).get("email");
        }

        user = new User(email,firstname,lastname,"password",false);
        db.createUser(user);

        //System.out.println(dtListMaps);
         */
        System.out.println("When step");
    }

    @Then("Karel with the given details is created")
    public void karel_with_the_given_details_is_created(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        String lastname = "";
        String firstname = "";
        String email = "";

        List<Map<String,String>> dtListMaps = dataTable.asMaps(String.class,String.class);
        for (int i=0; i<dtListMaps.size(); i++){
            lastname = dtListMaps.get(i).get("lastname");
            firstname = dtListMaps.get(i).get("firstname");
            email = dtListMaps.get(i).get("email");
        }
        User checkUser = db.get(email);
        assertTrue(checkUser!=null);
        assertTrue(checkUser.getEmail().equals(email));
        assertTrue(checkUser.getFirstName().equals(firstname));
        assertTrue(checkUser.getLastname().equals(lastname));
        db.delete(user);
        System.out.println("Then step");
    }

    @Given("Karel with an email exists")
    public void karel_with_an_email_exists(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        //        // For automatic transformation, change DataTable to one of
        //        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        //        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        //        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //        //
        //        // For other transformations you can register a DataTableType.
        System.out.println("Given step");
    }

    @When("Arne creates a user with this email")
    public void arne_creates_a_user_with_this_email() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("Arne sees an error")
    public void arne_sees_an_error() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @Then("no account is created")
    public void no_account_is_created() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @When("Arne creates an account with {string}, {string}, {string} where at least one is empty")
    public void arne_creates_an_account_with_where_at_least_one_is_empty(String string, String string2, String string3) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @When("Arne creates a user with as manager this user")
    public void arne_creates_a_user_with_as_manager_this_user() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @When("Arne creates a user with as manager someone who doesn't exist")
    public void arne_creates_a_user_with_as_manager_someone_who_doesn_t_exist() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @When("Arne creates a user with a manager")
    public void arne_creates_a_user_with_a_manager() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("the account is created")
    public void the_account_is_created() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }
}
