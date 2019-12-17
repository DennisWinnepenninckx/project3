package StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GiveStar {
    @Given("Karel has not given {int} stars this month")
    public void karel_has_not_given_stars_this_month(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }

    @When("he gives a star to another user")
    public void he_gives_a_star_to_another_user() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("the other user receives a star")
    public void the_other_user_receives_a_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @Given("Karel has already given {int} stars this month")
    public void karel_has_already_given_stars_this_month(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }

    @When("Karel wants to give another user a star")
    public void karel_wants_to_give_another_user_a_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("Karel receives an error")
    public void karel_receives_an_error() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @Given("Karel wants to send a star without description")
    public void karel_wants_to_send_a_star_without_description() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }

    @When("Karel tries to send the star")
    public void karel_tries_to_send_the_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("Karel receives an error message")
    public void karel_receives_an_error_message() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @Given("A user doesn't add a tag to the star")
    public void a_user_doesn_t_add_a_tag_to_the_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }

    @Given("Karel has given {int} tags to a star")
    public void karel_has_given_tags_to_a_star(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }

    @When("Karel tries to add another tag to the star")
    public void karel_tries_to_add_another_tag_to_the_star() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When step");
    }

    @Then("Karel gets an error message")
    public void karel_gets_an_error_message() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Then step");
    }

    @Given("Karel wants to send a star to himself")
    public void karel_wants_to_send_a_star_to_himself() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given step");
    }
}
