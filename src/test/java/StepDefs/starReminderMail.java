package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class starReminderMail {

    @Given("Karel still has stars the day before he will lose them")
    public void karel_still_has_stars_the_day_before_he_will_lose_them() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("given for reminder mail" );
    }

    @When("the dat before the stars will be deleted has come")
    public void the_dat_before_the_stars_will_be_deleted_has_come() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("when for reminder mail" );
    }

    @Then("the mail will be sent to Karel with a reminder")
    public void the_mail_will_be_sent_to_Karel_with_a_reminder() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("then for reminder mail" );
    }

}
