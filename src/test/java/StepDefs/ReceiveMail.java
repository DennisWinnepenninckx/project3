package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ReceiveMail {

    @Given("Karel is an employee")
    public void karel_is_an_employee() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the given step");
    }

    @When("Karel gets a star from a colleague")
    public void karel_gets_a_star_from_a_colleague() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the when step");
    }

    @Then("Karel receives a mail telling him that he got a star")
    public void karel_receives_a_mail_telling_him_that_he_got_a_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("This is the then step");
    }

    @Then("his manager Andreas receives a mail telling him that Karel got a star")
    public void his_manager_Andreas_receives_a_mail_telling_him_that_Karel_got_a_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("manager");
    }
}
