package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.Base;
import pages.LoginPage;

public class UserLoginSteps{
    

	WebDriver driver;
    Base base;
    LoginPage loginPage;

    @Given("the browser is open")
    public void openBrowser() {
        base = new Base();
        driver = Base.getDriver();
        base.initiateBrowser();
    }

    @And("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        loginPage = new LoginPage(driver);
        loginPage.loginOrRegister();
    }

//    @When("the user logs in with username {string} and password {string}")
    @When("^the user logs in with username (.+) and password (.+)$")
    public void userLogsIn(String username, String password) {
        loginPage.userName(username).password(password);
        loginPage.login();
    }

    @Then("the user logs in, logs out, and closes the browser")
    public void userLogsOutAndClosesBrowser() {
        base.logOut();
        driver.quit();
    }
    
    @Then("the user should get an error message")
    public void the_user_should_get_an_error_message() {
        loginPage.verifyLoginFailure();
    }
}
