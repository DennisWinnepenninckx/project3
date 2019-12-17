package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReceiveMail {

    @Given("Dennis is an employee")
    public void dennis_is_an_employee() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the given step");
    }

    @When("Dennis gets a star from a colleague")
    public void dennis_gets_a_star_from_a_colleague() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the when step");
    }

    @Then("Dennis receives a mail telling him that he got a star")
    public void dennis_receives_a_mail_telling_him_that_he_got_a_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the then step");
    }
}
