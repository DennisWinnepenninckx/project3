$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/createUser.feature");
formatter.feature({
  "name": "Create a user",
  "description": "  As a superuser\n  I want to be able to create a user\n  So that users can give stars",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A superuser can make a new user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne makes a user with the following details:",
  "rows": [
    {
      "cells": [
        "lastname",
        "firstname",
        "email"
      ]
    },
    {
      "cells": [
        "Vanostet",
        "karrel",
        "ka@g.com"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CreateUser.arne_makes_a_user_with_the_following_details(DataTable)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user with the given details is created",
  "rows": [
    {
      "cells": [
        "lastname",
        "firstname",
        "email"
      ]
    },
    {
      "cells": [
        "Vanostet",
        "karrel",
        "ka@g.com"
      ]
    }
  ],
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.scenario({
  "name": "A superuser can\u0027t create an account with an email that already exists",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "a user with an email exists",
  "rows": [
    {
      "cells": [
        "email"
      ]
    },
    {
      "cells": [
        "arne.walschap@ucll.be"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Arne creates a user with this email",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUser.arne_creates_a_user_with_this_email()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "name": "A superuser can\u0027t create an account without filling in all fields",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.step({
  "name": "Arne creates an account with some of the \"\u003cdetails\u003e\" missing",
  "keyword": "When "
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "details"
      ]
    },
    {
      "cells": [
        "firstname"
      ]
    },
    {
      "cells": [
        "lastname"
      ]
    },
    {
      "cells": [
        "email"
      ]
    }
  ]
});
formatter.scenario({
  "name": "A superuser can\u0027t create an account without filling in all fields",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates an account with some of the \"firstname\" missing",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A superuser can\u0027t create an account without filling in all fields",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates an account with some of the \"lastname\" missing",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A superuser can\u0027t create an account without filling in all fields",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates an account with some of the \"email\" missing",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A superuser can\u0027t make a user his own manager",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates a user with himself as manager",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "A superuser can\u0027t make someone who doesn\u0027t exist manager",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates a user with as manager someone who doesn\u0027t exist",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUser.arne_creates_a_user_with_as_manager_someone_who_doesn_t_exist()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne sees an error",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.arne_sees_an_error()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "no account is created",
  "keyword": "And "
});
formatter.match({
  "location": "CreateUser.no_account_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A superuser can make someone manager of another user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Arne is on the create user page",
  "keyword": "Given "
});
formatter.match({
  "location": "CreateUser.arne_is_on_the_create_user_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Arne creates a user with a manager",
  "keyword": "When "
});
formatter.match({
  "location": "CreateUser.arne_creates_a_user_with_a_manager()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the account is created",
  "keyword": "Then "
});
formatter.match({
  "location": "CreateUser.the_account_is_created()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/giveStar.feature");
formatter.feature({
  "name": "giving another user stars",
  "description": "  as a user i want to be able to give a star to another user,\n  so that i can make him/her happy",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A user who has not given 3 stars this month can give another user a star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel has not given 3 stars this month",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.karel_has_not_given_stars_this_month(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he gives a star to another user",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.he_gives_a_star_to_another_user()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the other user receives a star",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.the_other_user_receives_a_star()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user who has given 3 stars this month can\u0027t give a star to another user",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel has already given 3 stars this month",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.karel_has_already_given_stars_this_month(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel wants to give another user a star",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.karel_wants_to_give_another_user_a_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel receives an error",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.karel_receives_an_error()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user doesn\u0027t add a description to the star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel wants to send a star without description",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.karel_wants_to_send_a_star_without_description()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel tries to send the star",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.karel_tries_to_send_the_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel receives an error message",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.karel_receives_an_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user doesn\u0027t add a tag to the star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "A user doesn\u0027t add a tag to the star",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.a_user_doesn_t_add_a_tag_to_the_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel tries to send the star",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.karel_tries_to_send_the_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel receives an error message",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.karel_receives_an_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user tries to add a fifth tag to a star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel has given 4 tags to a star",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.karel_has_given_tags_to_a_star(Integer)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel tries to add another tag to the star",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.karel_tries_to_add_another_tag_to_the_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel gets an error message",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.karel_gets_an_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "A user can\u0027t give himself a star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel wants to send a star to himself",
  "keyword": "Given "
});
formatter.match({
  "location": "GiveStar.karel_wants_to_send_a_star_to_himself()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel tries to send the star",
  "keyword": "When "
});
formatter.match({
  "location": "GiveStar.karel_tries_to_send_the_star()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel gets an error message",
  "keyword": "Then "
});
formatter.match({
  "location": "GiveStar.karel_gets_an_error_message()"
});
formatter.result({
  "status": "passed"
});
formatter.uri("file:src/test/resources/login.feature");
formatter.feature({
  "name": "Login",
  "description": "  As a user\n  I want to login\n  so that I can give stars",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "When somebody enters his correct credentials, he is logged in and gets to see the overview page",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel is on the login-page",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.Karel_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel is not logged in",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel has an account",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_has_an_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel enters correct credentials",
  "keyword": "When "
});
formatter.match({
  "location": "Login.Karel_enters_correct_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he is logged in and sees the overview page",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.he_is_logged_in_and_sees_the_overview_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "When somebody tries login with a nonexistent username, he gets an error",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.Karel_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel is on the login-page",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel has no account",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_has_no_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel enters nonexistent credentials",
  "keyword": "When "
});
formatter.match({
  "location": "Login.Karel_enters_nonexistent_credentials()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he gets an error :\"nonexisting user\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.he_gets_an_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "When somebody tries to login, but forgets a field, he gets an error",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karrel is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.karrel_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karrel is on the login-page",
  "keyword": "And "
});
formatter.match({
  "location": "Login.karrel_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karrel has an account",
  "keyword": "And "
});
formatter.match({
  "location": "Login.karrel_has_an_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karrel forgets a field",
  "keyword": "When "
});
formatter.match({
  "location": "Login.karrel_forgets_a_field()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he gets an error :\"empty field\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.he_gets_an_error(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "When somebody tries to login to an account but enters the wrong password, he gets an error",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel is not logged in",
  "keyword": "Given "
});
formatter.match({
  "location": "Login.Karel_is_not_logged_in()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel is on the login-page",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_is_on_the_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel has an account",
  "keyword": "And "
});
formatter.match({
  "location": "Login.Karel_has_an_account()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel enters the wrong password",
  "keyword": "When "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "he gets an error :\"wrong password\"",
  "keyword": "Then "
});
formatter.match({
  "location": "Login.he_gets_an_error(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.uri("file:src/test/resources/receiveMail.feature");
formatter.feature({
  "name": "Receive Mail",
  "description": "  As a user\n  I get a mail when I receive a star\n  So that I know",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "A user receives a mail when he receives a star",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Karel is an employee",
  "keyword": "Given "
});
formatter.match({
  "location": "ReceiveMail.karel_is_an_employee()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel gets a star from a colleague",
  "keyword": "When "
});
formatter.match({
  "location": "ReceiveMail.karel_gets_a_star_from_a_colleague()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Karel receives a mail telling him that he got a star",
  "keyword": "Then "
});
formatter.match({
  "location": "ReceiveMail.karel_receives_a_mail_telling_him_that_he_got_a_star()"
});
formatter.result({
  "status": "passed"
});
});