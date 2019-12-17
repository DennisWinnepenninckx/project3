package StepDefs;

import io.cucumber.java.en.*;

public class Login {
    @Given("Bobbe is on the login-page")
    public void bobbe_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Given("Bobbe is not logged in")
    public void bobbe_is_not_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("Bobbe has an account")
    public void bobbe_has_an_account() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("Bobbe enters correct credentials")
    public void bobbe_enters_correct_credentials() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("he is logged in and sees the overview page")
    public void he_is_logged_in_and_sees_the_overview_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }


    @Given("{string} is not logged in")
    public void is_not_logged_in(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("{string} is on the login-page")
    public void is_on_the_login_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Given("{string} has {string} account")
    public void has_account(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @When("{string} enters {string}")
    public void enters(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new cucumber.api.PendingException();
    }

    @Then("he gets an error :{string}")
    public void he_gets_an_error(String string) {
        // Write code here that turns the phrase above into concrete actions

    }

}
